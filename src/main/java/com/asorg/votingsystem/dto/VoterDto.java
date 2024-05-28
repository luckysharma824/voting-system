package com.asorg.votingsystem.dto;

import com.asorg.votingsystem.entity.BoothDetail;
import com.asorg.votingsystem.entity.Contact;
import com.asorg.votingsystem.enums.StatusEnum;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

public class VoterDto {
    private Integer id;
    private String voterId;
    private String name;
    private BoothDetailDto booth;
    private StatusEnum status;
    private Contact contact;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BoothDetailDto getBooth() {
        return booth;
    }

    public void setBooth(BoothDetailDto booth) {
        this.booth = booth;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
