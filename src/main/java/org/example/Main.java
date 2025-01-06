package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scan=new Scanner(System.in)	;
    public static void main(String[] args) {

        while(true) {
            System.out.println("PLEASE CHOOSE ONE");
            System.out.println("1- Create Program");
            System.out.println("2- Update Program");
            System.out.println("3- Delete Program");
            System.out.println("4- Communicate with clients");
            System.out.println("5- Provide feedback to clients");
            System.out.println("6- Monitor client progress");
            System.out.println("7- Send motivational reminders or recommendations");
            System.out.println("8-  Notify clients about changes to program schedules");
            System.out.println("9- Announce new program");
            System.out.println("10- Announce special offers");
            int choice =scan.nextInt();
            if (choice==1) {

            }
            else if (choice==2) {

            }
            else if (choice==3) {

            }
            else if (choice==4) {

            }
            else if (choice==5) {

            }
            else if (choice==6) {

            }
            else if (choice==7) {

            }
            else if (choice==8) {

            }
            else if (choice==9) {

            }
            else if (choice==10) {

            }
            else {
                System.out.println("Invalid Choice please try again choose from 1 to 10");
            }
        }
    }
}