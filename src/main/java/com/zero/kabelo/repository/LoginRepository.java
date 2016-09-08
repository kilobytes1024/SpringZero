package com.zero.kabelo.repository;

import com.zero.kabelo.artifacts.Login;
import com.zero.kabelo.artifacts.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Kilobytes on 2016/09/07.
 */
public interface LoginRepository extends JpaRepository<Login,Long> {

    @Override
    List<Login> findAll();

    Login findBySession(String session);
}
