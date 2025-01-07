package org.example;

public class Discussion {


    private int discussionId;
    private String discussionName;
    private String message;

    public Discussion(int discussionId, String discussionName, String message ) {
        this.discussionId = discussionId;
        this.discussionName = discussionName;
        this.message = message;
    }
    public Integer getDiscussionId() {
        return discussionId;
    }
    public void setDiscussionId(int discussionId) {
        this.discussionId =discussionId;
    }
    public String getDiscussionName() {
        return discussionName;
    }
    public void setDiscussionName(String discussionName) {
        this.discussionName =discussionName;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message =message;
    }
}