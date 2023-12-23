package com.asorg.votingsystem.repository;

import com.asorg.votingsystem.entity.PartyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyDetailRepository extends JpaRepository<PartyDetail,Integer> {
    boolean existsByNameAndSymbol(String name, String symbol);
}
