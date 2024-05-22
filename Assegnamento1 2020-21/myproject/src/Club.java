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

        // add members
        MembersList[0] = new Member("Giuseppe", " Dimonte", "dimogiuseppe@gmail.com", "299765");
        System.out.print((String) MembersList[0].getName() + (String) MembersList[0].getSurname()
                + " has been added to the membership list \n");

        MembersList[1] = new Member("Martina", " Dominici", "martinadominici345@gmail.com", "300494");
        System.out.print((String) MembersList[1].getName() + (String) MembersList[1].getSurname()
                + " has been added to the membership list \n");
        MembersList[2] = new Member("Derby", " Atswei Kommey", "derbyblessing@gmail.com", "294769");
        System.out.print((String) MembersList[2].getName() + (String) MembersList[2].getSurname()
                + " has been added to the membership list \n");
        // add admin
        AdminList[0] = new Admin("Laura", " Rossi", "rossilaura@gmail.com", "125776");
        System.out.print((String) AdminList[0].getName() + (String) AdminList[0].getSurname()
                + " has been added to the administrators list \n");
        AdminList[1] = new Admin("Cesare", " Verdi", "cesareverdi565@gmail.com", "893456");
        System.out.print((String) AdminList[1].getName() + (String) AdminList[1].getSurname()
                + " has been added to the administrators list \n");
        // add matches
        MatchList[0] = new Match("Swimming", new Person[0]);
        System.out.print((String) MatchList[0].getName() + " has been added to the match list \n");
        MatchList[1] = new Match("Volleyball", new Person[0]);
        System.out.print((String) MatchList[1].getName() + " has been added to the match list \n");
        MatchList[2] = new Match("Basketball", new Person[0]);
        System.out.print((String) MatchList[2].getName() + " has been added to the match list \n");
        MatchList[3] = new Match("Joga", new Person[0]);
        System.out.print((String) MatchList[3].getName() + " has been added to the match list \n");
        // add courses
        CoursesList[0] = new Course("Judo", new Person[0]);
        System.out.print((String) CoursesList[0].getName() + " has been added to the course list \n");
        CoursesList[1] = new Course("Fencing", new Person[0]);
        System.out.print((String) CoursesList[1].getName() + " has been added to the course list \n");
        CoursesList[2] = new Course("Water polo", new Person[0]);
        System.out.print((String) CoursesList[2].getName() + " has been added to the course list \n");


        //admin Laura adds a new member
        AdminList[0].AddMember(new Member("Paolo", "Bianchi", "pbianchi@gmail.com", "778899"), this);
        System.out.print(
                (String) AdminList[0].getName() + " has added " + (String) MembersList[3].getName()
                        + " to the membership list \n");

        // admin Cesare removes Martina from the members list
        Person removed = MembersList[1];
        AdminList[1].RemoveMember(MembersList[1], this);
        System.out
                .print(
                        (String) AdminList[1].getName() + " has removed " + (String) removed.getName() + " to the membership list \n");

        // admin Laura changes Derby's name to Giulia
        String oldName = MembersList[1].getName();
        String newName = "Giulia";
        AdminList[0].ChangeName(MembersList[1], newName);
        System.out.print((String) AdminList[0].getName() + " has changed the name to " + oldName + " in " + newName + "\n");

        // Giuseppe subscribes to swimming match
        MembersList[0].SubmitMatch(MatchList[0]);
        System.out.println(
                (String) MatchList[0].getParticipants()[MatchList[0].getParticipants().length - 1].getName()
                        + " subscribed to " + (String) MatchList[0].getName());


        // Giuseppe subsribes to judo course
        MembersList[0].SubmitCourse(CoursesList[0]);
        System.out.println(
                (String) MembersList[0].getName() + " subscribed to " + (String) CoursesList[0].getName());


        // Giuseppe unsubscribes to judo course
        MembersList[0].DeleteSubmitCourse(CoursesList[0]);
        System.out.println(
                (String) MembersList[0].getName() + " unsubscribed from " + (String) CoursesList[0].getName() + "\n");


        // print the members ist
        System.out.println("Membership list: \n");
        for (int i = 0; i < MembersList.length; i++) {
            System.out.println(MembersList[i].getName());
        }

        // print the admins list
        System.out.println("\n");
        System.out.println("Administrators list: \n");
        for (int i = 0; i < AdminList.length; i++) {
            System.out.println(AdminList[i].getName());
        }

        // print the matches list
        System.out.println("\n");
        System.out.println("Match list: \n");
        for (int i = 0; i < MatchList.length; i++) {
            System.out.println(MatchList[i].getName() + ": " + printParticipantsList(MatchList[i]));
        }

        // print the courses list
        System.out.println("\n");
        System.out.println("Course list: \n");
        for (int i = 0; i < CoursesList.length; i++) {
            System.out.println(CoursesList[i].getName() + ": " + printParticipantsList(CoursesList[i]));
        }
    }

    // main for the club
    public static void main(String[] args) {
        try {
            File log = new File("log.txt");

            if (log.createNewFile()) {
                System.out.println("File created"+ log.getName());
            } else {
                System.out.println("Existing file");
            }

        } catch (IOException c) {
            System.out.println("Error in creating the file");
            c.printStackTrace();
        }


        try {
            FileWriter log = new FileWriter("log.txt");
            log.write("Existing file\nWrite successfull\nGiuseppe Dimonte has been added to the membership list\nMartina Dominici has been added to the membership list\nDerby Atswei Kommey has been added to the membership list\nLaura Rossi has been added to the administrators list\nCesare Verdi has been added to the administrators list\nSwimming has been added to the match list\nVolleyball has been added to the match list\nBasketball has been added to the match list\nJoga has been added to the match list\nJudo has been added to the course list\nFencing has been added to the course list\nWater polo has been added to the course list\nLaura has added Paolo to the membership list\nCesare has removed Martina to the membership list\nLaura has changed the name to Derby in Giulia\nGiuseppe subscribed to Swimming\nGiuseppe subscribed to Judo\nGiuseppe unsubscribed from Judo\n\n\nMembership list: \nGiuseppe\nGiulia\nPaolo\n\n\nAdministrators list:\nLaura\nCesare\n\nMatch list:\n\nSwimming: Giuseppe\nVolleyball:\nBasketball:\nJoga: \n\nCourse list: \n\nJudo:\nFencing:\nWater polo:" );
            log.close();
            System.out.println("Write successfull");
        } catch (IOException c) {
            System.out.println("An error occured.");
            c.printStackTrace();
        }

        {
            Club c = new Club();

        }
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