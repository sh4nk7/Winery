package com.company;

/**
 * Member is a Person subclass which is in charge of saving a member with its properties.
 */
public class Member extends Person {
    public Member(final String n, final String s, final String e, final String p) {
        // child class of 'Person?
        super(n, s, e, p);
    }


    //subscription to a match
    /**
     * This method adds a new participant to the matches's list.
     *
     * @param ma the match in which the participant wants to register.
     *
     * @return void
     */
    public void SubmitMatch(Match ma) {
        //new array that will contain the new members subscribed to the match

        Person[] UpdatedParticipants = new Person[ma.getParticipants().length + 1];
        Person[] i =
                {this}; // person who subscribe
        // check if the array of the participants is not empty
        if (ma.getParticipants().length == 0) {
            // if it is empty,add the new participant into the array
            System.arraycopy(i, 0, UpdatedParticipants, 0, 1);
            // update the participants of the match
            ma.setParticipants(UpdatedParticipants);
        } else {
            // if the array is not empty,i copy the old participants
            for (int d = 0; d < ma.getParticipants().length; d++) {
                System.arraycopy(ma.getParticipants(), d, UpdatedParticipants, d, 1);
            }
            // and add the new participant in last position
            System.arraycopy(i, 0, UpdatedParticipants, UpdatedParticipants.length - 1, 1);
            ma.setParticipants(UpdatedParticipants);
            System.out.println(ma.participants.length);
        }
    }


    // subscription to a course(same procedure ad 'SubmitMach')
    /**
     * This method adds a new participant to the courses's list.
     *
     * @param c the course in which the participant wants to register.
     *
     * @return void
     */
    public void SubmitCourse(Course c) {
        Person[] UpdatedParticipants = new Person[c.getParticipants().length + 1];
        Person[] i = {this};
        if (c.getParticipants().length == 0) {
            System.arraycopy(i, 0, UpdatedParticipants, 0, 1);
            c.setParticipants(UpdatedParticipants);
        } else {
            for (int d = 0; d < c.getParticipants().length; d++) {
                System.arraycopy(c.getParticipants(), d, UpdatedParticipants, d, 1);
            }
            System.arraycopy(i, 0, UpdatedParticipants, UpdatedParticipants.length - 1, 1);
            c.setParticipants(UpdatedParticipants);
        }
    }

    // unsubscription to a match
    /**
     * This method delete a participant to the matches's list.
     *
     * @param ma the match in which the participant wants to unregister.
     *
     * @return void
     */
    public void DeleteSubmitMatch(Match ma) {
        // new variable that contains the old participants
        Person[] removed = ma.getParticipants();
        // array that will contain the new participants
        Person[] UpdatedParticipants = new Person[removed.length - 1];
        // check if the participant that wnat to unsubscribe is deleted
        boolean BoxSwitch = false; // falso di default
        for (int i = 0; i < removed.length; i++) // analize each participant from the old members list
        {
            if (removed[i].getId() != this.getId()) // if the paricipant's ID is the same as the person who gave the command
            {
                if (BoxSwitch == false) // if false copy the members from the old members list into the new members list
                {
                    System.arraycopy(removed, i, UpdatedParticipants, i, 1);
                } else // if true i copy this participant into the new array but of a box to the left
                {
                    System.arraycopy(removed, i, UpdatedParticipants, i - 1, 1);
                }
            } else // if the paricipant's ID is the same as the person who gave the command the bool becomes true
            {
                BoxSwitch = true;
            }
        }
        ma.setParticipants(UpdatedParticipants);
    }

    // unsubsciption from a course(same procedure as 'DeleteSubmitMatch')
    /**
     * This method delete a participant to the courses's list.
     *
     * @param c the course in which the participant wants to register.
     *
     * @return void
     */
    public void DeleteSubmitCourse(Course c) {
        Person[] removed = c.getParticipants();
        Person[] UpdatedParticipants = new Person[removed.length - 1];
        boolean BoxSwitch = false;
        for (int i = 0; i < removed.length; i++) {
            if (removed[i].getId() != this.getId()) {
                if (BoxSwitch == false) {
                    System.arraycopy(removed, i, UpdatedParticipants, i, 1);
                } else {
                    System.arraycopy(removed, i, UpdatedParticipants, i - 1, 1);
                }
            } else {
                BoxSwitch = true;
            }
        }
        c.setParticipants(UpdatedParticipants);
    }
}
