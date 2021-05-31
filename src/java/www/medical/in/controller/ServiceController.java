/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.medical.in.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import www.medical.in.service.LoginServiceLayer;

/**
 *
 * @author Andriod
 */
@RestController
@RequestMapping("/rest")
public class ServiceController {
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginService
     */
    public ServiceController() {
        System.out.println("in Medical controller");
    }
    @Autowired
    private LoginServiceLayer loginServiceLayer;

    public LoginServiceLayer getLoginServiceLayer() {
        return loginServiceLayer;
    }

    public void setLoginServiceLayer(LoginServiceLayer loginServiceLayer) {
        this.loginServiceLayer = loginServiceLayer;
    }
    
    @RequestMapping(value = "/get.htm", method = RequestMethod.GET)
    public @ResponseBody
    String checkMenthod() {

        try {
            //dataServices.deleteEntity(id);
            return "in get!";
        } catch (Exception e) {
            return "in catch!";
        }
    }
    
    @RequestMapping(value = "/getAppNoBySearch.htm", method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getAppNoBySearch(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getAppNoBySearch(jo);
            return result;
        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }  
    
    @RequestMapping(value = "/getDepatmentList.htm", method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getDepatmentList(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getDepatmentList(jo);
            return result;
        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }  
    
    @RequestMapping(value = "/getUserDetails.htm", method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getUserDetails(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getUserDetails(jo);
            return result;
        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    
    @RequestMapping(value = "/getApplicantDetails.htm", method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getApplicantDetails(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getApplicantDetails(jo);
            return result;
        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/saveInspectionAnswerDetails.htm", method = RequestMethod.POST, 
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String inspectionAnswerDetails(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            //JsonArray json = (JsonArray) jsonParser.parse(jsonStr);
            result = loginServiceLayer.saveInspectionAnswerDetails(jo);
            return result;
        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/login.htm", method = RequestMethod.POST, 
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String login(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.login(jo);
            return result;
        }
        catch(Exception e){
            e.printStackTrace();
            result="{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }  
    
    @RequestMapping(value = "/getFacilityList.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getFacilityList(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getFacilityList(jo);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/getApplicantAndFacilityDetails.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getApplicantAndFacilityDetails(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getApplicantAndFacilityDetails(jo);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }     
    
    @RequestMapping(value = "/getEquipmentList.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getEquipmentList(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getEquipmentList(jo);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }     
    
            
    @RequestMapping(value = "/getEmployeeList.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getEmployeeList(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getEmployeeList(jo);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }    
    
    @RequestMapping(value = "/getListofApplicationsCount.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getListofApplicationsCount(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getListofApplicationsCount(jo);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }    
    
    @RequestMapping(value = "/getApplicationNoList.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getApplicationNoList(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getApplicationNoList(jo);
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    } 
    
    
    @RequestMapping(value = "/saveLocationDetails.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String saveLocationDetails(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.saveLocationDetails(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/saveLocationImageDetails.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String saveLocationImageDetails(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.saveLocationImageDetails(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/saveInspectionImages.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String saveInspectionImages(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.saveInspectionImages(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    
    @RequestMapping(value = "/getTransactionTrackDtls.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getTransactionTrackDtls(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getTransactionTrackDtls(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/getAppNosOfApplicants.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getAppNosOfApplicants(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getAppNosOfApplicants(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/getDeptSumOfCounts.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getDeptSumOfCounts(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getDeptSumOfCounts(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/validateUserForInspectionPrivillege.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String validateUserForInspectionPrivillege(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.validateUserForInspectionPrivillege(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }
    
    @RequestMapping(value = "/getListofApplicationsForDept.htm", method = RequestMethod.POST, 
    consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getListofApplicationsForDept(@RequestBody String jsonStr) {
        String result = "";
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jo = (JsonObject) jsonParser.parse(jsonStr);
            result = loginServiceLayer.getListofApplicationsForDept(jo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result = "{\"status\":\"Failed\",\"Message\":\"Check Json\"}";
            return result;
        }
    }    
}
