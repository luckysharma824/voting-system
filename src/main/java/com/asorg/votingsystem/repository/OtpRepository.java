package com.asorg.votingsystem.repository;

import com.asorg.votingsystem.entity.OneTimePassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<OneTimePassword, Integer> {

    OneTimePassword findByUserId(Integer userId);
    OneTimePassword findByOtpAndUserId(String otp,Integer userId);
}
