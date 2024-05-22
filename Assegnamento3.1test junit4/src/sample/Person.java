package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Person describes a generic user. It is the parent class of User and Seller.
 */

public class Person {

    private StringProperty username;
    private StringProperty password;

    /**
     * This constructor generates an empty person
     */
    public Person() {
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
    }

    /**
     * This constructor generates a person from its username and password.
     *
     * @param username
     * @param password
     */
    public Person(String username, String password) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    /**
     * This method returns the user's username.
     *
     * @return the username
     */
    public StringProperty usernameProperty() {
        return this.username;
    }

    public String getUsername() {
        return this.username.get();
    }

    /**
     * This method sets the user's username.
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username.set(username);
    }

    /**
     * This method gets the user's password.
     *
     * @return the password.
     */
    public String getPassword() {
        return this.password.get();
    }

    public StringProperty passwordProperty() {
        return this.password;
    }

    /**
     * This method sets the user's password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password.set(password);
    }

    /**
     * This method generates a hashcode for the object.
     *
     * @return the hashcodes
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    /**
     * This method checks if two Person objects are equal
     *
     * @return whether the objects are equal
     */
    @Override
    public boolean equals(Object o) {

        if (o instanceof Person)
        {
            Person p = (Person)o;
            return getUsername().equals(p.getUsername()) &&
                    getPassword().equals(p.getPassword());
        }
        return false;
    }

    /**
     * This method generates a string that describes the object.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "username=\"" + getUsername() + "\", " +
                "password=\"" + getPassword() + "\"";
    }

}
