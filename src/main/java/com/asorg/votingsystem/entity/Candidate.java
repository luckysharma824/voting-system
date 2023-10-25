package com.asorg.votingsystem.entity;

import javax.persistence.*;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String  name;
    @OneToOne
    private PartyDetail partyDetail;
    @OneToOne
    private ElectionDetail electionDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PartyDetail getPartyDetail() {
        return partyDetail;
    }

    public void setPartyDetail(PartyDetail partyDetail) {
        this.partyDetail = partyDetail;
    }

    public ElectionDetail getElectionDetail() {
        return electionDetail;
    }

    public void setElectionDetail(ElectionDetail electionDetail) {
        this.electionDetail = electionDetail;
    }
}