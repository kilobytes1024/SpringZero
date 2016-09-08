package com.zero.kabelo.services;

import com.zero.kabelo.artifacts.Registration;
import com.zero.kabelo.artifacts.User;

import java.util.List;

/**
 * Created by Kilobytes on 2016/09/02.
 */
public interface RegistrationService {

    List<Registration> findAllRegistrations();

    Registration save(Registration registration);

    Registration find(Long id);

    List<Registration> findByVerificationStatus(String verificationStatus);


}
