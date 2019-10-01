package com.myoptimind.intranet.main.model;

import android.database.Cursor;

import com.myoptimind.intranet.BaseActivity;
import com.myoptimind.intranet.BaseModel;
import com.myoptimind.intranet.main.database.UserTable;
import com.myoptimind.intranet.main.handler.UserDetails;

public class ProfileModel extends BaseModel {


    public ProfileModel(BaseActivity activity) {
        super(activity);
    }

    public UserDetails getUserById(String userId)
    {
        UserTable userTable = new UserTable(mActivity);

        return userTable.getUserByid(userId);
    }
}
