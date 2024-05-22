

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Person is in charge of saving a person object with its properties.
 * Each person has a name, a surname, an email and a password(and an ID)
 */
public class Person {

    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String name;
    private String surname;
    private String email;
    private transient String password;

    /**
     * This constructor generates a Person object.
     *
     * @param n        the person name
     * @param s        the person surname
     * @param e        the person email
     * @param p        the person password
     *
     * @return void
     */
    public Person(final String n, final String s, final String e, final String p) {
        //Principal class of 'Member' and 'Admin
        super();
        this.name = n;
        this.surname = s;
        this.email = e;
        this.password = p;
        this.id = count.incrementAndGet();
    }

    //Get/Set
    /**
     * This method gets the Person's name.
     *
     * @return String the Person's name
     */
    public String getName() {
        return name;
    }
    /**
     * This method sets the Person's name.
     *
     * @param name for the Person.
     *
     * @return void
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * This method gets the Person's surname.
     *
     * @return String the Person's surname
     */
    public String getSurname() {
        return surname;
    }
    /**
     * This method sets the Person's surname.
     *
     * @param surname for the Person.
     *
     * @return void
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * This method gets the Person's email.
     *
     * @return String the Person's email
     */
    public String getEmail() {
        return email;
    }
    /**
     * This method sets the Person's email.
     *
     * @param email for the Person.
     *
     * @return void
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * This method sets the Person's password.
     *
     * @param password for the Person.
     *
     * @return void
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * This method gets the Person's ID.
     *
     * @return int the Person's ID
     */
    public int getId()
    {
        return id;
    }
}
