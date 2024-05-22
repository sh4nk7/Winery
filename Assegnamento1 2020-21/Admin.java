package com.company;

/**
 * Admin is a Person subclass which is in charge of saving an admin with its properties.
 */
public class Admin extends Person {

    public Admin(final String n, final String s, final String e, final String p) {
        // child class of 'Person'
        super(n, s, e, p);
    }

    // Membership management
    // Method for adding a member
    /**
     * This method adds a new member to the members's list.
     *
     * @param m the member that wants to register.
     * @param c the course or the match in which the participant wants to register.
     *
     * @return void
     */
    public void AddMember(Member m, Club c) {
        // array that will contain the new members
        Member[] UpdatedMembers = new Member[c.getMembersList().length + 1];
        // analyze each member from the old member list
        for (int i = 0; i < c.getMembersList().length; i++) {
            // I copy it into the new array
            System.arraycopy(c.getMembersList(), i, UpdatedMembers, i, 1);
        }
        //add the new member into the new array
        Member[] adder = {m};
        System.arraycopy(adder, 0, UpdatedMembers, UpdatedMembers.length - 1, 1);
        c.setMembersList(UpdatedMembers);
    }

    // Method for removing a member
    /**
     * This method deletes a member from the members's list.
     *
     * @param m the member that wants to unregister.
     * @param c the club.
     *
     * @return void
     */
    public void RemoveMember(Member m, Club c) {
        // create a variable containing the old member list
        Member[] removed = c.getMembersList();
        //array that will contain the new member list
        Member[] UpdatedMembers = new Member[removed.length - 1];
        //boolean to check if the member that needed to be removed is already been deleted or not
        boolean BoxSwitch = false; //false as default
        // analyze each member from the old member list
        for (int i = 0; i < removed.length; i++) {
            //control if the ID of the analyzed member is the same as the member that needs to be deleted
            if (removed[i].getId() != m.getId()) {
                //if the member that needs to be deleted is not deleted yet
                if (BoxSwitch == false) {
                    //copy the old member in the new array
                    System.arraycopy(removed, i, UpdatedMembers, i, 1);
                } else //if the member has been removed
                {
                    //i copy the new member into the new array but of a box moved to the left
                    System.arraycopy(removed, i, UpdatedMembers, i - 1, 1);
                }
            } else  //if the ID of  the member is the same as the one who gave the command then the member is not copied and the bool becomes true
            {
                BoxSwitch = true;
            }
        }
        //update the member list
        c.setMembersList(UpdatedMembers);
    }


    //admin management
    // Method for adding an admin(same procedure as 'AddMember')
    /**
     * This method adds a new admin to the admin's list.
     *
     * @param a the admin that wants to register.
     * @param c the club.
     *
     * @return void
     */
    public void AddAdmin(Admin a, Club c) {
        Admin[] UpdatedAdmins = new Admin[c.getAdminList().length + 1];
        for (int i = 0; i < c.getAdminList().length; i++) {
            System.arraycopy(c.getAdminList(), i, UpdatedAdmins, i, 1);
        }
        Person[] adder = {a};
        System.arraycopy(adder, 0, UpdatedAdmins, UpdatedAdmins.length - 1, 1);
        c.setAdminList(UpdatedAdmins);
    }

    // Method for removing ad admin(same procedure as 'RemoveMember')
    /**
     * This method removes a new admin from the admin's list.
     *
     * @param a the admin that wants to unregister.
     * @param c the club.
     *
     * @return void
     */
    public void RemoveAdmin(Admin a, Club c) {
        Admin[] removed = c.getAdminList();
        Admin[] UpdatedAdmins = new Admin[removed.length - 1];
        boolean BoxSwitch = false;
        for (int i = 0; i < removed.length; i++) {
            if (removed[i].getId() != a.getId()) {
                if (BoxSwitch == false) {
                    System.arraycopy(removed, i, UpdatedAdmins, i, 1);
                } else {
                    System.arraycopy(removed, i, UpdatedAdmins, i - 1, 1);
                }
            } else {
                BoxSwitch = true;
            }
        }
        c.setAdminList(UpdatedAdmins);
    }

    // Method for changing the person's name
    /**
     * This method changes the person name.
     *
     * @param p the member that wants to modify the name.
     * @param str the member's name.
     *
     * @return void
     */
    public void ChangeName(Person p, String str) {
        p.setName(str);
    }

    // Method for changing the person's surname
    /**
     * This method changes the person surname.
     *
     * @param p the member that wants to modify the surname.
     * @param str the member's surname.
     *
     * @return void
     */
    public void ChangeSurname(Person p, String str) {
        p.setSurname(str);
    }

    // Method for changing the person's email
    /**
     * This method changes the person email.
     *
     * @param p the member that wants to modify the email.
     * @param str the member's email.
     *
     * @return void
     */
    public void ChangeEmail(Person p, String str) {
        p.setEmail(str);
    }

    // Method for changing the person's password
    /**
     * This method changes the person password.
     *
     * @param p the member that wants to modify the password.
     * @param str the member's password.
     *
     * @return void
     */
    public void ChangePassword(Person p, String str) {
        p.setPassword(str);
    }


    //match management
    // Method for adding a match(same procedure as 'AddMember')
    /**
     * This method adds a match to the matches's list.
     *
     * @param ma the match that need to be added.
     * @param c the club.
     *
     * @return void
     */
    public void AddMatch(Match ma, Club c) {
        Match[] UpdatedMatches = new Match[c.getMatchList().length + 1];
        for (int i = 0; i < c.getMatchList().length; i++) {
            System.arraycopy(c.getMatchList(), i, UpdatedMatches, i, 1);
        }
        Match[] adder =
                {ma};
        System.arraycopy(adder, 0, UpdatedMatches, UpdatedMatches.length - 1, 1);
        c.setMatchList(UpdatedMatches);
    }

    // Method for removing a match(same procedure as 'RemoveMember')
    /**
     * This method deletes a match from the matches's list.
     *
     * @param ma the match that need to be deleted.
     * @param c the club.
     *
     * @return void
     */
    public void RemoveMatch(Match ma, Club c) {
        Match[] removed = c.getMatchList();
        Match[] UpdatedMatches = new Match[removed.length - 1];
        boolean BoxSwitch = false;
        for (int i = 0; i < removed.length; i++) {
            if (removed[i].getName() != ma.getName()) {
                if (BoxSwitch == false) {
                    System.arraycopy(removed, i, UpdatedMatches, i, 1);
                } else {
                    System.arraycopy(removed, i, UpdatedMatches, i - 1, 1);
                }
            } else {
                BoxSwitch = true;
            }
        }
        c.setMatchList(UpdatedMatches);
    }
    //course management

    // Method for adding a course(same procedure as 'AddMember')
    /**
     * This method adds a course to the courses's list.
     *
     * @param co the couse that need to be added.
     * @param c the club.
     *
     * @return void
     */
    public void AddCourse(Course co, Club c) {
        Course[] UpdatedCourses = new Course[c.getCoursesList().length + 1];
        for (int i = 0; i < c.getCoursesList().length; i++) {
            System.arraycopy(c.getCoursesList(), i, UpdatedCourses, i, 1);
        }
        Course[] adder =
                {co};
        System.arraycopy(adder, 0, UpdatedCourses, UpdatedCourses.length - 1, 1);
        c.setCoursesList(UpdatedCourses);
    }

    // Method for removing a course(same procedure as 'RemoveMember')
    /**
     * This method deletes a course to the courses's list.
     *
     * @param co the match that need to be deleted.
     * @param c the club.
     *
     * @return void
     */
    public void RemoveCourse(Course co, Club c) {
        Course[] removed = c.getCoursesList();
        Course[] UpdatedCourses = new Course[removed.length - 1];
        boolean BoxSwitch = false;
        for (int i = 0; i < removed.length; i++) {
            if (removed[i].getName() != co.getName()) {
                if (BoxSwitch == false) {
                    System.arraycopy(removed, i, UpdatedCourses, i, 1);
                } else {
                    System.arraycopy(removed, i, UpdatedCourses, i - 1, 1);
                }
            } else {
                BoxSwitch = true;
            }
        }
        c.setCoursesList(UpdatedCourses);
    }

    //Method for changing the activity's name
    /**
     * This method modify an activity's name.
     *
     * @param a the activity to which i need to modify the name.
     * @param s the activity's name.
     *
     * @return void
     */
    public void ChangeName(Activity a, String s) {
        a.setName(s);
    }

}