package com.zero.kabelo.services.DefaultImplementation;

import com.zero.kabelo.artifacts.Registration;
import com.zero.kabelo.repository.RegistrationRepository;
import com.zero.kabelo.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kilobytes on 2016/09/02.
 */
@Service
public class DefaultRegistrationService implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public List<Registration> findAllRegistrations() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration save(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Registration find(Long id) {
        return registrationRepository.findOne(id);
    }

    @Override
    public List<Registration> findByVerificationStatus(String verificationStatus) {
        return registrationRepository.findByVerificationStatus(verificationStatus);
    }
}
