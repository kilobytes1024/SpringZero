package com.zero.kabelo.controllers;

import com.zero.kabelo.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kilobytes on 2016/09/02.
 */
@RestController
@RequestMapping(value = "/Registration")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "/all")
    public ResponseEntity<Object> registrations(){

        return new ResponseEntity<Object>(registrationService.findAllRegistrations(), HttpStatus.OK);
    }

}
