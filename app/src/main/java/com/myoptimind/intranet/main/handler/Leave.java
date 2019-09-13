package com.myoptimind.intranet.main.handler;

public class Leave {

    private String mLeaveDate,
                   mDateRequested,
                   mNumberOfDays,
                   mLeaveType,
                   mComments,
                   mStatus;

    public String getDateRequested() {
        return mDateRequested;
    }

    public void setDateRequested(String dateRequested) {
        mDateRequested = dateRequested;
    }

    public String getNumberOfDays() {
        return mNumberOfDays;
    }

    public void setNumberOfDays(String numberOfDays) {
        mNumberOfDays = numberOfDays;
    }

    public String getLeaveType() {
        return mLeaveType;
    }

    public void setLeaveType(String leaveType) {
        mLeaveType = leaveType;
    }

    public String getComments() {
        return mComments;
    }

    public void setComments(String comments) {
        mComments = comments;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getLeaveDate() {
        return mLeaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        mLeaveDate = leaveDate;
    }
}
