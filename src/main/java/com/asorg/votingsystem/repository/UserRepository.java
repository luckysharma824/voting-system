package com.asorg.votingsystem.repository;

import com.asorg.votingsystem.entity.User;
import com.asorg.votingsystem.entity.Voter;
import com.asorg.votingsystem.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    StatusEnum findStatusById(Integer id);
    Voter findVoterByVoter_VoterId(String voterId);
    User findByVoterOrUsername(Voter voter, String username);
}
