package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;


class MemberTest {

    LocalDate date1 = LocalDate.now();
    LocalDate date2 = LocalDate.of(2000,01,01);

    Member member1 = new Member("891219", "David", date1);
    Member member2 = new Member("891212", "Oscar", date2);

    ArrayList<LocalDate> arrTest = new ArrayList<>();

    String expectedString = "\nID Nr: " + "891219" + "\nName: " + "David" + "\nMembership paid: " + date1 + "\nTimes visited: " + arrTest.size() +
            "\nLast visit: " + "First visit.\n";

    @Test
    void setPaid() {

        member1.setPaid(date1);
        member2.setPaid(date2);

        assert(member1.isMember());
        assert(member2.isMember() == false);
    }

    @Test
    void train() {

        arrTest.add(date1);
        member1.train();
        assert(arrTest.size()>0);

    }

    @Test
    void testToString() {

        assertEquals(expectedString, member1.toString());
    }
}