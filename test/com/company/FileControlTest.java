package com.company;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class FileControlTest {

    FileControl fc = new FileControl();

    @org.junit.jupiter.api.Test
    void readMembersFile() {
        File membersFile = new File(System.getProperty("user.dir")+"\\customers.txt");
        assert(fc.readMembersFile(membersFile).size()>0);

        File membersFile2 = new File(System.getProperty("user.dir")+"\\trash.txt");
        assert(fc.readMembersFile(membersFile2).size()==0);

    }

    @org.junit.jupiter.api.Test
    void readVisitsFile() {
        File visitsFile = new File(System.getProperty("user.dir")+"\\TestVisits.txt");
        assert(fc.readVisitsFile(visitsFile).size()>0);

        File visitsFile2 = new File(System.getProperty("user.dir")+"\\trash.txt");
        assert(fc.readVisitsFile(visitsFile2).size()==0);
    }

    @org.junit.jupiter.api.Test
    void writeFile() {

        ArrayList<LocalDate> testArray = new ArrayList<>();
        LocalDate randomDate = LocalDate.now();
        testArray.add(randomDate);
        File randomDateFile = new File(System.getProperty("user.dir")+"\\TestWrite.txt");

        assert(fc.WriteFile(randomDateFile, testArray));

        assert (!fc.WriteFile(null, testArray));
    }
}