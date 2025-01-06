package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class mainProgram {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final static List<mainProgram> programs=new ArrayList<mainProgram>();
    private final static List<mainProgram> programsForExpo=new ArrayList<mainProgram>();
    private static List<mainProgram> programsByDiff=new ArrayList<mainProgram>();
    private static List<mainProgram> programsByGoal=new ArrayList<mainProgram>();
    private static List<Integer> enrolledPro=new ArrayList<Integer>();;
    private final static List<Client> clients=new ArrayList<Client>();
    private static List<Client> clientsWithId=new ArrayList<Client>();
    private static List<Discussion> discussionsWithId=new ArrayList<Discussion>();
    private final static List<Discussion> discussions=new ArrayList<Discussion>();
    private static Map<String, Map<String, String>> accounts = new HashMap<>();
    private int ProgramId;
    private String ProgramTitle ;
    private int Duration;
    private String DifficultyLevel ;
    private String Goals ;
    private String Description ;
    private double Price;
    private String ScheduleType;
    private String ScheduleTime ;
    private int TotalNumberOfClient;
    private int NumberOfAttendedClients;
    public mainProgram(int ProgramId,String ProgramTitle,int Duration,String DifficultyLevel,String Goals,String Description,double Price,String ScheduleType,String ScheduleTime) {
        this.ProgramId=ProgramId;
        this.ProgramTitle=ProgramTitle;
        this.Duration=Duration;
        this.DifficultyLevel=DifficultyLevel;
        this.Goals=Goals;
        this.Description=Description;
        this.Price=Price;
        this.ScheduleType=ScheduleType;
        this.ScheduleTime=ScheduleTime;
    }
    public Integer getProgramId() {
        return ProgramId;
    }
    public void setProgramId(int ProgramId) {
        this.ProgramId=ProgramId;
    }
    public String getProgramTitle() {
        return ProgramTitle;
    }
    public void setProgramTitle(String ProgramTitle) {
        this.ProgramTitle=ProgramTitle;
    }
    public Integer getDuration() {
        return Duration;
    }
    public void setDuration(int Duration) {
        this.Duration=Duration;
    }
    public String getDifficultyLevel() {
        return DifficultyLevel;
    }
    public void setDifficultyLevel(String DifficultyLevel) {
        this.DifficultyLevel=DifficultyLevel;
    }
    public String getGoals() {
        return Goals;
    }
    public void setGoals(String Goals) {
        this.Goals=Goals;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description=Description;
    }
    public Double getPrice() {
        return Price;
    }
    public void setPrice(double Price) {
        this.Price=Price;
    }
    public String getScheduleType() {
        return ScheduleType;
    }
    public void setScheduleType(String ScheduleType) {
        this.ScheduleType=ScheduleType;
    }
    public String getScheduleTime() {
        return ScheduleTime;
    }
    public void setScheduleTime(String ScheduleTime) {
        this.ScheduleTime=ScheduleTime;
    }
    public Integer getTotalNumberOfClient() {
        return TotalNumberOfClient;
    }
    public void setTotalNumberOfClient(int TotalNumberOfClient) {
        this.TotalNumberOfClient=TotalNumberOfClient;
    }
    public Integer getNumberOfAttendedClients() {
        return NumberOfAttendedClients;
    }
    public void setNumberOfAttendedClients(int NumberOfAttendedClients) {
        this.NumberOfAttendedClients=NumberOfAttendedClients;
    }
    public static boolean login(String role) {
        if(role.equals("Instructor")){
            return true;
        }
        else {
            return false;
        }
    }
    public static void initializePrograms(){
        mainProgram p=new mainProgram(     100     , "Cardio" , 60 , "Intermediate" , "Weight loss", "video" , 70 , "In-Person" , "Sunday-Tuesday , 7:00pm-8:00pm");
        p.setTotalNumberOfClient(10); p.setNumberOfAttendedClients(9);
        Client c;
        programs.add(p);
        programs.add(new mainProgram(     205     , "Dance" , 60 , "Advanced" , "Weight loss", "image" , 50 , "In-Person" , "Sunday , 9:00am-10:00am"));
        clients.add(c=new Client(10,"Hiba Zawatieh","90%" ,"80%"  , "Cardio" ,null, true,List.of(100)));
        c.setRestrictions("No tomato"); c.setDietaryPreferences("Vegetarian");
        c.setPassword("12345");  c.setAge(20);c.setEmail("hbzawati@gmail.com");c.setPhoneNumber("0599956733");c.setFitnessGoals("Training in progress");c.setWeight(50);
        try{
            Date birthday=dateFormat.parse("2004-12-12");
            c.setBirthday(birthday);}catch(ParseException e){return;}
        clients.add(new Client(20,"Mayyasa Shaka","55%" ,"30%", "Cardio"  ,null, false,List.of(100)));
        clients.add(new Client(50,"Nahla Hasan","30%","12%", "Cardio"  ,null, false,List.of(100)));
        clients.add(new Client(55,"Fatima Mohammad","30%","12%", "Dance"  ,null, false,List.of(205)));
        discussions.add(new Discussion(96,"Fitness project",null));
    }
    public static String createResult(mainProgram program) {

        if (program.getProgramId()==null || program.getProgramTitle()==null || program.getProgramTitle().trim().isEmpty() || program.getDuration()==null ||
                program.getDuration()<=0 || program.getPrice()<0 || program.getDifficultyLevel()==null ||
                program.getDifficultyLevel().trim().isEmpty() || program.getGoals()==null || program.getGoals().trim().isEmpty() ||
                program.getDescription()==null || program.getDescription().trim().isEmpty() ||
                program.getScheduleType()==null || program.getScheduleType().trim().isEmpty() ||
                program.getScheduleTime()==null || program.getScheduleTime().trim().isEmpty()) {
            return "Fail";
        }
        for(mainProgram p:programs)
        {
            if(p.getProgramId().equals(program.getProgramId()) || p.getScheduleTime().trim().equalsIgnoreCase(program.getScheduleTime()))
                return "Fail";
        }
        return "Success";
    }
    public static void createProgram(mainProgram program) {
        if(createResult(program).equals("Success"))
        {
            programs.add(program);
            System.out.println("CREATION PROGRAM DONE");
        }
        else if(createResult(program).equals("Fail"))
        {
            System.out.println("FAIL TO CREATE PROGRAM");
        }
    }

    public static boolean programExist(int ProgramId) {

        for (mainProgram p:programs)
        {
            if(p.getProgramId().equals(ProgramId))
                return true;
        }
        return false;
    }
    public static String updateResult(int ProgramId) {

        for(mainProgram program:programs) {
            if(ProgramId== program.getProgramId())
            {
                if((!programExist(program.getProgramId())) || program.getProgramId()==null || program.getProgramTitle()==null ||
                        program.getProgramTitle().trim().isEmpty() || program.getDuration()==null ||
                        program.getDuration()<=0 || program.getPrice()<0 || program.getDifficultyLevel()==null ||
                        program.getDifficultyLevel().trim().isEmpty() || program.getGoals()==null ||
                        program.getGoals().trim().isEmpty() || program.getDescription()==null ||
                        program.getDescription().trim().isEmpty() || program.getScheduleType()==null ||
                        program.getScheduleType().trim().isEmpty() || program.getScheduleTime()==null || program.getScheduleTime().trim().isEmpty()) {
                    return "Fail";
                }
            }
        }
        return "Success";
    }
    public static void updateProgram(mainProgram program) {

        if(updateResult(program.getProgramId()).equals("Success"))
        {
            for(mainProgram p:programs) {
                if(p.getProgramId().equals(program.getProgramId())) {
                    p.setProgramId(program.getProgramId());
                    p.setProgramTitle(program.getProgramTitle());
                    p.setDuration(program.getDuration());
                    p.setDifficultyLevel(program.getDifficultyLevel());
                    p.setGoals(program.getGoals());
                    p.setDescription(program.getDescription());
                    p.setPrice(program.getPrice());
                    p.setScheduleType(program.getScheduleType());
                    p.setScheduleTime(program.getScheduleTime());
                    return;
                }
            }

        }
        else if(updateResult(program.getProgramId()).equals("Fail"))
        {
            System.out.println("FAIL TO UPDATE PROGRAM");
        }
    }

    public static String deleteResult(int programId) {
        for(mainProgram program:programs) {
            if(programId== program.getProgramId())
            {
                if(!programExist(program.getProgramId())) {
                    return "Fail";
                }
                if(!mainProgram.login("Instructor")) {
                    return "Fail";
                }
            }
        }
        return "Success";
    }
    public static void deleteProgram(int programId) {
        if(deleteResult(programId).equals("Success"))
        {
            for(mainProgram program:programs) {
                if(programId== program.getProgramId())
                {
                    programs.remove(program);
                    System.out.println("DELETE PROGRAM DONE");
                    return;
                }
            }
        }
        else
        {
            System.out.println("FAIL TO DELETE PROGRAM");
        }
    }
    public static String sendMessResult(int ClientId) {
        clientsWithId.clear();
        for(Client c:clients) {
            if(c.getClientId()==ClientId) {
                clientsWithId.add(c);
            }
        }
        if(clientsWithId.isEmpty())
        {
            return "Fail";
        }
        return "Success";
    }
    public static void sendMessage(String message,int ClientId) {
        for(Client c:clients) {
            if(c.getClientId().equals(ClientId)) {
                c.setMessageDelivered(message);
            }

        }
    }
    public static String postMessResult(int discussionId) {
        discussionsWithId.clear();
        for(Discussion d:discussions) {
            if(d.getDiscussionId()==discussionId) {
                discussionsWithId.add(d);
            }
        }
        if(discussionsWithId.isEmpty())
        {
            return "Fail";
        }
        return "Success";
    }
    public static void postMessage(String message,int DiscussionId) {
        for(Discussion d:discussions)
        {
            if(d.getDiscussionId()==DiscussionId) {
                d.setMessage(message);
            }
        }
    }
    public static String provideFeedbackResult(int ClientId) {

        for(Client c:clients) {
            if(c.getClientId().equals(ClientId)) {
                if(!c.getClientInProgress()) {
                    return "Fail";
                }
            }
        }
        return "Success";
    }
    public static void provideFeedback(int ClientId,String feedback) {
        for(Client c:clients)
        {
            if(c.getClientId().equals(ClientId)) {
                c.setFeedback(feedback);
            }
        }

    }
    public static boolean getClientProgress(int ClientId) {
        boolean cPro=false;
        for(Client c:clients)
        {
            if(c.getClientId()==ClientId) {
                cPro= c.getClientInProgress();
            }
        }
        return cPro;
    }
    public static boolean getGroupAttendance(int ProgramId) {
        boolean gAttend=false;
        for(mainProgram p:programs)
        {
            if(p.getProgramId().equals(ProgramId)) {
                if(p.getNumberOfAttendedClients() == (p.getTotalNumberOfClient()) || p.getNumberOfAttendedClients()==((p.getTotalNumberOfClient())-1)  || p.getNumberOfAttendedClients()==((p.getTotalNumberOfClient())-2)) {
                    gAttend=true;
                }
            }
        }
        return gAttend;
    }
    public static String motRemRecResult(int ClientId) {
        for(Client c:clients) {
            if(c.getClientId().equals(ClientId)) {
                if(c.getClientInProgress()) {
                    return "Fail";
                }
            }
        }
        return "Success";
    }
    public static String motRemRecResults(int ClientId,int ProgramId) {
        boolean match=false;
        List<Integer> progIdList=new ArrayList<Integer>();
        for(Client c:clients) {
            if (c.getClientId().equals(ClientId)) {
                match = true;
                progIdList = c.getProgramsClientIn();
            }
        }
        if(match) {
            for(int progId:progIdList) {
            if(progId==ProgramId) {
                return"Success";
            }
            }
        }
        return "Fail";
    }
    public static void sendMotRemRec(int ClientId,String mot) {
        for(Client c:clients) {
            if(c.getClientId().equals(ClientId)) {
                if(!c.getClientInProgress()) {
                    c.setMessageDelivered(mot);
                }
            }

        }
    }
    public static String notifyResult( int programId, int clientId) {
        boolean match=false;
        List<Integer> IdList=new ArrayList<Integer>();
        for(Client c:clients) {
            if (c.getClientId()==clientId) {
                match = true;
                IdList = c.getProgramsClientIn();
            }
        }
        if(match) {
           for(int Id:IdList) {
               if(Id==programId) {
                   return "Success";
               }
           }
        }
        return "Fail";
    }
    public static String notificationContent(int programId) {
        String message=null;
        if(updateResult(programId).equals("Success")) {
            for(mainProgram p:programs) {
                if(p.getProgramId()==programId) {
                    message= "The time of your "+p.getProgramTitle()+"session changed to "+p.getScheduleTime();
                }
            }
        }
        if(deleteResult(programId).equals("Success")) {
            for(mainProgram p:programs) {
                if(p.getProgramId()==programId) {
                    message= "Your "+p.getProgramTitle()+"session has been canceled for some reasons, we'll get you know about next session ";
                }
            }
        }
        return message;
    }
    public static void notify(int ClientId,int programId) {
        String not=notificationContent( programId);
        for(Client c:clients)
        {
            if(c.getClientId()==ClientId) {
                c.setMessageDelivered(not);
            }
        }
    }
    public static String announceResult(String fDate, String sDate) {
        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today=LocalDate.now();
        String firstDate=fDate;
        String secDate=sDate;
        LocalDate firstDateOfOffer=LocalDate.parse(firstDate,format);
        LocalDate secDateOfOffer=LocalDate.parse(secDate,format);
        if(today.isAfter(firstDateOfOffer))
            return "Fail";
        if(firstDateOfOffer.isAfter(secDateOfOffer))
            return "Fail";
        if(today.isAfter(secDateOfOffer))
            return "Fail";
        return "Success";
    }
    public static void announceNewPro(mainProgram program) {
        if(createResult(program).equals("Success")) {
            System.out.println("New program is available:\n"+"Program Name:\t"+program.getProgramTitle()+
                    "\nDuration:\t"+program.getDuration()+"\nDifficulty level:\t"+program.getDifficultyLevel()+
                    "\nGoals:\t"+program.getGoals()+"\nDescription:\t"+program.getDescription()+
                    "\nPrice:\t"+program.getPrice()+"\nSchedule type:\t"+program.getScheduleType()+
                    "\nSchedule time:\t"+program.getScheduleTime());
        }
    }
    public static void announceOffer(Offer offer) {
        if(announceResult(offer.getFirstDate(),offer.getLastDate()).equals("Success"))
          System.out.println("New Offer is available:\n"+ "Offer title:\t"+offer.getOfferTitle()+"\nDescription:\t"+ offer.getOfferDescription()+"\nPeriod of offer:\tFrom  "+offer.getFirstDate()+"To  "+offer.getLastDate()+"\nprice:\t"+offer.getPrice());
    }

    public static Client getClientDetails(int ClientId) {
        for (Client c : clients) {
            if (c.getClientId() == ClientId) {
                return c;
            }
        }
        return null;
    }

    public static mainProgram getProgramDetails(int ProgramId) {
        for (mainProgram p : programs) {
            if (p.getProgramId() == ProgramId) {
                return p;
            }
        }
        return null;
    }


    public static void createAccount(Map<String, String> accountsD) {
        if (accountsD == null || accountsD.get("Email") == null) {
            throw new IllegalArgumentException("Account details or Email cannot be null");
        }
        accounts.put(accountsD.get("Email"), accountsD);
    }

    public static Map<String, String> getAccountDet(String Email) {
        for (Client c : clients) {
            if (c.getEmail().equals(Email)) {
                return accounts.get(Email);
            }
        }
        return null;
    }

    public static void updateDietaryPreferences(String Email, Map<String, String>dietaryPreferences) {
        for(Client c:clients) {
            if(c.getEmail().equals(Email)) {
                if(dietaryPreferences.containsKey("Dietary preferences")) {
                    c.setDietaryPreferences(dietaryPreferences.get("Dietary preferences"));
                }
                if(dietaryPreferences.containsKey("Restrictions")) {
                    c.setRestrictions(dietaryPreferences.get("Restrictions"));
                }
            }
        }
    }
    public static void addPro(){
        programsForExpo.add(new mainProgram(     205     , "Dance" , 60 , "Advanced" , "Weight loss", "image" , 50 , "In-Person" , "Sunday , 9:00am-10:00am"));
        programsForExpo.add(new mainProgram(     100     , "Cardio" , 60 , "Intermediate" , "Weight loss", "video" , 70 , "In-Person" , "Sunday-Tuesday , 7:00pm-8:00pm"));
    }
    public static List<mainProgram> filterByDifficultyLevel(String difficultyLevel) {
        programsByDiff=null;
        programsByDiff=programsForExpo.stream().filter(p -> p.getDifficultyLevel().trim().equals(difficultyLevel)).collect(Collectors.toList());
        return programsByDiff;
    }
    public static List<mainProgram> filterByFocusArea(String goal) {
        programsByGoal=null;
        programsByGoal=programsForExpo.stream().filter(p -> p.getGoals().trim().equals(goal)).collect(Collectors.toList());
        return programsByGoal;
    }


}
