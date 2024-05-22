package com.company;

/**
 * Activity is in charge of saving an activity object with its properties.
 * Every activity has a name and an array of person registered for the activity.
 */
public class Activity {

    private String name;
    public Person[] participants;
    public Activity(final String n, Person[] pa) {
        //Principal class of 'Match' and 'Course'
        super();
        this.name = n;
        this.participants = pa;
    }
    /**
     * This method gets the Activity name.
     *
     * @return String the Activity name
     */
    public String getName() {
        return name;
    }
    /**
     * This method sets the Activity name.
     *
     * @param name the activity name
     *
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method gets the Activity participants.
     *
     * @return Person list of registered person
     */
    public Person[] getParticipants() {
        return participants;
    }

    /**
     * This method sets the Activity participants.
     *
     * @param participants list of of participants
     *
     * @return void
     */
    public void setParticipants(Person[] participants) {
        this.participants = participants;
    }
}
