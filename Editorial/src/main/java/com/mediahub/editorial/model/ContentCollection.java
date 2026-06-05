package com.mediahub.editorial.model;

import java.util.Date;
import java.util.List;

public class ContentCollection {

    private int collectionID;
    private String name;
    private String category;
    private List<Integer> contentIDs;
    private Date publishDate;
    private Date expiryDate;
    private String status;

    public ContentCollection() {
        this.status = "Scheduled";
    }

    public int getCollectionID()                            { return collectionID; }
    public void setCollectionID(int collectionID)          { this.collectionID = collectionID; }

    public String getName()                                 { return name; }
    public void setName(String name)                       { this.name = name; }

    public String getCategory()                            { return category; }
    public void setCategory(String category)               { this.category = category; }

    public List<Integer> getContentIDs()                   { return contentIDs; }
    public void setContentIDs(List<Integer> contentIDs)    { this.contentIDs = contentIDs; }

    public Date getPublishDate()                           { return publishDate; }
    public void setPublishDate(Date publishDate)           { this.publishDate = publishDate; }

    public Date getExpiryDate()                            { return expiryDate; }
    public void setExpiryDate(Date expiryDate)             { this.expiryDate = expiryDate; }

    public String getStatus()                              { return status; }
    public void setStatus(String status)                   { this.status = status; }
}
