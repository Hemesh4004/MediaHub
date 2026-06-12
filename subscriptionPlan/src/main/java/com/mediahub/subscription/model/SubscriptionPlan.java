package com.mediahub.subscription.model;

public class SubscriptionPlan {

    private int planID;
    private String name;         // Free / Basic / Standard / Premium
    private double price;
    private String billingCycle; // Monthly / Quarterly / Annual
    private String contentAccessLevel;
    private int maxDevices;
    private boolean downloadAllowed;
    private String status;       // Active / Discontinued

    // Default constructor
    public SubscriptionPlan() {
        this.status = "Active";
    }

    // Getters
    public int getPlanID()                  { return planID; }
    public String getName()                 { return name; }
    public double getPrice()                { return price; }
    public String getBillingCycle()         { return billingCycle; }
    public String getContentAccessLevel()   { return contentAccessLevel; }
    public int getMaxDevices()              { return maxDevices; }
    public boolean isDownloadAllowed()      { return downloadAllowed; }
    public String getStatus()               { return status; }

    // Setters
    public void setPlanID(int planID)                          { this.planID = planID; }
    public void setName(String name)                           { this.name = name; }
    public void setPrice(double price)                         { this.price = price; }
    public void setBillingCycle(String billingCycle)           { this.billingCycle = billingCycle; }
    public void setContentAccessLevel(String level)            { this.contentAccessLevel = level; }
    public void setMaxDevices(int maxDevices)                  { this.maxDevices = maxDevices; }
    public void setDownloadAllowed(boolean downloadAllowed)    { this.downloadAllowed = downloadAllowed; }
    public void setStatus(String status)                       { this.status = status; }
}
