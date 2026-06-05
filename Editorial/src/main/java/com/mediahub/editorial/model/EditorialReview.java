package com.mediahub.editorial.model;

import java.util.Date;

public class EditorialReview {

    private int reviewID;
    private int contentID;
    private int reviewerID;
    private Date submissionDate;
    private Date reviewDate;
    private String decision;
    private String remarks;
    private String status;

    public EditorialReview() {
        this.status = "Pending";
    }

    public int getReviewID()                        { return reviewID; }
    public void setReviewID(int reviewID)           { this.reviewID = reviewID; }

    public int getContentID()                       { return contentID; }
    public void setContentID(int contentID)         { this.contentID = contentID; }

    public int getReviewerID()                      { return reviewerID; }
    public void setReviewerID(int reviewerID)       { this.reviewerID = reviewerID; }

    public Date getSubmissionDate()                         { return submissionDate; }
    public void setSubmissionDate(Date submissionDate)      { this.submissionDate = submissionDate; }

    public Date getReviewDate()                     { return reviewDate; }
    public void setReviewDate(Date reviewDate)      { this.reviewDate = reviewDate; }

    public String getDecision()                     { return decision; }
    public void setDecision(String decision)        { this.decision = decision; }

    public String getRemarks()                      { return remarks; }
    public void setRemarks(String remarks)          { this.remarks = remarks; }

    public String getStatus()                       { return status; }
    public void setStatus(String status)            { this.status = status; }
}
