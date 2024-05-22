package com.company;

import java.io.*;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

/**
 * Club is in charge of saving a Club object with his properties.
 * Each Club has a list of members,a list of admin,a list of matches and a list of courses.
 */
public class Club {

    private Member[] MembersList;
    private Admin[] AdminList;
    private Match[] MatchList;
    private Course[] CoursesList;


    public Club() {
        // initializing the arrays
        MembersList = new Member[3];
        AdminList = new Admin[2];
        MatchList = new Match[4];
        CoursesList = new Course[3];

        try {
            File log = new File("log.txt");

            if (log.createNewFile()) {
                System.out.println("File created" + log.getName());
            } else {
                System.out.println("Existing file");
            }
        } catch (IOException c) {
            System.out.println("Error in creating the file");
            c.printStackTrace();
        }

        try {
            FileWriter log = new FileWriter("log.txt");
            log.write("Test \n");
            System.out.println("Write successfull");

            // add members
            MembersList[0] = new Member("Giuseppe", " Dimonte", "dimogiuseppe@gmail.com", "299765");
            String a = (String) MembersList[0].getName() + (String) MembersList[0].getSurname()
                    + " has been added to the membership list \n";
            System.out.print(a);
            log.write(a);

            MembersList[1] = new Member("Martina", " Dominici", "martinadominici345@gmail.com", "300494");
            String b = (String) MembersList[1].getName() + (String) MembersList[1].getSurname()
                    + " has been added to the membership list \n";
            System.out.print(b);
            log.write(b);

            MembersList[2] = new Member("Derby", " Atswei Kommey", "derbyblessing@gmail.com", "294769");
            String c = (String) MembersList[2].getName() + (String) MembersList[2].getSurname()
                    + " has been added to the membership list \n";
            System.out.print(c);
            log.write(c);

            // add admin
            AdminList[0] = new Admin("Laura", " Rossi", "rossilaura@gmail.com", "125776");
            String d = (String) AdminList[0].getName() + (String) AdminList[0].getSurname()
                    + " has been added to the administrators list \n";
            System.out.print(d);
            log.write(d);

            AdminList[1] = new Admin("Cesare", " Verdi", "cesareverdi565@gmail.com", "893456");
            String e = (String) AdminList[1].getName() + (String) AdminList[1].getSurname()
                    + " has been added to the administrators list \n";
            System.out.print(e);
            log.write(e);

            // add matches
            MatchList[0] = new Match("Swimming", new Person[0]);
            String f = (String) MatchList[0].getName() + " has been added to the match list \n";
            System.out.print(f);
            log.write(f);

            MatchList[1] = new Match("Volleyball", new Person[0]);
            String g = (String) MatchList[1].getName() + " has been added to the match list \n";
            System.out.print(g);
            log.write(g);

            MatchList[2] = new Match("Basketball", new Person[0]);
            String h = (String) MatchList[2].getName() + " has been added to the match list \n";
            System.out.print(h);
            log.write(h);


            MatchList[3] = new Match("Joga", new Person[0]);
            String ii = (String) MatchList[3].getName() + " has been added to the match list \n";
            System.out.print(ii);
            log.write(ii);

            // add courses
            CoursesList[0] = new Course("Judo", new Person[0]);
            String j = (String) CoursesList[0].getName() + " has been added to the course list \n";
            System.out.print(j);
            log.write(j);

            CoursesList[1] = new Course("Fencing", new Person[0]);
            String k = (String) CoursesList[1].getName() + " has been added to the course list \n";
            System.out.print(k);
            log.write(k);

            CoursesList[2] = new Course("Water polo", new Person[0]);
            String l = (String) CoursesList[2].getName() + " has been added to the course list \n";
            System.out.print(l);
            log.write(l);


            //admin Laura adds a new member
            AdminList[0].AddMember(new Member("Paolo", "Bianchi", "pbianchi@gmail.com", "778899"), this);
            String m = (String) AdminList[0].getName() + " has added " + (String) MembersList[3].getName() + " to the membership list \n";
            System.out.print(m);
            log.write(m);
            // admin Cesare removes Martina from the members list
            Person removed = MembersList[1];
            AdminList[1].RemoveMember(MembersList[1], this);
            String n = (String) AdminList[1].getName() + " has removed " + (String) removed.getName() + " to the membership list \n";
            System.out.print(n);
            log.write(n);
            // admin Laura changes Derby's name to Giulia
            String oldName = MembersList[1].getName();
            String newName = "Giulia";
            AdminList[0].ChangeName(MembersList[1], newName);
            String o = (String) AdminList[0].getName() + " has changed the name to " + oldName + " in " + newName + "\n";
            System.out.print(o);
            log.write(o);
            // Giuseppe subscribes to swimming match
            MembersList[0].SubmitMatch(MatchList[0]);
            String p = (String) MatchList[0].getParticipants()[MatchList[0].getParticipants().length - 1].getName() + " subscribed to " + (String) MatchList[0].getName()+ "\n";
            System.out.print(p);
            log.write(p);
            // Giuseppe subsribes to judo course
            MembersList[0].SubmitCourse(CoursesList[0]);
            String q = (String) MembersList[0].getName() + " subscribed to " + (String) CoursesList[0].getName()+ "\n";
            System.out.print(q);
            log.write(q);
            // Giuseppe unsubscribes to judo course
            MembersList[0].DeleteSubmitCourse(CoursesList[0]);
            String r = (String) MembersList[0].getName() + " unsubscribed from " + (String) CoursesList[0].getName() + "\n";
            System.out.print(r);
            log.write(r);
            // print the members ist
            String s = "Membership list: \n";
            System.out.print(s);
            log.write(s);
            for (int i = 0; i < MembersList.length; i++) {
                String t = (String) MembersList[i].getName()+ "\n";
                System.out.print(t);
                log.write(t);
            }
            // print the admins list
            String u = "Administrators list: \n";
            System.out.print(u);
            log.write(u);
            for (int i = 0; i < AdminList.length; i++) {
                String v = AdminList[i].getName()+ "\n";
                System.out.print(v);
                log.write(v);
            }
            // print the matches list
            String w = "Match list: \n";
            System.out.print(w);
            log.write(w);
            for (int i = 0; i < MatchList.length; i++) {
                String x = MatchList[i].getName() + ": " + printParticipantsList(MatchList[i])+ "\n";
                System.out.print(x);
                log.write(x);
            }
            // print the courses list
            String y = "Course list: \n";
            System.out.print(y);
            log.write(y);
            for (int i = 0; i < CoursesList.length; i++) {
                String z = CoursesList[i].getName() + ": " + printParticipantsList(CoursesList[i])+ "\n";
                System.out.print(z);
                log.write(z);
            }

            log.close();

        } catch (IOException c) {
            System.out.println("An error occurred");
            c.printStackTrace();
        }
    }

    // main for the club
    public static void main(String[] args) {

        Club c = new Club();

    }

    /**
     * This method gets the member's list.
     *
     * @return the member's list.
     */
    public Member[] getMembersList() {
        return MembersList;
    }

    /**
     * This method sets the member's list.
     *
     * @param memberslist the member's list.
     * @return void
     */
    public void setMembersList(Member[] memberslist) {
        MembersList = memberslist;
    }

    /**
     * This method gets the admins's list.
     *
     * @return the admins's list.
     */
    public Admin[] getAdminList() {
        return AdminList;
    }

    /**
     * This method sets the admins's list.
     *
     * @param adminlist the admins's list.
     * @return void
     */
    public void setAdminList(Admin[] adminlist) {
        AdminList = adminlist;
    }

    /**
     * This method gets the matches's list.
     *
     * @return the matches's list.
     */
    public Match[] getMatchList() {
        return MatchList;
    }

    /**
     * This method sets the matches's list.
     *
     * @param matchlist the matches's list.
     * @return void
     */
    public void setMatchList(Match[] matchlist) {
        MatchList = matchlist;
    }

    /**
     * This method gets the courses's list.
     *
     * @return the courses's list.
     */
    public Course[] getCoursesList() {
        return CoursesList;
    }

    /**
     * This method sets the courses's list.
     *
     * @param courseslist the courses's list.
     * @return void
     */
    public void setCoursesList(Course[] courseslist) {
        CoursesList = courseslist;
    }


    // method for printing the members list of an input activity

    /**
     * This method prints the members of an input activity
     *
     * @param a the input activity
     * @return the string containing the members's list
     */
    public String printParticipantsList(Activity a) {
        String Participants = "";
        for (int i = 0; i < a.getParticipants().length; i++) {

            Participants = Participants + a.getParticipants()[i].getName() + " ";
        }
        return Participants;
    }

}