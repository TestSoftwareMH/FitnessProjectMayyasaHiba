package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client {


    private int cliId;
    private String cliName;
    private int age;
    private Date birthday;
    private String email;
    private String phoneNumber;
    private String attendances;
    private String completeRate;
    private String messageDelivered;
    private String feedback;
    private String activity;
    private String fitnessGoals;
    private double weight;
    private String password;
    private boolean cliInProgress;
    private List<Integer> programsCliIn =new ArrayList<Integer>();
    private String dietaryPreferences;
    private String restrictions;
    public Client(int clientId,String clientName,String attendance,String completionRate,String activity,
                  boolean clientInProgress,List<Integer> programsClientIn) {
        this.cliId =clientId;
        this.cliName =clientName;
        this.attendances =attendance;
        this.completeRate =completionRate;
        this.activity =activity;
        this.cliInProgress =clientInProgress;
        this.programsCliIn =programsClientIn;
    }
    public Integer getClientId() {
        return cliId;
    }
    public void setProgramId(int clientId) {
        this.cliId =clientId;
    }
    public String getClientName() {
        return cliName;
    }
    public void setClientName(String clientName) {
        this.cliName =clientName;
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
        return attendances;
    }
    public void setAttendance(String attendance) {
        this.attendances =attendance;
    }
    public String getCompletionRate() {
        return completeRate;
    }
    public void setCompletionRate(String completionRate) {
        this.completeRate =completionRate;
    }
    public String getMessageDelivered() {
        return messageDelivered;
    }
    public void setMessageDelivered(String messageDelivered) {
        this.messageDelivered =messageDelivered;
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
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback =feedback;
    }
    public String getActivity() {
        return activity;
    }
    public void setActivity(String activity) {
        this.activity =activity;
    }
    public String getFitnessGoals() {
        return fitnessGoals;
    }
    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals =fitnessGoals;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight =weight;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password =password;
    }
    public boolean getClientInProgress() {
        return cliInProgress;
    }
    public void setClientInProgress(boolean clientInProgress) {
        this.cliInProgress =clientInProgress;
    }
    public List<Integer> getProgramsClientIn() {
        return programsCliIn;
    }
    public void setProgramsClientIn(List<Integer> programsClientIn) {
        this.programsCliIn =programsClientIn;
    }


}
