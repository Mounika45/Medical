/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.medical.in.dao;

import com.google.gson.JsonObject;

/**
 *
 * @author Andriod
 */
public interface LoginDao {
  
    public String getAppNoBySearch(JsonObject jo);
    
    public String getDepatmentList(JsonObject jo);
    
    public String getUserDetails(JsonObject jo);
    
    public String getApplicantDetails(JsonObject jo);
    
    public String saveInspectionAnswerDetails(JsonObject jo);
    
    public String login(JsonObject jo);
    
    public String getFacilityList(JsonObject jo);
    
    public String getApplicantAndFacilityDetails(JsonObject jo);
    
    public String getEquipmentList(JsonObject jo);
    
    public String getEmployeeList(JsonObject jo);
    
    public String getListofApplicationsCount(JsonObject jo);
    
    public String getApplicationNoList(JsonObject jo);
    
    public String saveLocationDetails(JsonObject jo);
    
    public String saveLocationImageDetails(JsonObject jo);
    
    public String saveInspectionImages(JsonObject jo);
    
    public String getTransactionTrackDtls(JsonObject jo);
    
    public String getAppNosOfApplicants(JsonObject jo);
    
    public String getDeptSumOfCounts(JsonObject jo);
    
    public String validateUserForInspectionPrivillege(JsonObject jo);
    
    public String getListofApplicationsForDept(JsonObject jo);
}
