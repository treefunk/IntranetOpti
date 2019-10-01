package com.myoptimind.intranet.main.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myoptimind.intranet.BaseFragment;
import com.myoptimind.intranet.R;
import com.myoptimind.intranet.main.controller.ProfileController;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends BaseFragment {

    public final String TAG = getClass().getSimpleName();

    ProfileController mController;

    View mView;

    TextView tvUserId,
             tvFirstName,
             tvLastName,
             tvPosition,
             tvHomeAddress,
             tvHomeNumber,
             tvMobileNumber,
             tvFullName;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(mView == null){

            mView = inflater.inflate(R.layout.fragment_profile, container, false);

            tvUserId = mView.findViewById(R.id.tv_user_id);
            tvFirstName = mView.findViewById(R.id.tv_first_name);
            tvLastName = mView.findViewById(R.id.tv_last_name);
            tvPosition = mView.findViewById(R.id.tv_position);
            tvHomeAddress = mView.findViewById(R.id.tv_home_address);
            tvHomeNumber = mView.findViewById(R.id.tv_home_number);
            tvMobileNumber = mView.findViewById(R.id.tv_mobile_number);
            tvFullName = mView.findViewById(R.id.tv_full_name);

            mController = new ProfileController(mActivity);

            mController.setProfileTextViews(tvUserId,
                    tvFirstName,
                    tvLastName,
                    tvPosition,
                    tvHomeAddress,
                    tvHomeNumber,
                    tvMobileNumber,
                    tvFullName);




        }

        return mView;
        // Inflate the layout for this fragment
    }

}
