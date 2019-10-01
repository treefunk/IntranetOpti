package com.myoptimind.intranet.main.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;
import com.myoptimind.intranet.BaseActivity;
import com.myoptimind.intranet.R;
import com.myoptimind.intranet.main.fragments.HomeFragment;
import com.myoptimind.intranet.main.fragments.LeaveFragment;
import com.myoptimind.intranet.main.fragments.OvertimeFragment;
import com.myoptimind.intranet.main.fragments.ProfileFragment;

public class HomeScreen extends BaseActivity implements View.OnClickListener {

    protected final String TAG = getClass().getSimpleName();

    private HomeFragment mHomeFragment;
    private FrameLayout fmContainer;
    private ImageButton mButtonHome,mButtonLeave,mButtonOvertime,mButtonProfile;
    private Fragment fragment;
    private FragmentManager fm;


    // navigation
    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fm = getSupportFragmentManager();

        fragment = fm.findFragmentById(R.id.fm_container);

        mButtonHome  = findViewById(R.id.ib_home);
        mButtonLeave = findViewById(R.id.ib_leave);
        mButtonOvertime = findViewById(R.id.ib_overtime);


        mButtonHome.setOnClickListener(this);
        mButtonLeave.setOnClickListener(this);
        mButtonOvertime.setOnClickListener(this);

        // navigation

        mToolbar = (Toolbar) findViewById(R.id.layout_toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        mDrawer = findViewById(R.id.drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawer,mToolbar,R.string.drawer_open,R.string.drawer_close);
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerToggle.syncState();

        mDrawer.addDrawerListener(mDrawerToggle);

        mNavigationView = findViewById(R.id.nvView);

        setupDrawerContent(mNavigationView);


        if(fragment == null){
            fm.beginTransaction().add(R.id.fm_container,new HomeFragment()).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(TAG,"oncreateoptionsmenu");
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }



    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectItemDrawer(menuItem);
                        return true;
                    }
                });
    }

    private void selectItemDrawer(MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.drawer_home:
                switchFragment(new HomeFragment(),R.id.fm_container,"HomeFragment",false,false);
                break;
            case R.id.drawer_leave:
                fm.beginTransaction().replace(R.id.fm_container,new LeaveFragment()).commit();
                break;
            case R.id.drawer_overtime:
                switchFragment(new OvertimeFragment(),R.id.fm_container,"OvertimeFragment",false,false);
                break;
            case R.id.drawer_profile:
                switchFragment(new ProfileFragment(),R.id.fm_container,"ProfileFragment",false,false);
                break;
        }

        mDrawer.closeDrawers();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.ib_home:
                switchFragment(new HomeFragment(),R.id.fm_container,"HomeFragment",false,false);
//                fm.beginTransaction().replace(R.id.fm_container,new HomeFragment()).commit();
                break;
            case R.id.ib_leave:
                Log.i("Leave button - ", " is pressed");
                fm.beginTransaction().replace(R.id.fm_container,new LeaveFragment()).commit();
                break;
            case R.id.ib_overtime:
                Log.i("Overtime button - ", " is pressed");
                switchFragment(new OvertimeFragment(),R.id.fm_container,"OvertimeFragment",false,false);
                break;
            case R.id.ib_profile:
                switchFragment(new ProfileFragment(),R.id.fm_container,"ProfileFragment",false,false);
                break;


        }
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_home:
                switchFragment(new HomeFragment(),R.id.fm_container,"HomeFragment",false,false);
                break;
            case R.id.menu_leave:
                fm.beginTransaction().replace(R.id.fm_container,new LeaveFragment()).commit();

                break;
            case R.id.menu_overtime:
                switchFragment(new OvertimeFragment(),R.id.fm_container,"OvertimeFragment",false,false);

                break;
            case R.id.menu_profile:
                switchFragment(new ProfileFragment(),R.id.fm_container,"ProfileFragment",false,false);

                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
