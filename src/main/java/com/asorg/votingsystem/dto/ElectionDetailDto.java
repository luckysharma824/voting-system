package com.asorg.votingsystem.dto;

import com.asorg.votingsystem.enums.ElectionTypeEnum;

public class ElectionDetailDto {
    private Integer id;
    private ElectionTypeEnum electionType;
    private String state;
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
