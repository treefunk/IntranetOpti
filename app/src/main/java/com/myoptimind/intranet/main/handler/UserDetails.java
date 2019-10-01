package com.myoptimind.intranet.main.handler;

import org.json.JSONException;
import org.json.JSONObject;

public class UserDetails {

    private String userId;
    private String firstName;
    private String lastName;
    private String position;
    private String homeAddress;
    private String homeNumber;
    private String mobileNumber;

    public static UserDetails createFromJSONObject(JSONObject user){

        UserDetails userDetails = null;

        try{
            userDetails = new UserDetails(
                    user.getString("user_id"),
                    user.getString("first_name"),
                    user.getString("last_name"),
                    user.getString("position"),
                    user.getString("home_address"),
                    user.getString("home_number"),
                    user.getString("mobile_number")
            );
        }catch(JSONException exception){
            exception.printStackTrace();
        }

        return userDetails;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserDetails(){

    }

    public UserDetails(String userId,String firstName, String lastName, String position, String homeAddress, String homeNumber, String mobileNumber) {
        this.userId   = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.homeAddress = homeAddress;
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
