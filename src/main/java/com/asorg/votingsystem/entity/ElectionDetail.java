package com.asorg.votingsystem.entity;

import com.asorg.votingsystem.enums.ElectionTypeEnum;
import com.asorg.votingsystem.enums.StateEnum;

import javax.persistence.*;

@Entity
public class ElectionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private ElectionTypeEnum electionType;
    @Enumerated
    private StateEnum state;
    private Boolean votingStatus;

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

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public Boolean getVotingStatus() {
        return votingStatus;
    }

    public void setVotingStatus(Boolean votingStatus) {
        this.votingStatus = votingStatus;
    }

}
