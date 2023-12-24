package com.asorg.votingsystem.dto;

import com.asorg.votingsystem.enums.ElectionTypeEnum;
import com.asorg.votingsystem.enums.StateEnum;

public class ElectionDetailDto {
    private Integer id;
    private ElectionTypeEnum electionType;
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
