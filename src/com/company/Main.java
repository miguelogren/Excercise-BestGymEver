package com.company;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String parentFolder = System.getProperty("user.dir");
        
        File membersFile = new File(parentFolder+"\\Customers.txt");
        ArrayList<Member> members = FileControl.readMembersFile(membersFile);

        String id = JOptionPane.showInputDialog("Skriv in personnummer eller namn och efternamn: ");
        Member currentCustomer = Check.isActiveMember(members, id);

        if (currentCustomer != null) {
            if (currentCustomer.isMember()) {
                String member = currentCustomer.getIdNr()+currentCustomer.getName()+".txt";
                File memberFile = new File(parentFolder+"\\"+member);
                currentCustomer.setTrainingDates(FileControl.readVisitsFile(memberFile));
                currentCustomer.train();
                System.out.println(currentCustomer.getName() + " is a member. Membership was paid " + currentCustomer.getPaid());
                FileControl.WriteFile(memberFile, currentCustomer.getTrainingDates());
            }
            else
                System.out.println(currentCustomer.getName() + "Is no longer a member. Membership was last paid " + currentCustomer.getPaid());
        }
        else System.out.println("Person has never been here before.");
    }
}
