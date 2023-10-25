package com.asorg.votingsystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ElectionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String electionType;
    private String state;
    private Boolean votingStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElectionType() {
        return electionType;
    }

    public void setElectionType(String electionType) {
        this.electionType = electionType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getVotingStatus() {
        return votingStatus;
    }

    public void setVotingStatus(Boolean votingStatus) {
        this.votingStatus = votingStatus;
    }
}