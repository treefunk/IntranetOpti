package com.myoptimind.intranet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.myoptimind.intranet.main.activity.HomeScreen;
import com.myoptimind.intranet.main.activity.LoginActivity;
import com.myoptimind.intranet.main.database.UserTable;

public class SplashActivity extends BaseActivity {

    protected final String TAG = getClass().getSimpleName();
    UserTable mUserTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);


        mUserTable = new UserTable(this);

        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences(AppConstants.SP_USER_DETAILS,0);

                Log.i(TAG,sharedPreferences.getString(AppConstants.SP_USER_ID_KEY,""));
                if(!sharedPreferences.getString(AppConstants.SP_USER_ID_KEY,"").isEmpty()){
                    Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                    startActivity(intent);
                    Log.i(TAG,"user_id key is present");
                }else{
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }




            }
        },2000);

    }




}
