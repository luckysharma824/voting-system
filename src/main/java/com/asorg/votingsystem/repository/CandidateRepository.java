package com.asorg.votingsystem.repository;

import com.asorg.votingsystem.entity.Candidate;
import com.asorg.votingsystem.entity.ElectionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    List<Candidate> findByElectionDetail(ElectionDetail electionDetail);
}
