package com.zero.kabelo.services;

import com.zero.kabelo.artifacts.Login;
import com.zero.kabelo.artifacts.User;
import org.springframework.stereotype.Service;

/**
 * Created by Kilobytes on 2016/09/07.
 */
@Service
public interface LoginService {

    Login save(Login login);

    Login findBySessionId(String sessionId);
}
