package com.mediahub.subscription.model;

import java.util.Date;

public class UserSubscription {

    private int subscriptionID;
    private int userID;
    private int planID;
    private Date startDate;
    private Date endDate;
    private String renewalType; // AutoRenew / Manual
    private String status;      // Active / Expired / Cancelled / Suspended

    // Default constructor
    public UserSubscription() {
        this.status = "Active";
    }

    // Getters
    public int getSubscriptionID()      { return subscriptionID; }
    public int getUserID()              { return userID; }
    public int getPlanID()              { return planID; }
    public Date getStartDate()          { return startDate; }
    public Date getEndDate()            { return endDate; }
    public String getRenewalType()      { return renewalType; }
    public String getStatus()           { return status; }

    // Setters
    public void setSubscriptionID(int subscriptionID)   { this.subscriptionID = subscriptionID; }
    public void setUserID(int userID)                   { this.userID = userID; }
    public void setPlanID(int planID)                   { this.planID = planID; }
    public void setStartDate(Date startDate)            { this.startDate = startDate; }
    public void setEndDate(Date endDate)                { this.endDate = endDate; }
    public void setRenewalType(String renewalType)      { this.renewalType = renewalType; }
    public void setStatus(String status)                { this.status = status; }
}
