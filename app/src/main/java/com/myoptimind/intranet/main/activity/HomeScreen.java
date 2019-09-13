package com.myoptimind.intranet.main.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.myoptimind.intranet.R;
import com.myoptimind.intranet.main.fragments.HomeFragment;
import com.myoptimind.intranet.main.fragments.LeaveFragment;

public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    private HomeFragment mHomeFragment;
    private FrameLayout fmContainer;
    private ImageButton mButtonHome,mButtonLeave,mButtonOvertime,mButtonProfile;
    private Fragment fragment;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fm = getSupportFragmentManager();

        fragment = fm.findFragmentById(R.id.fm_container);

        mButtonHome  = findViewById(R.id.ib_home);
        mButtonLeave = findViewById(R.id.ib_leave);


        mButtonHome.setOnClickListener(this);
        mButtonLeave.setOnClickListener(this);



        if(fragment == null){
            fm.beginTransaction().add(R.id.fm_container,new HomeFragment()).commit();
//            fm.beginTransaction().replace(R.id.fm_container,new HomeFragment()).commit();
        }

    }

    @Override
    public void onClick(View view) {
        Log.i("VIEW pressed " , "onclick in homescreen");
        switch(view.getId()){
            case R.id.ib_home:
                fm.beginTransaction().replace(R.id.fm_container,new HomeFragment()).commit();
                break;
            case R.id.ib_leave:
                Log.i("Leave button - ", " is pressed");
                fm.beginTransaction().replace(R.id.fm_container,new LeaveFragment()).commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
