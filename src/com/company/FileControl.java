package com.company;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FileControl {

    public static ArrayList<Member> readMembersFile(File file) {

        ArrayList<Member> members = new ArrayList<>();

        try (Scanner sc = new Scanner(file)){
            while (sc.hasNext()) {
                String nameID = sc.nextLine();
                String[] nameIDSplit = nameID.split(", ");
                String paid = sc.nextLine();
                LocalDate paidDate = LocalDate.parse(paid);

                members.add(new Member(nameIDSplit[0], nameIDSplit[1], paidDate));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return members;
    }

    public static ArrayList<LocalDate> readVisitsFile(File file) {

        ArrayList<LocalDate> visits = new ArrayList<>();

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String visit = sc.nextLine();
                LocalDate visitDate = LocalDate.parse(visit);

                visits.add(visitDate);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return visits;
    }

    public static boolean WriteFile(File fileName, ArrayList<LocalDate> visits){

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))){
            for (LocalDate localdate: visits) {
                pw.println(localdate);
            }
            pw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
