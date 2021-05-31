/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.medical.in.service;

import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.medical.in.dao.LoginDao;

/**
 *
 * @author Andriod
 */
@Service("loginServiceLayer")
public class LoginServiceImpl implements LoginServiceLayer{

    @Autowired
    private LoginDao loginDao;

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public String getAppNoBySearch(JsonObject jo) {
        return loginDao.getAppNoBySearch(jo);
    }

    @Override
    public String getDepatmentList(JsonObject jo) {
        return loginDao.getDepatmentList(jo);
    }

    @Override
    public String getUserDetails(JsonObject jo) {        
        return loginDao.getUserDetails(jo);
    }

    @Override
    public String getApplicantDetails(JsonObject jo) {
        return loginDao.getApplicantDetails(jo);
    }

    @Override
    public String saveInspectionAnswerDetails(JsonObject jo) {
        return loginDao.saveInspectionAnswerDetails(jo);
    }

    @Override
    public String login(JsonObject jo) {
        return loginDao.login(jo);
    }

    @Override
    public String getFacilityList(JsonObject jo) {
       return loginDao.getFacilityList(jo);
    }

    @Override
    public String getApplicantAndFacilityDetails(JsonObject jo) {
        return loginDao.getApplicantAndFacilityDetails(jo);
    }

    @Override
    public String getEquipmentList(JsonObject jo) {
        return loginDao.getEquipmentList(jo);
    }

    @Override
    public String getEmployeeList(JsonObject jo) {
        return loginDao.getEmployeeList(jo);
    }

    @Override
    public String getListofApplicationsCount(JsonObject jo) {
        return loginDao.getListofApplicationsCount(jo);
    }

    @Override
    public String getApplicationNoList(JsonObject jo) {
        return loginDao.getApplicationNoList(jo);
    }

    @Override
    public String saveLocationDetails(JsonObject jo) {
        return loginDao.saveLocationDetails(jo);
    }

    @Override
    public String saveLocationImageDetails(JsonObject jo) {
        return loginDao.saveLocationImageDetails(jo);
    }

    @Override
    public String saveInspectionImages(JsonObject jo) {
        return loginDao.saveInspectionImages(jo);
    }

    @Override
    public String getTransactionTrackDtls(JsonObject jo) {
        return loginDao.getTransactionTrackDtls(jo);
    }

    @Override
    public String getAppNosOfApplicants(JsonObject jo) {
        return loginDao.getAppNosOfApplicants(jo);
    }

    @Override
    public String getDeptSumOfCounts(JsonObject jo) {
        return loginDao.getDeptSumOfCounts(jo);
    }

    @Override
    public String validateUserForInspectionPrivillege(JsonObject jo) {
        return loginDao.validateUserForInspectionPrivillege(jo);
    }

    @Override
    public String getListofApplicationsForDept(JsonObject jo) {
        return loginDao.getListofApplicationsForDept(jo);
    }
}
