package com.zero.kabelo.services.DefaultImplementation;

import com.zero.kabelo.artifacts.User;
import com.zero.kabelo.repository.UserRepository;
import com.zero.kabelo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kilobytes on 2016/09/01.
 */
@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User find(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    @Override
    public List<User> findByFirstName(String name) {

        return userRepository.findByFirstName(name);
    }

    @Override
    public List<User> findByCell(String cell){
        return  userRepository.findByCell(cell);
    }
    @Override
    public User findByEmailAndPassword(String username,String password){
        return userRepository.findByEmailAndPassword(username,password);
    }
}
