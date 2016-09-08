package com.zero.kabelo.services.DefaultImplementation;

import com.zero.kabelo.artifacts.Login;
import com.zero.kabelo.artifacts.User;
import com.zero.kabelo.repository.LoginRepository;
import com.zero.kabelo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kilobytes on 2016/09/07.
 */
@Service
public class DefaultLoginService implements LoginService{
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login save(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public Login findBySessionId(String sessionId) {
        return loginRepository.findBySession(sessionId);
    }

    public List<Login> findAll() {
        return loginRepository.findAll();
    }




}
