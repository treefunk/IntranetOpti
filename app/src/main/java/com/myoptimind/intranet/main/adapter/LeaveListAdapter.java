package com.myoptimind.intranet.main.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myoptimind.intranet.BaseActivity;
import com.myoptimind.intranet.R;
import com.myoptimind.intranet.main.handler.Leave;

import java.util.List;

public class LeaveListAdapter extends RecyclerView.Adapter<LeaveListAdapter.LeaveViewHolder> {

    private List<Leave> mLeaves;
    private BaseActivity mActivity;



    public LeaveListAdapter(BaseActivity activity,List<Leave> leaves) {
        mLeaves = leaves;
        mActivity = activity;
    }

    @NonNull
    @Override
    public LeaveListAdapter.LeaveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item_leave,parent,false);
        return new LeaveViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull LeaveListAdapter.LeaveViewHolder holder, int position) {

        Leave leave = mLeaves.get(position);

        holder.mType.setText(leave.getLeaveType());
        holder.mDate.setText(leave.getLeaveDate());
        holder.mNumOfDays.setText(leave.getNumberOfDays());
        holder.mRequested.setText(leave.getDateRequested());
        holder.mComments.setText(leave.getComments());
        holder.mStatus.setText(leave.getStatus());

    }

    @Override
    public int getItemCount() {
        return mLeaves.size();
    }

    class LeaveViewHolder extends RecyclerView.ViewHolder{

        private TextView mType,
                mDate,
                mRequested,
                mNumOfDays,
                mComments,
                mStatus;



        public LeaveViewHolder(@NonNull View itemView) {

            super(itemView);

            mType      = itemView.findViewById(R.id.tv_leavetype);
            mDate      = itemView.findViewById(R.id.tv_leavedate);
            mRequested = itemView.findViewById(R.id.tv_date_requested);
            mNumOfDays = itemView.findViewById(R.id.tv_number_of_days);
            mComments  = itemView.findViewById(R.id.tv_comments);
            mStatus    = itemView.findViewById(R.id.tv_status);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mActivity,mLeaves.get(getAdapterPosition()).getDateRequested(), Toast.LENGTH_LONG).show();
                }
            });

        }
    }




}
