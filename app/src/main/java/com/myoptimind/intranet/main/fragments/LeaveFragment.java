package com.myoptimind.intranet.main.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.myoptimind.intranet.AppConstants;
import com.myoptimind.intranet.BaseFragment;
import com.myoptimind.intranet.R;
import com.myoptimind.intranet.main.adapter.LeaveListAdapter;
import com.myoptimind.intranet.main.handler.Leave;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaveFragment extends BaseFragment {

    public final String TAG = getClass().getSimpleName();

    private RecyclerView mRecyclerView;
    private View mView;
    private SharedPreferences mSharedPreferences;
    private ArrayList<Leave> leaves;


    public LeaveFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mSharedPreferences = getContext().getSharedPreferences(AppConstants.SP_USER_DETAILS,0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if(mView == null){

            mView = inflater.inflate(R.layout.fragment_leave, container, false);
            mRecyclerView = mView.findViewById(R.id.rv_leave);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            leaves = new ArrayList<>();



            AndroidNetworking.post(AppConstants.API_LEAVE_HISTORY_URL)
                             .addBodyParameter("user_id",mSharedPreferences.getString("user_id",null))
                             .build()
                             .getAsString(new StringRequestListener() {
                                 @Override
                                 public void onResponse(String response) {
                                     Log.i(TAG,"Success Leave API");
                                     try{
                                         JSONObject res = new JSONObject(response);

                                         JSONArray arr = res.getJSONArray("history");

                                         Log.i(TAG,arr.toString(4));

                                         for (int i=0; i < arr.length(); i++) {

                                             Leave leave = new Leave();
                                             JSONObject obj = arr.getJSONObject(i);
                                             leave.setComments(obj.getString("comments"));
                                             leave.setDateRequested(obj.getString("date_requested"));
                                             leave.setLeaveDate(obj.getString("leave_date"));
                                             leave.setNumberOfDays(obj.getString("number_of_days"));
                                             leave.setLeaveType(obj.getString("leave_type"));
                                             leave.setStatus(obj.getString("status"));

                                             leaves.add(leave);

                                             LeaveListAdapter adapter = new LeaveListAdapter(mActivity,leaves);
                                             mRecyclerView.setAdapter(adapter);


                                         }
                                     }catch(JSONException e){

                                     }


                                 }

                                 @Override
                                 public void onError(ANError anError) {

                                 }
                             });






        }


        return mView;


    }

}
