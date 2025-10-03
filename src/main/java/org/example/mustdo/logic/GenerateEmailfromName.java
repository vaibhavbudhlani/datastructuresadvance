package org.example.mustdo.logic;

import java.util.*;

public class GenerateEmailfromName {
    public static void main(String[] args) {
//        1.
//        S = "john Doe; Peter Benjamin Parker; Mary Jane Watson-Parker"
//        C = "example.com"
//        generate email id for each in format "firstname.lastname@example.com"
//        For duplicate email append number at end.
//
//
//                Ex: john.doe@example.com, john,doe2@example.com
//        Last name in email should be maximum of 8 characters

        String s = "john Doe;john doe; Peter Benjamin Parker; Mary Jane Watson-Parker";
        String domain = "example.com";

//        String[] names = s.split(";");
//        Map<String, Integer> emailCount = new HashMap<>();
        GenerateEmailfromName obj = new GenerateEmailfromName();
        List<String> emails = obj.generateEmailFlag(s,domain);

//        for (String name : names) {
//            name = name.trim();
//            // Split by space and hyphen (correct regex: [\s-]+)
//            String[] parts = name.split("[\\s-]+");
//            String firstName = parts[0].toLowerCase();
//            String lastName = parts[parts.length - 1].toLowerCase();
//            // Truncate last name to 8 chars
//            if (lastName.length() > 8) {
//                lastName = lastName.substring(0, 8);
//            }
//            String emailKey = firstName + "." + lastName;
//            int count = emailCount.getOrDefault(emailKey, 0) + 1;
//            emailCount.put(emailKey, count);
//            String email = emailKey + (count > 1 ? count : "") + "@" + domain;
//            emails.add(email);
//        }
        // Print emails
        for (String email : emails) {
            System.out.println(email);
        }
    }

    public List<String> generateEmailFlag(String s, String domain){

     //   S = "john Doe; Peter Benjamin Parker; Mary Jane Watson-Parker"
//        C = "example.com"
        List<String> ls = new ArrayList<>();
        String[] names = s.split(";");
        Map<String,Integer> hm = new HashMap<>();

        for(String name:names){
            name = name.trim();
            String parts[] = name.split("[\\s-]+");

            String firstName = parts[0].toLowerCase();
            String lastName = parts[parts.length-1].toLowerCase();

            if(lastName.length() > 8){
                lastName = lastName.substring(0,8);
            }
            String finalName = firstName+ "." + lastName;

            int count = hm.getOrDefault(finalName, 0)+1;
            hm.put(finalName, count );

            String domainName = finalName + (count > 1 ? count : "") + "@" + domain;

            ls.add(domainName);


        }

        return ls;
    }
}
