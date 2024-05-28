package com.asorg.votingsystem.entity;

import com.asorg.votingsystem.enums.StatusEnum;

import javax.persistence.*;

@Entity
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String voterId;
    @OneToOne
    private BoothDetail booth;
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    public BoothDetail getBooth() {
        return booth;
    }

    public void setBooth(BoothDetail booth) {
        this.booth = booth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
