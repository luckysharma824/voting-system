package com.asorg.votingsystem.repository;

import com.asorg.votingsystem.entity.ElectionDetail;
import com.asorg.votingsystem.enums.ElectionTypeEnum;
import com.asorg.votingsystem.enums.StateEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectionDetailRepository extends JpaRepository<ElectionDetail,Integer> {
    List<ElectionDetail> findByState(StateEnum state);
    boolean existsByElectionTypeAndState(ElectionTypeEnum electionType, StateEnum state);

    ElectionDetail findByElectionTypeAndState(ElectionTypeEnum electionType, StateEnum state);
}
