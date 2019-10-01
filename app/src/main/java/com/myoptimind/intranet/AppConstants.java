package com.myoptimind.intranet;

public class AppConstants {

    public static final String API_BASE_URL          = "http://intranet.myoptimind.com/webservice/";
    public static final String API_LOGIN_URL         = "login.php";
    public static final String API_LEAVE_HISTORY_URL = API_BASE_URL + "leave_history.php";


    public static final String SP_USER_DETAILS       = "UserDetails";
    public static final String SP_USER_ID_KEY        = "user_id";

    public static String FRAG_CURRENT                = "";

    public static String getAPI_BASE_URL(String url) {
        return API_BASE_URL + url;
    }

    public static String getAPI_LOGIN_URL() {
        return getAPI_BASE_URL(API_LOGIN_URL);
    }


}
