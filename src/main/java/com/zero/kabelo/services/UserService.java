package com.zero.kabelo.services;

import com.zero.kabelo.artifacts.User;

import java.util.List;

/**
 * Created by Kilobytes on 2016/09/01.
 */
public interface UserService {

    List<User> findAllUsers();

    User save(User user);

    User find(Long id);

    User findByEmail(String email);

    List<User> findByFirstName(String name);

    List<User> findByCell(String cell);

    User findByEmailAndPassword(String username,String password);
}
