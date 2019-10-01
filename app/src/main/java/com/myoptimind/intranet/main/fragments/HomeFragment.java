package com.myoptimind.intranet.main.fragments;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.myoptimind.intranet.BaseFragment;
import com.myoptimind.intranet.R;
import com.myoptimind.intranet.main.activity.HomeScreen;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    View mView;
    WebView mWebView;
    private HomeScreen mActivity;


//    public HomeFragment() {
//        // Required empty public constructor
//    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (HomeScreen) getActivity();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(mView == null){

            mView = inflater.inflate(R.layout.fragment_home, container, false);

            mWebView = mView.findViewById(R.id.wv_home);

            mWebView.loadUrl("https://www.myoptimind.com/");


        }

        return mView;
    }

}
