package com.asorg.votingsystem.repository;

import com.asorg.votingsystem.entity.Candidate;
import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.entity.PartyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    List<Candidate> findByElectionDetail(ElectionDetail electionDetail);

    //@Query(value = "select e from Candidate e where e.electionDetail.state =:state")
    List<Candidate> findByElectionDetail_State(String state);

    Candidate findByElectionDetailAndPartyDetail(ElectionDetail electionDetail, PartyDetail partyDetail);

    boolean existsByPartyDetail(PartyDetail partyDetail);

    boolean existsByElectionDetail(ElectionDetail electionDetail);

}
