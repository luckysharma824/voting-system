package com.asorg.votingsystem.repository;

import com.asorg.votingsystem.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<Voter,Integer> {
    Voter findByVoterIdOrUsername(String voterId, String username);
}
