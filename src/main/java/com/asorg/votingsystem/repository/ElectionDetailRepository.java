package com.asorg.votingsystem.repository;

import com.asorg.votingsystem.entity.ElectionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectionDetailRepository extends JpaRepository<ElectionDetail,Integer> {
}
