package com.asorg.votingsystem.repository;

import com.asorg.votingsystem.entity.BoothDetail;
import com.asorg.votingsystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoothDetailRepository extends JpaRepository<BoothDetail,Integer> {
}
