package com.myoptimind.intranet.main.model;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;
import com.myoptimind.intranet.AppConstants;
import com.myoptimind.intranet.BaseActivity;
import com.myoptimind.intranet.BaseModel;
import com.myoptimind.intranet.main.activity.HomeScreen;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginModel extends BaseModel {

    protected final String TAG = this.getClass().getSimpleName();

    private SharedPreferences mSharedPreferences;



    public LoginModel(BaseActivity activity){
        super(activity);
    }

    public void processLogin(String username, String password){

        Log.i(TAG,username + "\n" + password);

        mSharedPreferences = mActivity.getSharedPreferences(AppConstants.SP_USER_DETAILS, 0);
        final SharedPreferences.Editor editor = mSharedPreferences.edit();



        Log.i(TAG,AppConstants.getAPI_LOGIN_URL());

        AndroidNetworking.post(AppConstants.getAPI_LOGIN_URL())
                         .addBodyParameter("email",username)
                         .addBodyParameter("password",password)
                         .build()
                         .getAsString(new StringRequestListener() {
                             @Override
                             public void onResponse(String response) {

                                 try{
                                     JSONObject res = new JSONObject(response);
                                     JSONObject user = res.getJSONObject("user");

                                     storeUserDetailsInSp(user);

                                 }catch(JSONException exception){
                                     exception.printStackTrace();
                                 }

                                 if(!mSharedPreferences.getString("user_id",null).isEmpty()){
                                     Intent intent = new Intent(mActivity, HomeScreen.class);
                                     mActivity.startActivity(intent);
                                 }

                                 Log.i(TAG,"Login Response: " + response);
                             }

                             private void storeUserDetailsInSp(JSONObject user) {
                                 try{

                                     editor.putString("user_id", user.getString("user_id"));
                                     editor.putString("first_name",user.getString("first_name"));
                                     editor.putString("last_name",user.getString("last_name"));
                                     editor.putString("position",user.getString("position"));
                                     editor.commit();

                                 }catch(JSONException exception){
                                     exception.printStackTrace();
                                 }
                             }

                             @Override
                             public void onError(ANError anError) {
                                 Log.e(TAG,String.valueOf(anError.getErrorCode()));
                                switch(anError.getErrorCode()){
                                    case 400:
                                        Log.e(TAG,"Error 400");
                                        break;
                                }
                             }
                         });
        // end of post



    }
}


