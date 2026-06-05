package com.mediahub.editorial.model;

import java.util.Date;

public class PublicationSchedule {

    private int scheduleID;
    private int contentID;
    private Date publishDateTime;
    private Date expiryDateTime;
    private String territory;
    private String status;

    public PublicationSchedule() {
        this.status = "Scheduled";
    }

    public int getScheduleID()                              { return scheduleID; }
    public void setScheduleID(int scheduleID)               { this.scheduleID = scheduleID; }

    public int getContentID()                               { return contentID; }
    public void setContentID(int contentID)                 { this.contentID = contentID; }

    public Date getPublishDateTime()                        { return publishDateTime; }
    public void setPublishDateTime(Date publishDateTime)    { this.publishDateTime = publishDateTime; }

    public Date getExpiryDateTime()                         { return expiryDateTime; }
    public void setExpiryDateTime(Date expiryDateTime)      { this.expiryDateTime = expiryDateTime; }

    public String getTerritory()                            { return territory; }
    public void setTerritory(String territory)              { this.territory = territory; }

    public String getStatus()                               { return status; }
    public void setStatus(String status)                    { this.status = status; }
}
