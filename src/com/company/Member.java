package com.company;


import java.time.LocalDate;
import java.util.ArrayList;

public class Member {

    private String idNr;
    private String name;
    private boolean member;
    private LocalDate paid;
    private ArrayList<LocalDate> trainingDates;


    public Member(String idNr, String name, LocalDate paid){
        this.idNr = idNr;
        this.name = name;
        setPaid(paid);
        trainingDates = new ArrayList<>();
    }

    public boolean isMember(){
       return member;
    }

    public void setPaid(LocalDate paid) {

        this.paid = paid;

        LocalDate date = LocalDate.now().minusYears(1);
        if (paid.isAfter(date)) {
            member = true;
        } else if (paid.isBefore(date)) {
            member = false;
        }
    }

    public void train(){
        trainingDates.add(LocalDate.now());
    }

    public ArrayList<LocalDate> getTrainingDates(){
        return trainingDates;
    }

    public void setTrainingDates(ArrayList<LocalDate> dates){
        trainingDates = dates;
    }

    public String getIdNr() {
        return idNr;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getPaid() {
        return paid;
    }

    @Override
    public String toString(){
        String ret = ("\nID Nr: " + idNr + "\nName: " + name + "\nMembership paid: " + paid + "\nTimes visited: " + trainingDates.size() +
                "\nLast visit: " );
        if (trainingDates.size() >= 1)
            ret += trainingDates.get(trainingDates.size()-1) + "\n";
        else
            ret += "First visit.\n";
        return ret;
    }

}
