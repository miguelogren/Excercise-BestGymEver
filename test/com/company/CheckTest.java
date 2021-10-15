package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.time.LocalDate;
import java.util.ArrayList;

class CheckTest {

    Check check = new Check();

    Member Member1 = new Member("891219", "David", LocalDate.of(1003, 01, 18));
    Member Member2 = new Member("121212", "blaj", LocalDate.of(2021,02,03));


    ArrayList<Member> arr = new ArrayList<>();

    @Test
    public void isActiveMemberTest(){

        arr.add(Member1);
        arr.add(Member2);

        assertTrue(check.isActiveMember(arr, "891219").equals(Member1));
        assertFalse(check.isActiveMember(arr, "891219").equals(Member2));

    }
}