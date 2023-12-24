package com.asorg.votingsystem.repository;

import com.asorg.votingsystem.entity.Candidate;
import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.entity.PartyDetail;
import com.asorg.votingsystem.enums.StateEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    List<Candidate> findByElectionDetail(ElectionDetail electionDetail);

    //@Query(value = "select e from Candidate e where e.electionDetail.state =:state")
    List<Candidate> findByElectionDetail_State(StateEnum state);

    Candidate findByElectionDetailAndPartyDetail(ElectionDetail electionDetail, PartyDetail partyDetail);
}
