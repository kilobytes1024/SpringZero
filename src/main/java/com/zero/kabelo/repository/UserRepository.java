package com.zero.kabelo.repository;

import com.zero.kabelo.artifacts.User;

import java.util.List;
/**
 * Created by Kilobytes on 2016/09/01.
 */
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    @Override
    List<User> findAll();

    User findByEmail(String email);

    List<User> findByFirstName(String firstName);

    List<User> findByCell(String cell);

    User findByEmailAndPassword(String username,String password);
}
