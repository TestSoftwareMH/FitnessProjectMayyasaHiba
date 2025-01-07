public class Client {


    private int clientId;
    private String clientName;
    private int age;
    private Date birthday;
    private String email;
    private String phoneNumber;
    private String attendance;
    private String completionRate;
    private String messageDelivered;
    private String feedback;
    private String activity;
    private String fitnessGoals;
    private double weight;
    private String password;
    private boolean clientInProgress;
    private List<Integer> programsClientIn=new ArrayList<Integer>();
    private String dietaryPreferences;
    private String restrictions;
    public Client(int clientId,String clientName,String attendance,String completionRate,String activity,
                  String messageDelivered,boolean clientInProgress,List<Integer> programsClientIn) {
        this.clientId=clientId;
        this.clientName=clientName;
        this.attendance =attendance;
        this.completionRate =completionRate;
        this.activity =activity;
        this.messageDelivered =messageDelivered;
        this.clientInProgress =clientInProgress;
        this.programsClientIn=programsClientIn;
    }
    public Integer getClientId() {
        return clientId;
    }
    public void setProgramId(int clientId) {
        this.clientId=clientId;
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
        return attendance;
    }
    public void setAttendance(String attendance) {
        this.attendance =attendance;
    }
    public String getCompletionRate() {
        return completionRate;
    }
    public void setCompletionRate(String completionRate) {
        this.completionRate =completionRate;
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
        return clientInProgress;
    }
    public void setClientInProgress(boolean clientInProgress) {
        this.clientInProgress =clientInProgress;
    }
    public List<Integer> getProgramsClientIn() {
        return programsClientIn;
    }
    public void setProgramsClientIn(List<Integer> programsClientIn) {
        this.programsClientIn=programsClientIn;
    }


}