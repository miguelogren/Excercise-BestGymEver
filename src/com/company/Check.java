package com.company;

import java.util.ArrayList;

public class Check {

    public static Member isActiveMember(ArrayList<Member> arr, String person) {

        for (int i = 0; i < arr.size(); ++i) {
            Member currentMember = arr.get(i);

            if (person.equals(currentMember.getIdNr()) || person.equalsIgnoreCase(currentMember.getName())) {
                return currentMember;
            }
        }
        return null;
    }
}
