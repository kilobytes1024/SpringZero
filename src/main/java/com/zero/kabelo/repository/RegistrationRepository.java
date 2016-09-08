package com.zero.kabelo.repository;

import com.zero.kabelo.artifacts.Registration;
import com.zero.kabelo.artifacts.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Kilobytes on 2016/09/02.
 */
public interface RegistrationRepository extends JpaRepository<Registration,Long> {

    @Override
    List<Registration> findAll();

    List<Registration> findByVerificationStatus(String verificationStatus);


}
