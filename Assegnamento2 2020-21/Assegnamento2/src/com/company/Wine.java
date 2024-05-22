package com.company;

/**
 * Wine describes a single type of wine.
 */
public class Wine {

    private String name;
    private String notes;
    private String vineyard;

    /**
     * This constructor generates an empty Wine object
     */
    public Wine() {
        this.name = "";
        this.notes = "";
        this.vineyard = "";
    }

    /**
     * This constructor generates a Wine object by its properties
     *
     * @param name
     * @param notes
     * @param vineyard
     */
    public Wine(final String name, final String notes, final String vineyard) {
        this.name = name;
        this.notes = notes;
        this.vineyard = vineyard;
    }

    /**
     * This method gets the wine name
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method sets the wine name
     *
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * This method gets the wine's notes
     *
     * @return the notes
     */
    public String getNotes() {
        return this.notes;
    }

    /**
     * This method sets the wine notes
     *
     * @param notes
     */
    public void setNotes(final String notes) {
        this.notes = notes;
    }

    /**
     * This method gets the wine's vine
     *
     * @return the vine
     */
    public String getVineyard() {
        return this.vineyard;
    }

    /**
     * This method sets the wine's vine
     *
     * @param vine
     */
    public void setVineyard(final String vine) {
        this.vineyard = vineyard;
    }

    /**
     * This method checks if two wines are equal
     */

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Wine)) {
            return false;
        }
        Wine wine = (Wine) o;
        return (name.equals(wine.name)) && (notes.equals(wine.notes)) && (vineyard.equals(wine.vineyard));
    }

    /**
     * This method generates a string describing the wine
     */
    public String toString() {
        return "Wine name='" + getName() + "'\n" + "Notes='" + getNotes() + "'\n" + "Vineyard='" + getVineyard() + "'\n";
    }
}