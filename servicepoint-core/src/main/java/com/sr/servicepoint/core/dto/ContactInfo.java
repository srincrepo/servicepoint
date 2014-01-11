package com.sr.servicepoint.core.dto;

import org.dozer.Mapping;

public class ContactInfo {

    private String contactType;

    @Mapping("detail")
    private String contactDetail;

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(String contactDetail) {
        this.contactDetail = contactDetail;
    }

}
