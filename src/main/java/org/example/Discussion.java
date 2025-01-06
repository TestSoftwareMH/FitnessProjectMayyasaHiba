package org.example;

public class Discussion {


    private int DiscussionId;
    private String DiscussionName;
    private String Message;

    public Discussion(int DiscussionId, String DiscussionName, String Message ) {
        this.DiscussionId = DiscussionId;
        this.DiscussionName = DiscussionName;
        this.Message = Message;
    }
    public Integer getDiscussionId() {
        return DiscussionId;
    }
    public void setDiscussionId(int DiscussionId) {
        this.DiscussionId=DiscussionId;
    }
    public String getDiscussionName() {
        return DiscussionName;
    }
    public void setDiscussionName(String DiscussionName) {
        this.DiscussionName=DiscussionName;
    }
    public String getMessage() {
        return Message;
    }
    public void setMessage(String Message) {
        this.Message=Message;
    }
}
