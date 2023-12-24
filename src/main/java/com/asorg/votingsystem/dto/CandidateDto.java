package com.asorg.votingsystem.dto;

import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.entity.PartyDetail;


public class CandidateDto {
    private Integer id;
    private String  name;
    private Long totalVotes;
    private PartyDetail partyDetail;
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

    public Long getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Long totalVotes) {
        this.totalVotes = totalVotes;
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
