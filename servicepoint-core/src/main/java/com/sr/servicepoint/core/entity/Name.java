package com.sr.servicepoint.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "MIDDLEINITIAL")
    private String middleInitial;

    @Column(name = "LASTNAME")
    private String lastName;

    public Name() {
    }

    public Name(String firstName, String middleInitial, String lastName) {
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
