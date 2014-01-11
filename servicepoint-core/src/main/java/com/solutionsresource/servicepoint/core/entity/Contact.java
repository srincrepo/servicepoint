package com.solutionsresource.servicepoint.core.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Contact {

    @Column(name = "CONTACT_TYPE")
    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @Column(name = "DETAIL")
    private String detail;

    public Contact() {
    }

    public Contact(ContactType contactType, String detail) {
        this.contactType = contactType;
        this.detail = detail;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
