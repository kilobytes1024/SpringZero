package com.zero.kabelo.controllers;

import com.zero.kabelo.artifacts.Login;
import com.zero.kabelo.artifacts.User;
import com.zero.kabelo.services.LoginService;
import com.zero.kabelo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

/**
 * Created by Kilobytes on 2016/09/07.
 */
@RestController
@RequestMapping(value = "/session")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}/")
    public ResponseEntity<?> findSession(@PathVariable("id") String sid) {

        System.out.println("USER BY SESSION: " +sid );
        Login userSession = loginService.findBySessionId(sid);

        System.out.println(userSession);
        //Check if the user sid has Session
        if (userSession != null) {
            //Now get the userObject Linked to this session

            return new ResponseEntity<Object>(userSession.getUser(), OK);
        }else{
            return new ResponseEntity<Object>("implement", OK);
        }


    }
}
