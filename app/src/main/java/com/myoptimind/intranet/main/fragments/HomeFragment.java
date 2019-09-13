package com.myoptimind.intranet.main.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.myoptimind.intranet.BaseFragment;
import com.myoptimind.intranet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    View mView;
    WebView mWebView;


    public HomeFragment() {
        // Required empty public constructor
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
