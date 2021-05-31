/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.medical.in.dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.icefaces.impl.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import www.medical.in.commons.HibernateDao;
import www.medical.in.entities.MUser;
import www.medical.in.entities.TInspection;
import www.medical.in.entities.TLocation;
import www.medical.in.entities.TUpload;
import www.medical.in.entities.TlocationImage;

@Repository("loginDao")
@Transactional
public class LoginDaoImpl extends HibernateDao implements LoginDao {

    @Autowired
    public SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public LoginDaoImpl() {
        System.out.println("In LoginDaoImpl");
    }

    @Override
    public String getAppNoBySearch(JsonObject jo) {
        String result = "";
        Session session = null;
        //String applicantid = jo.get("applicantid").toString();
        int applicantid = jo.get("applicantid").getAsInt();
        try {
            session = getSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("execute GetApplicationNumberBySearch :param1");

            System.out.println("Query" + query);
            //query.setString("param1", applicantid);
            query.setInteger("param1", applicantid);
            System.out.println("applicantid::" + applicantid);

            List userList = query.list();
            System.out.println("userlist::" + userList);
            if (userList != null && userList.size() > 0) {
                System.out.println("size" + userList);
                System.out.println("size" + userList.size());
                System.out.println("count" + userList.get(0).toString());

                for (int i = 0; i < userList.size(); i++) {
                    Object[] os = (Object[]) userList.get(i);

                    result = "{\"dept_name\":\"" + os[0] + "\",\"date_of_application\":\"" + os[1] + "\","
                            + "\"approved_by\":\"" + os[2] + "\"}";
                }
            } else {
                result = "{\"status\":\"Failed\",\"statusmessage\":\"No data available with this Applicant ID\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Request failed\"}";
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //Not in use
    @Override
    public String getDepatmentList(JsonObject jo) {
        String result = "";
        Session session = null;

        int district_id = jo.get("district_id").getAsInt();
        int mandal_id = jo.get("mandal_id").getAsInt();
        int village_id = jo.get("village_id").getAsInt();
        int role_id = jo.get("role_id").getAsInt();

        JsonObject statusobject = new JsonObject();

        try {
            for (int status = 1; status < 8; status++) {
                session = getSessionFactory().openSession();
                SQLQuery query = session.createSQLQuery("execute SP_DepatmentList :param1,:param2,:param3,:param4,:param5");

                System.out.println("Query" + query);
                query.setInteger("param1", district_id);
                System.out.println("district_id::" + district_id);
                query.setInteger("param2", mandal_id);
                query.setInteger("param3", village_id);
                query.setInteger("param4", role_id);
                query.setInteger("param5", status);
                System.out.println("status::::" + status);

                List userList = query.list();
                System.out.println("userlist::" + userList);
                if (userList != null && userList.size() > 0) {
                    System.out.println("size" + userList);
                    System.out.println("size" + userList.size());
                    System.out.println("count" + userList.get(0).toString());

                    //for (status = 1; status < 8; status++) {
                    for (int i = 0; i < userList.size(); i++) {
                        Object[] os = (Object[]) userList.get(i);

                        System.out.println("transaction_id::" + os[1]);
                        System.out.println("registration_id::" + os[2]);
                        System.out.println("entrapreneur_id::" + os[3]);
                        System.out.println("name::" + os[4]);

                        JsonObject jso1 = new JsonObject();
                        JsonArray childmultiple = new JsonArray();

                        jso1.addProperty("transaction_id", "" + os[0]);
                        jso1.addProperty("registration_id", "" + os[1]);
                        jso1.addProperty("entrapreneur_id", "" + os[2]);
                        jso1.addProperty("name", "" + os[3]);
                        jso1.addProperty("service_id", "" + os[4]);
                        jso1.addProperty("service_name", "" + os[5]);
                        jso1.addProperty("applicant_id", "" + os[6]);
                        jso1.addProperty("approval_status_id", "" + os[7]);
                        jso1.addProperty("role_id", "" + os[8]);
                        jso1.addProperty("role_name", "" + os[9]);
                        jso1.addProperty("firm_name", "" + os[10]);

                        statusobject.add("" + status, jso1);
                        System.out.println("json" + statusobject);

                        childmultiple.add(statusobject);
                        result = "{\"status\":\"Success\",\"responseobject\":" + childmultiple + "}";
                    }
                } else {
                    //result = "{\"status\":\"Success\",\"responseobject\":\"No data available\"}";
                    statusobject.addProperty("" + status, "");
                    result = "{\"status\":\"Success\",\"responseobject\":" + statusobject + "}";
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Request failed\"}";
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //In use
    @Override
    public String getUserDetails(JsonObject jo) {
        String result = "";
        Session session = null;

        session = getSessionFactory().openSession();
        try {
            session = getSessionFactory().openSession();

            String qury = " from MUser where username ='" + jo.get("username").getAsString() + "' "
                    + "AND password='" + jo.get("password").getAsString() + "'";
            List tempList = session.createQuery(qury).list();

            if (tempList != null && tempList.size() > 0) {
                MUser users = (MUser) tempList.get(0);

                JsonObject json = new JsonObject();
                json.addProperty("user_id", "" + users.getId());
                //json.addProperty("mobile_no", users.getMobileNumber());
                //json.addProperty("dob", "" + users.getDob());
                //json.addProperty("date_join", "" + users.getDateOfJoin());
                //json.addProperty("email_id", users.getEmailID());
                json.addProperty("mandal_id", "" + users.getMandalId());
                //json.addProperty("address", users.getAddress());
                //json.addProperty("security_question_id","" + users.getSecurityQuestionId());
                json.addProperty("village_id", "" + users.getVillageId());
                //json.addProperty("answer", users.getAnswer());
                json.addProperty("role_id", users.getRoleId());
                //json.addProperty("created_by", users.getCreatedBy());
                //json.addProperty("created_on", "" + users.getCreatedOn());
                //json.addProperty("modified_by", users.getModifiedBy());
                //json.addProperty("modified_on", "" + users.getModifiedOn());
                //json.addProperty("user_type", users.getUserType());
                //json.addProperty("department_id", users.getDepartmentId());
                //json.addProperty("jurisdiction_id", users.getJurisdictionId());
                //json.addProperty("userlevel_id", users.getUserLevelId());
                json.addProperty("designation_id", users.getDesignationId());
                //json.addProperty("pan_no", users.getPanNumber());
                json.addProperty("district_id", "" + users.getDistrictId());
                //json.addProperty("aadhaar_no", "" + users.getAadhar());                

                result = "{\"status\":\"success\",\"result_object\":" + json + "}";
                System.out.println("json" + json);

                System.out.println("districtid::::" + users.getDistrictId());

            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Wrong username and password\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public String getApplicantDetails(JsonObject jo) {
        String result = "";
        Session session = null;
        int user_id = jo.get("user_id").getAsInt();
        JsonArray childmultiple = new JsonArray();

        try {
            session = getSessionFactory().openSession();
            //SQLQuery query = session.createSQLQuery("execute Pro_GetApplicantID :param1");
            //SQLQuery query = session.createSQLQuery("select * from t_transaction where CurrentDesignationId = "+ role_id+" ");
            SQLQuery query = session.createSQLQuery("execute GetApplicantDetails :param1");
            //select *from t_transaction t join m_designation d on t.CurrentDesignationId=d.Id join m_user u on u.DesignationId=d.Id where u.Id=21 and StatusId=5
            query.setInteger("param1", user_id);
            System.out.println("Query" + query);
            //query.setInteger("param1", role_id);
            System.out.println("userid::::" + user_id);

            List userList = query.list();
            System.out.println("userlist::" + userList);
            if (userList != null && userList.size() > 0) {
                System.out.println("size" + userList);
                System.out.println("size" + userList.size());
                System.out.println("count" + userList.get(0).toString());

                for (int i = 0; i < userList.size(); i++) {
                    Object[] os = (Object[]) userList.get(i);
                    JsonObject jso1 = new JsonObject();

                    jso1.addProperty("applicant_id", "" + os[0]);
                    jso1.addProperty("licence_number", "" + os[1]);
                    jso1.addProperty("licence_issued_date", "" + os[2]);
                    jso1.addProperty("licence_expiry_date", "" + os[3]);
                    jso1.addProperty("created_userid", "" + os[4]);

                    System.out.println("json" + jso1);
                    childmultiple.add(jso1);
                    System.out.println("childmultiple" + childmultiple);
                }
                result = "{\"status\":\"success\",\"responsearray\":" + childmultiple + "}";
            } else {
                result = "{\"status\":\"Failed\",\"responseobject\":\"No Data Available \"}";
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Request failed\"}";
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //In use
    @Override
    public String saveInspectionAnswerDetails(JsonObject jo) {
        String result = "";
        Session session = null;
        int regid;
        Date date = new Date();
        JsonObject detailsObject = jo.get("detailsobject").getAsJsonObject();
        JsonArray answerarrayobject = jo.get("answerarrayobject").getAsJsonArray();

        try {
            session = getSessionFactory().openSession();

            for (int i = 0; i < answerarrayobject.size(); i++) {
                TInspection tinspection = new TInspection();
                JsonObject json = (JsonObject) answerarrayobject.get(i);

                if (detailsObject.get("transaction_id") != null) {
                    tinspection.setTransactionId(detailsObject.get("transaction_id").getAsInt());
                }
                if (detailsObject.get("dept_user_id") != null) {
                    tinspection.setDepartmentUserId(detailsObject.get("dept_user_id").getAsInt());
                }
                tinspection.setCreatedOn(date);
                if (json.get("qid") != null) {
                    tinspection.setQuestionId(json.get("qid").getAsInt());
                }
                if (json.get("aid") != null) {
                    tinspection.setAnswer(json.get("aid").getAsString());
                }
                if (json.get("application_type") != null) {
                    tinspection.setAnswer(detailsObject.get("application_type").getAsString());
                }
                tinspection.setCreatedOn(date);

                regid = (int) session.save(tinspection);
                System.out.println("regid" + regid);
                session.save(tinspection);
            }
            //session.getTransaction().commit();
            result = "{\"status\":\"Success\",\"statusMessage\":\"Data Saved Successfully\"}";
//            
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Sync failed\"}";
            return result;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public String login(JsonObject jo) {
        String result = "";
        Session session = null;
        String dist, mandal, village;

        try {
            session = getSessionFactory().openSession();
            //String query = " from MUser where userName='" + jo.get("username") + "' AND password='" + jo.get("password") + "'";

            String query = " from MUser where userName ='" + jo.get("username").getAsString() + "' AND password='" + jo.get("password").getAsString() + "'";
            List tempList = session.createQuery(query).list();
            if (tempList != null && tempList.size() > 0) {

                MUser musers = (MUser) tempList.get(0);

                if (musers.getDistrictId() == null) {
                    dist = "";
                } else {
                    dist = musers.getDistrictId().toString();
                }
                if (musers.getMandalId() == null) {
                    mandal = "";
                } else {
                    mandal = musers.getMandalId().toString();
                }
                if (musers.getVillageId() == null) {
                    village = "";
                } else {
                    village = musers.getVillageId().toString();
                }

                JsonObject json = new JsonObject();
                json.addProperty("designationId", musers.getDesignationId());
                json.addProperty("districtID", dist);
                json.addProperty("mandalId", mandal);
                json.addProperty("villageId", village);

                result = "{\"status\":\"Success\",\"status_object\":" + json + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Wrong username and password\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //In use
    @Override
    public String getFacilityList(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonArray facility_array = new JsonArray();
        try {
            session = getSessionFactory().openSession();

            SQLQuery query = session.createSQLQuery("select Id,Name,inspectionpartialviewname From "
                    + "m_facility where Id in (select value FROM t_facility CROSS APPLY STRING_SPLIT(Facilities , ',') "
                    + "where TransactionId=" + jo.get("transaction_id").getAsInt() + ")");
            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {

                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);
                    JsonObject jso1 = new JsonObject();

                    jso1.addProperty("id", "" + os[0]);
                    jso1.addProperty("name", "" + os[1]);
                    jso1.addProperty("inspection_partial_view_name", "" + os[2]);

                    System.out.println("json" + jso1);
                    facility_array.add(jso1);
                    System.out.println("facility_array" + facility_array);
                }
                result = "{\"status\":\"success\",\"responsearray\":" + facility_array + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"No data available\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //In use
    @Override
    public String getApplicantAndFacilityDetails(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonObject jso1 = new JsonObject();
        JsonArray facility_array = new JsonArray();
        try {
            session = getSessionFactory().openSession();

            SQLQuery query = session.createSQLQuery("execute SP_GetApplicantAndFacilityDetails :param1");

            query.setInteger("param1", jo.get("transaction_id").getAsInt());

            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {

                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);
                    //JsonObject jso1 = new JsonObject();

                    jso1.addProperty("facility_name", "" + os[0]);
                    jso1.addProperty("facility_house_no", "" + os[1]);
                    jso1.addProperty("facility_street_no", "" + os[2]);
                    jso1.addProperty("facility_district", "" + os[3]);
                    jso1.addProperty("facility_mandal", "" + os[4]);
                    jso1.addProperty("facility_village", "" + os[5]);
                    jso1.addProperty("facility_phone", "" + os[6]);
                    jso1.addProperty("facility_email", "" + os[7]);
                    jso1.addProperty("applicant_name", "" + os[8]);
                    jso1.addProperty("applicant_house_no", "" + os[9]);
                    jso1.addProperty("applicant_street_no", "" + os[10]);
                    jso1.addProperty("applicant_district", "" + os[11]);
                    jso1.addProperty("applicant_mandal", "" + os[12]);
                    jso1.addProperty("applicant_village", "" + os[13]);
                    jso1.addProperty("applicant_phone", "" + os[14]);
                    jso1.addProperty("applicant_email", "" + os[15]);

                    System.out.println("json" + jso1);
                    //facility_array.add(jso1);
                    //System.out.println("facility_array" + facility_array);
                }
                result = "{\"status\":\"success\",\"responsObject\":" + jso1 + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"No data available\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //In use
    @Override
    public String getEquipmentList(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonArray equipment_array = new JsonArray();

        try {
            session = getSessionFactory().openSession();

            SQLQuery query = session.createSQLQuery("select * From t_equipment where TransactionId=" + jo.get("transaction_id").getAsInt() + "");

            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {

                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);
                    JsonObject jso1 = new JsonObject();

                    jso1.addProperty("name", "" + os[2]);
                    jso1.addProperty("serial_number", "" + os[3]);
                    jso1.addProperty("machine_model", "" + os[4]);
                    jso1.addProperty("make", "" + os[5]);
                    jso1.addProperty("type", "" + os[6]);
                    jso1.addProperty("uploaded_file_path", "" + os[7]);
                    jso1.addProperty("created_user_id", "" + os[9]);

                    System.out.println("json" + jso1);
                    equipment_array.add(jso1);
                    System.out.println("facility_array" + equipment_array);
                }
                result = "{\"status\":\"success\",\"responsearray\":" + equipment_array + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"No data available\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //In use
    @Override
    public String getEmployeeList(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonArray equipment_array = new JsonArray();

        try {
            session = getSessionFactory().openSession();

            SQLQuery query = session.createSQLQuery("execute SP_GetEmployeeDetails :param1");

            query.setInteger("param1", jo.get("transaction_id").getAsInt());

            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {

                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);
                    JsonObject jso1 = new JsonObject();

                    jso1.addProperty("name", "" + os[1]);
                    jso1.addProperty("designation", "" + os[2]);
                    jso1.addProperty("experience", "" + os[3]);
                    jso1.addProperty("registration_no", "" + os[4]);

                    System.out.println("json" + jso1);
                    equipment_array.add(jso1);
                    System.out.println("facility_array" + equipment_array);
                }
                result = "{\"status\":\"success\",\"responsearray\":" + equipment_array + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"No data available\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //In use
    @Override
    public String getListofApplicationsCount(JsonObject jo) {
        String result = "";
        Session session = null;
        JsonArray applicant_count = new JsonArray();
        JsonObject jso1 = new JsonObject();

        try {
            session = getSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("execute GetListofApplicationsCount :param1");

            query.setInteger("param1", jo.get("user_id").getAsInt());

            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {

                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);

                    jso1.addProperty("drafts", "" + os[0]);
                    jso1.addProperty("submitted", "" + os[1]);
                    jso1.addProperty("approved", "" + os[2]);
                    jso1.addProperty("query_raised", "" + os[3]);

                    System.out.println("json" + jso1);
                    applicant_count.add(jso1);
                    System.out.println("applicant_count" + jso1);
                }
                result = "{\"status\":\"success\",\"respons_object\":" + jso1 + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"No data available\"}";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //In use
    @Override
    public String getApplicationNoList(JsonObject jo) {
        Session session = null;
        String result = "";

        JsonArray responsearray = new JsonArray();

        try {
            session = getSessionFactory().openSession();
            //SQLQuery query = session.createSQLQuery("GetAppNoListForApplicantAndroid :param1");
            //query.setInteger("param1", jo.get("user_id").getAsInt());
            SQLQuery query = session.createSQLQuery("SELECT DISTINCT ta.Id as ApplicationId, TR.Id AS TransactionId, "
                    + "ta.ApplicationNumber as ApplicationNumber,FORMAT(ta.CreatedOn, 'dd-MM-yyyy') AS CreatedOn, "
                    + "FORMAT(ta.LastModifiedOn, 'dd-MM-yyyy') AS\n"
                    + "LastModifiedOn, ta.HasACK as HasACK, 'Transaction' AS TableName,se.Name AS ServiceName FROM t_application ta \n"
                    + "join t_transaction tr ON ta.Id=tr.ApplicationId join m_service se ON tr.ServiceId= se.Id\n"
                    + "WHERE tr.StatusId not in(10,11,8,7,4) AND ta.CreatedUserId = '" + jo.get("user_id").getAsInt() + "' ")
                    .addScalar("ApplicationId", IntegerType.INSTANCE)
                    .addScalar("TransactionId", IntegerType.INSTANCE)
                    .addScalar("ApplicationNumber", StringType.INSTANCE)
                    .addScalar("CreatedOn", StringType.INSTANCE)
                    .addScalar("LastModifiedOn", StringType.INSTANCE)
                    .addScalar("HasACK", IntegerType.INSTANCE)
                    .addScalar("ServiceName", StringType.INSTANCE);
            List queryList = query.list();

            for (int i = 0; i < queryList.size(); i++) {
                JsonObject response_object = new JsonObject();

                Object[] os = (Object[]) queryList.get(i);

                response_object.addProperty("transaction_id", "" + os[0]);
                response_object.addProperty("app_id", "" + os[1]);
                responsearray.add(response_object);
            }
            result = "{\"status\":\"success\",\"responsearray\":" + responsearray + "}";

        } catch (Exception e) {
            System.out.println("e" + e);
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                //session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;
        }
        return result;
    }

    //In use
    @Override
    public String saveLocationDetails(JsonObject jo) {
        String result = "";
        Session session = null;
        Date date = new Date();
        int loc_id, image_id = 0;

        byte[] bytes = null;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        String image, file_string, fileStream, textDate, filPathabs, locFile, filePath, fil;

        try {
            session = getSessionFactory().openSession();

            SQLQuery query = session.createSQLQuery("select id from t_location where TransactionId='" + jo.get("transaction_id").getAsString() + "' "
                    + "and ApplicantId='" + jo.get("applicant_id").getAsString() + "'");
            List list = query.list();

            if (list.size() > 0) {
                int os = (int) list.get(0);
                loc_id = os;
            } else {
                TLocation location = new TLocation();

                if (jo.get("applicant_id") != null) {
                    location.setApplicantId(jo.get("applicant_id").getAsInt());
                }
                if (jo.get("transaction_id") != null) {
                    location.setTransactionId(jo.get("transaction_id").getAsInt());
                }
                if (jo.get("longitude") != null) {
                    location.setLongitude(jo.get("longitude").getAsString());
                }
                if (jo.get("latitude") != null) {
                    location.setLatitude(jo.get("latitude").getAsString());
                }
                if (jo.get("created_by") != null) {
                    location.setCreatedBy(jo.get("created_by").getAsInt());
                }
                location.setCreatedOn(date);
                loc_id = (int) session.save(location);
            }
            System.out.println("loc_id" + loc_id);

            JsonArray jsonArray = jo.get("images").getAsJsonArray();

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject json = jsonArray.get(i).getAsJsonObject();
                TlocationImage locationImage = new TlocationImage();
                locationImage.setLocationId(loc_id);
                if (json.get("image_string") != null) {
                    try {
                        image = timeStamp + i + ".png";
                        file_string = json.get("image_string").getAsString();
                        fileStream = file_string;
                        textDate = df.format(sqlDate);
                        bytes = Base64.decode(fileStream);
                        //D:\DotnetPublishedApplications\FPODemo\FarmerImages
                        locFile = "E:\\MedicalImages\\" + image;
                        System.out.println("LocFile" + locFile);
                        File file = new File(locFile);
                        filPathabs = file.getAbsolutePath();
                        filePath = filPathabs.substring(0, filPathabs.lastIndexOf(File.separator));
                        fil = file.getPath();
                        boolean val = file.getParentFile().mkdirs();
                        FileOutputStream fop = null;

                        fop = new FileOutputStream(file);
                        fop.write(bytes);
                        fop.flush();
                        fop.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        result = "{\"status\":\"Failed\",\"statusMessage\":\"File not uploaded to server due to the failure in file creation\"}";
                        return result;
                    }
                    if (filePath != null) {
                        locationImage.setImage(image);
                    }
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Check imagepath\"}";
                    return result;
                }
                if (json.get("created_by") != null) {
                    locationImage.setCreatedBy(json.get("created_by").getAsInt());
                }
                locationImage.setCreatedOn(date);
                image_id = (int) session.save(locationImage);
                System.out.println("image_id" + image_id);
            }
            result = "{\"status\":\"success\",\"location_id\":" + loc_id + ",\"image_id\":" + image_id + "}";
        } catch (Exception e) {
            System.out.println("e" + e);
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;
        }
        return result;
    }

    @Override
    public String saveLocationImageDetails(JsonObject jo) {
        String result = "";
        Session session = null;
        Date date = new Date();
        int loc_id;

        byte[] bytes = null;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        String image, file_string, fileStream, textDate, filPathabs, locFile, filePath, fil;

        try {
            session = getSessionFactory().openSession();
            TlocationImage locationImage = new TlocationImage();

            if (jo.get("location_id") != null) {
                locationImage.setLocationId(jo.get("location_id").getAsInt());
            }
            if (jo.get("image_string") != null) {
                try {
                    image = timeStamp + ".png";
                    file_string = jo.get("imagepath").getAsString();
                    fileStream = file_string;
                    textDate = df.format(sqlDate);
                    bytes = Base64.decode(fileStream);
                    //D:\DotnetPublishedApplications\FPODemo\FarmerImages
                    locFile = "E:\\MedicalImages\\" + image;
                    System.out.println("LocFile" + locFile);
                    File file = new File(locFile);
                    filPathabs = file.getAbsolutePath();
                    filePath = filPathabs.substring(0, filPathabs.lastIndexOf(File.separator));
                    fil = file.getPath();
                    boolean val = file.getParentFile().mkdirs();
                    FileOutputStream fop = null;

                    fop = new FileOutputStream(file);
                    fop.write(bytes);
                    fop.flush();
                    fop.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"File not uploaded to server due to the failure in file creation\"}";
                    return result;
                }
                if (filePath != null) {
                    locationImage.setImage(image);
                }
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Check imagepath\"}";
                return result;
            }
            if (jo.get("created_by") != null) {
                locationImage.setCreatedBy(jo.get("created_by").getAsInt());
            }
            locationImage.setCreatedOn(date);
            loc_id = (int) session.save(locationImage);
            result = "{\"status\":\"success\",\"image_id\":" + loc_id + "}";
        } catch (Exception e) {
            System.out.println("e" + e);
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;
        }
        return result;
    }

    //In use
    @Override
    public String saveInspectionImages(JsonObject jo) {
        String result = "";
        Session session = null;
        int img_id;

        byte[] bytes = null;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        String image, file_string, fileStream, textDate, filPathabs, locFile, filePath, fil;

        try {
            session = getSessionFactory().openSession();
            TUpload images = new TUpload();

            if (jo.get("transactionid") != null) {
                images.setReferenceId(jo.get("transactionid").getAsInt());
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"check transactionid\"}";
                return result;
            }
            images.setReferenceTable("t_transaction");
            if (jo.get("image_string") != null) {
                try {
                    int i = jo.get("i").getAsInt();
                    image = timeStamp + i + ".png";
                    file_string = jo.get("image_string").getAsString();
                    System.out.println("image_string" + jo.get("image_string").getAsString());
                    fileStream = file_string;
                    textDate = df.format(sqlDate);
                    bytes = Base64.decode(fileStream);
                    //D:\DotnetPublishedApplications\FPODemo\FarmerImages
                    locFile = "E:\\MedicalImages\\" + image;
                    System.out.println("LocFile" + locFile);
                    File file = new File(locFile);
                    filPathabs = file.getAbsolutePath();
                    filePath = filPathabs.substring(0, filPathabs.lastIndexOf(File.separator));
                    fil = file.getPath();
                    boolean val = file.getParentFile().mkdirs();
                    FileOutputStream fop = null;

                    fop = new FileOutputStream(file);
                    fop.write(bytes);
                    fop.flush();
                    fop.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"File not uploaded to server due to the failure in file creation\"}";
                    return result;
                }
                if (filePath != null) {
                    images.setDocumentPath(image);
                }
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Check imagepath\"}";
                return result;
            }
            images.setUploadType("Inspection");
            images.setUploadedOn(new Date());
            if (jo.get("userid") != null) {
                images.setUploadedUserId(jo.get("userid").getAsInt());
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"check userid\"}";
                return result;
            }

            img_id = (int) session.save(images);
            result = "{\"status\":\"success\",\"image_id\":" + img_id + "}";
        } catch (Exception e) {
            System.out.println("e" + e);
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;
        }
        return result;
    }

    // In use
    @Override
    public String getTransactionTrackDtls(JsonObject jo) {
        Session session = null;
        String result = "";
        JsonArray jsa = new JsonArray();

        try {
            session = sessionFactory.openSession();
            SQLQuery query = session.createSQLQuery("execute GetTransactionTrackAndroid :param1");
            query.setInteger("param1", jo.get("application_numbers").getAsInt());

            List list = query.list();

            for (int i = 0; i < list.size(); i++) {
                Object[] os = (Object[]) list.get(i);
                JsonObject json = new JsonObject();

                json.addProperty("current_desg_id", "" + os[0]);
                json.addProperty("service_name", "" + os[1]);
                jsa.add(json);
            }

            result = "{\"status\":\"success\",\"responsearray\":" + jsa + "}";
        } catch (Exception e) {
            System.out.println("e" + e);
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;
        }
        return result;
    }

    //In use
    @Override
    public String getAppNosOfApplicants(JsonObject jo) {
        Session session = null;
        String result = "";
        JsonArray jsa = new JsonArray();

        try {
            session = sessionFactory.openSession();
            SQLQuery query = session.createSQLQuery("select app.applicationnumber from t_transaction trans \n"
                    + "inner join t_application app on app.Id = trans.ApplicationId\n"
                    + "where trans.CreatedUserId = '" + jo.get("userid").getAsInt() + "'");
            List list = query.list();
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    //Object[] os = (Object[]) list.get(i);
                    String os = (String) list.get(i);

                    JsonObject json = new JsonObject();
                    json.addProperty("application_numbers", os);
                    jsa.add(json);
                }
                result = "{\"status\":\"success\",\"responsearray\":" + jsa + "}";
            } else {
                result = "{\"status\":\"success\",\"StatusMessage\":\"Data not available\"}";
            }
        } catch (Exception e) {
            System.out.println("e" + e);
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Failed\"}";
            return result;
        }
        return result;
    }

    //In use
    @Override
    public String getDeptSumOfCounts(JsonObject jo) {
        Session session = null;
        String result = "";
        JsonArray applicant_count = new JsonArray();
        JsonObject jso1 = new JsonObject();

        try {
            session = getSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("execute GetDeptSumOfCounts :param1, :param2, :param3, :param4, :param5");
            query.setInteger("param1", jo.get("user_id").getAsInt());
            query.setInteger("param2", jo.get("CurrentDesignationId").getAsInt());
            query.setInteger("param3", jo.get("DistrictId").getAsInt());
            //query.setInteger("param4", jo.get("MandalId").getAsInt());
            query.setInteger("param4", 0);
            //query.setInteger("param5", jo.get("VillageId").getAsInt());
            query.setInteger("param5", 0);

            List tempList = query.list();
            if (tempList != null && tempList.size() > 0) {

                for (int i = 0; i < tempList.size(); i++) {
                    Object[] os = (Object[]) tempList.get(i);

                    jso1.addProperty("applications_received_today", "" + os[0]);
                    jso1.addProperty("applications_within_sla", "" + os[1]);
                    jso1.addProperty("applications_beyond_sla", "" + os[2]);
                    jso1.addProperty("forwarded_applications", "" + os[3]);
                    jso1.addProperty("query_raised", "" + os[4]);

                    System.out.println("json" + jso1);
                    applicant_count.add(jso1);
                    System.out.println("applicant_count" + jso1);
                }
                result = "{\"status\":\"success\",\"respons_object\":" + jso1 + "}";
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"No data available\"}";
            }
        } catch (Exception e) {
            System.out.println("e" + e);
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;
        }
        return result;
    }

    //In Use
    @Override
    public String validateUserForInspectionPrivillege(JsonObject jo) {
        Session session = null;
        String result = "";
        JsonObject json = new JsonObject();

        try {
            session = getSessionFactory().openSession();
            //SQLQuery q = session.createSQLQuery("select * from m_user where userName = '" + jo.get("username").getAsString() + "'");
            
            SQLQuery query1 = session.createSQLQuery("select id from m_user where userName = '" + jo.get("username").getAsString() + "'");
            List l = query1.list();
            if (l.size() > 0) {
                String password = jo.get("password").getAsString();
//                for (int i = 0; i < l.size(); i++) {
//                    Object[] os = (Object[]) l.get(i);
//                    String saltcode = os[23].toString();
//                    password = password + saltcode;
//                    System.out.println("password" +password);
//                }
                SQLQuery query = session.createSQLQuery("execute SP_ValidateUserForInspectionPrivillege :param1, :param2");
                query.setString("param1", jo.get("username").getAsString());
                query.setString("param2", jo.get("password").getAsString());

                List tempList = query.list();

                if (tempList != null && tempList.size() > 0) {
                    //MUser users = (MUser) tempList.get(0);
                    for (int i = 0; i < tempList.size(); i++) {
                        Object[] os = (Object[]) tempList.get(i);

                        json.addProperty("user_id", "" + os[0]);
                        json.addProperty("username", "" + os[1]);
                        json.addProperty("password", "" + os[2]);
                        json.addProperty("mobile_no", "" + os[3]);
                        json.addProperty("dob", "" + os[4]);
                        json.addProperty("email_id", "" + os[5]);
                        json.addProperty("aadhaar_no", "" + os[6]);
                        json.addProperty("pan_no", "" + os[7]);
                        json.addProperty("role_id", "" + os[8]);
                        json.addProperty("designation_id", "" + os[9]);
                        json.addProperty("department_id", "" + os[10]);
                        json.addProperty("district_id", "" + os[11]);
                        json.addProperty("mandal_id", "" + os[12]);
                        json.addProperty("village_id", "" + os[13]);
                        json.addProperty("has_inspection_priv", "" + os[14]);
                    }
                    result = "{\"status\":\"success\",\"result_object\":" + json + "}";
                } else {
                    result = "{\"status\":\"Failed\",\"statusMessage\":\"Wrong username and password\"}";
                }
            } else {
                result = "{\"status\":\"Failed\",\"statusMessage\":\"Wrong username and password\"}";
            }
        } catch (Exception e) {
            System.out.println("e" + e);
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Login failed\"}";
            return result;
        }
        return result;
    }

    //In use
    @Override
    public String getListofApplicationsForDept(JsonObject jo) {
        Session session = null;
        String result = "";

        JsonArray responsearray = new JsonArray();

        try {
            session = getSessionFactory().openSession();
            SQLQuery query = session.createSQLQuery("execute GetListofApplicationsForAndroid :param1, :param2, :param3, :param4,"
                    + ":param5, :param6");
            query.setInteger("param1", jo.get("designation_id").getAsInt());
            query.setInteger("param2", jo.get("district_id").getAsInt());
            query.setInteger("param3", jo.get("mandal_id").getAsInt());
            query.setInteger("param4", jo.get("village_id").getAsInt());
            query.setString("param5", jo.get("type").getAsString());
            query.setInteger("param6", jo.get("user_id").getAsInt());

            List queryList = query.list();
            for (int i = 0; i < queryList.size(); i++) {
                JsonObject response_object = new JsonObject();

                Object[] os = (Object[]) queryList.get(i);

                response_object.addProperty("transaction_id", "" + os[0]);
                response_object.addProperty("applicant_id", "" + os[2]);
                response_object.addProperty("applicant_number", "" + os[8]);
                response_object.addProperty("amendment_id", "" + os[1]);
                response_object.addProperty("trans_service_id", "" + os[3]);
                response_object.addProperty("service_id", "" + os[4]);
                response_object.addProperty("service_type", "" + os[5]);
                response_object.addProperty("service_name", "" + os[6]);
                response_object.addProperty("applicant_name", "" + os[7]);
                responsearray.add(response_object);
            }
            result = "{\"status\":\"success\",\"responsearray\":" + responsearray + "}";

        } catch (Exception e) {
            System.out.println("e" + e);
            e.printStackTrace();
            if (session != null) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }
            result = "{\"status\":\"Failed\",\"statusMessage\":\"Failed\"}";
            return result;
        }
        return result;
    }
}
