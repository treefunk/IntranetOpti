package com.myoptimind.intranet.main.controller;

import android.content.SharedPreferences;
import android.widget.TextView;

import com.myoptimind.intranet.AppConstants;
import com.myoptimind.intranet.BaseActivity;
import com.myoptimind.intranet.main.database.UserTable;
import com.myoptimind.intranet.main.handler.UserDetails;
import com.myoptimind.intranet.main.model.ProfileModel;

public class ProfileController {

    private BaseActivity mActivity;
    private ProfileModel mModel;
    private SharedPreferences mSharedPreferences;


    public ProfileController(BaseActivity activity) {
        this.mActivity = activity;
    }

    public void setProfileTextViews(TextView tvUserId,
                                    TextView tvFirstName,
                                    TextView tvLastName,
                                    TextView tvPosition,
                                    TextView tvHomeAddress,
                                    TextView tvHomeNumber,
                                    TextView tvMobileNumber,
                                    TextView tvFullName){

        mSharedPreferences = mActivity.getSharedPreferences(AppConstants.SP_USER_DETAILS,0);

        //UserDetails userDetails = mModel.getUserById(mSharedPreferences.getString("user_id",""));

        UserDetails userDetails = new UserTable(mActivity).getUserByid(mSharedPreferences.getString("user_id",""));


        tvUserId.setText(userDetails.getUserId());
        tvFirstName.setText(userDetails.getFirstName());
        tvLastName.setText(userDetails.getLastName());
        tvPosition.setText(userDetails.getPosition());
        tvHomeAddress.setText(userDetails.getHomeAddress());
        tvHomeNumber.setText(userDetails.getHomeNumber());
        tvMobileNumber.setText(userDetails.getMobileNumber());
        tvFullName.setText(userDetails.getFirstName() + " " + userDetails.getLastName());
    }


}
