package com.asorg.votingsystem.entity;

import com.asorg.votingsystem.enums.ElectionTypeEnum;

import javax.persistence.*;

@Entity
public class ElectionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private ElectionTypeEnum electionType;
    private String state;
    private Boolean votingStatus;

    public ElectionDetail() {
    }

    public ElectionDetail(Integer id, ElectionTypeEnum electionType, String state, Boolean votingStatus) {
        this.id = id;
        this.electionType = electionType;
        this.state = state;
        this.votingStatus = votingStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ElectionTypeEnum getElectionType() {
        return electionType;
    }

    public void setElectionType(ElectionTypeEnum electionType) {
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
