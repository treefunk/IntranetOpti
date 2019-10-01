package com.myoptimind.intranet;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void switchFragment(Fragment frag, int container, String tag, boolean addToBackStack, boolean clearBackStack){
        AppConstants.FRAG_CURRENT = tag;

        if(clearBackStack){
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }

        if(addToBackStack){
            getSupportFragmentManager().beginTransaction().replace(container, frag, tag).addToBackStack(tag).commit();
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(container, frag, tag).commit();
        }
    }

}
