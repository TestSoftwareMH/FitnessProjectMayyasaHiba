package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {


    private int clientId;
    private String clientName;
    private int age;
    private Date birthday;
    private String email;
    private String phoneNumber;
    private String Attendance;
    private String CompletionRate;
    private String MessageDelivered;
    private String Feedback;
    private String Activity;
    private String FitnessGoals;
    private double Weight;
    private String Password;
    private boolean ClientInProgress;
    private List<Integer> programsClientIn=new ArrayList<Integer>();
    private String dietaryPreferences;
    private String restrictions;
    public Client(int clientId,String clientName,String Attendance,String CompletionRate,String Activity,
                  String MessageDelivered,boolean ClientInProgress,List<Integer> programsClientIn) {
        this.clientId=clientId;
        this.clientName=clientName;
        this.Attendance=Attendance;
        this.CompletionRate=CompletionRate;
        this.Activity=Activity;
        this.MessageDelivered=MessageDelivered;
        this.ClientInProgress=ClientInProgress;
        this.programsClientIn=programsClientIn;
    }
    public Integer getClientId() {
        return clientId;
    }
    public void setProgramId(int ClientId) {
        this.clientId=ClientId;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName=clientName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age=age;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday=birthday;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber=phoneNumber;
    }
    public String getAttendance() {
        return Attendance;
    }
    public void setAttendance(String Attendance) {
        this.Attendance=Attendance;
    }
    public String getCompletionRate() {
        return CompletionRate;
    }
    public void setCompletionRate(String CompletionRate) {
        this.CompletionRate=CompletionRate;
    }
    public String getMessageDelivered() {
        return MessageDelivered;
    }
    public void setMessageDelivered(String MessageDelivered) {
        this.MessageDelivered=MessageDelivered;
    }
    public String getDietaryPreferences() {
        return dietaryPreferences;
    }
    public void setDietaryPreferences(String dietaryPreferences) {
        this.dietaryPreferences=dietaryPreferences;
    }
    public String getRestrictions() {
        return restrictions;
    }
    public void setRestrictions(String restrictions) {
        this.restrictions=restrictions;
    }
    public String getFeedback() {
        return Feedback;
    }
    public void setFeedback(String Feedback) {
        this.Feedback=Feedback;
    }
    public String getActivity() {
        return Activity;
    }
    public void setActivity(String Activity) {
        this.Activity=Activity;
    }
    public String getFitnessGoals() {
        return FitnessGoals;
    }
    public void setFitnessGoals(String FitnessGoals) {
        this.FitnessGoals=FitnessGoals;
    }
    public double getWeight() {
        return Weight;
    }
    public void setWeight(double Weight) {
        this.Weight=Weight;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password=Password;
    }
    public boolean getClientInProgress() {
        return ClientInProgress;
    }
    public void setClientInProgress(boolean ClientInProgress) {
        this.ClientInProgress=ClientInProgress;
    }
    public List<Integer> getProgramsClientIn() {
        return programsClientIn;
    }
    public void setProgramsClientIn(List<Integer> programsClientIn) {
        this.programsClientIn=programsClientIn;
    }


}
