package com.zero.kabelo.controllers;


import com.zero.kabelo.Reponse.UserResponseError;
import com.zero.kabelo.Utilities.Utils;
import com.zero.kabelo.artifacts.Login;
import com.zero.kabelo.artifacts.Registration;
import com.zero.kabelo.artifacts.User;
import com.zero.kabelo.dto.UserDTO;
import com.zero.kabelo.dto.VerifyDTO;
import com.zero.kabelo.services.DefaultImplementation.DefaultUserService;
import com.zero.kabelo.services.LoginService;
import com.zero.kabelo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Kilobytes on 2016/09/01.
 */
@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/test")
    public ResponseEntity<Object> test(){
        //System.out.println(Utils.isOTPStillValid("tst"));


        return new ResponseEntity<Object>(userService.findAllUsers(), HttpStatus.OK);
    }


    @RequestMapping(value = "/all")
    public ResponseEntity<?> users(){

        //System.out.println(getRandomNumberFrom(0,9,6));

        return new ResponseEntity<Object>(userService.findAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/id/{id}" , method = RequestMethod.GET)
    public ResponseEntity<User> userById(@PathVariable Long id){

        return new ResponseEntity<User>(userService.find(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/email" , method = RequestMethod.POST)
    public ResponseEntity<?> userByEmail1(@RequestBody UserDTO userDTO){
        System.out.println("USER BY EMAIL : " +  userDTO.getEmail());
        User userSearched = userService.findByEmail(userDTO.getEmail());
        System.out.println(java.util.UUID.randomUUID());
        if (userSearched != null){
            return new ResponseEntity<>(userSearched, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new UserResponseError("Could not find "+userDTO.getEmail() ,"Enter Correct email"), HttpStatus.OK);
        }
        //return new ResponseEntity<UserDTO>(userService.findByEmail(mail), HttpStatus.OK);
    }

    @RequestMapping(value = "/email/{mail}/" , method = RequestMethod.GET)
    public ResponseEntity<Object> userByEmail(@PathVariable("mail") String mail){
        System.out.println("USER BY EMAIL : " +  mail);
        User userSearched = userService.findByEmail(mail);
        System.out.println(java.util.UUID.randomUUID());
        if (userSearched != null){
            return new ResponseEntity<>(userSearched, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(new UserResponseError("Could not find "+mail ,"Enter Correct email"), HttpStatus.OK);
        }
        //return new ResponseEntity<UserDTO>(userService.findByEmail(mail), HttpStatus.OK);
    }

    @RequestMapping(value = "/name/{name}" , method = RequestMethod.GET)
    public ResponseEntity<List<User>> userByName(@PathVariable("name") String name){
        System.out.println("USER BY NAME : " + name);
       // System.out.println(userService.findByFirstName(name).getLastName());
        //return userService.findByFirstName(name);
        return new ResponseEntity<>(userService.findByFirstName(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/cell/{num}" , method = RequestMethod.GET)
    public ResponseEntity<List<User>> userByCell(@PathVariable("num") String name){
        System.out.println("USER BY NAME : " + name);
        // System.out.println(userService.findByFirstName(name).getLastName());
        //return userService.findByFirstName(name);
        return new ResponseEntity<>(userService.findByCell(name), HttpStatus.OK);
    }


    //LOGIN CONTROLLER POST
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO){
        System.out.println("USER LOGIN : " +  userDTO.getEmail() + ": " + userDTO.getPassword());

        User user = userService.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword());

        if (user != null){

            //Checking if user is Active meaning Verified
            if (user.getActive()){
                Login session = new Login(user);
                loginService.save(session);
                return new ResponseEntity<>(session, HttpStatus.OK);
            }
            else{
                //NOT ACTIVE
                return new ResponseEntity<>(new UserResponseError("User account not Active. Requires verification","Verification required"), HttpStatus.OK);

            }


        }
        else {
            return new ResponseEntity<>(new UserResponseError("Authentication Error" ,"Enter Correct email"), HttpStatus.OK);
        }

    }


    @RequestMapping(value = "/register" , method = RequestMethod.POST)
    public ResponseEntity<?> Register(@RequestBody UserDTO userDTO){

        System.out.println("USER REGISTRATION : " +  userDTO.getEmail() + ": " + userDTO.getPassword());

        // first Check if user with the supplied email does not exist.
        User existingUser = userService.findByEmail(userDTO.getEmail());

        if (existingUser == null){
            //User does not exist. Allow program to create new use
            User newUser =  new User(userDTO.getFirstName(),userDTO.getLastName(),userDTO.getEmail(),userDTO.getCell(),userDTO.getProvince(),userDTO.getPassword());
            Registration registration = new Registration();
            newUser.setRegistration(registration);
            userService.save(newUser);

            return new ResponseEntity<>(newUser, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new UserResponseError("The provided email address("+ userDTO.getEmail() +") is already registered.","If you forgot password please retrive password"), HttpStatus.OK);

        }


    }


    @RequestMapping(value = "/verify" , method = RequestMethod.POST)
    public ResponseEntity<?> verify(@RequestBody VerifyDTO verifyDTO){

        System.out.println("USER Verification : " +  verifyDTO.getOTP() + ": " + verifyDTO.getRegID());

        // first Check if user with the registration ID exist
        User existingUser = userService.find(verifyDTO.getRegID());

        if (existingUser != null){
            //Check if Pin is the same
            if (existingUser.getRegistration().getOTP().equals(verifyDTO.getOTP())){
                //CORRECT PIN

                //STIL NEED TO CHECK TIME ELAPSED

                if (Utils.isOTPStillValid(existingUser.getRegistration().getDate())){
                    System.out.print("PIN STILL VALID");
                    existingUser.getRegistration().setVerificationStatus("Verified");
                    existingUser.setActive(true);
                    userService.save(existingUser);
                    return new ResponseEntity<>(existingUser, HttpStatus.OK);
                }
                else{
                    //NO Longer valid
                    System.out.println("PIN NO LONGER VALID");
                    //Maybe later try to resend automatically
                    return new ResponseEntity<>(new UserResponseError("PIN EXPIRED","RESEND PIN"), HttpStatus.OK);
                }

            }else{
                //NOT THE SAME PIN

                return new ResponseEntity<Object>(new UserResponseError("Incorrect PIN","enter received PIN"),HttpStatus.OK);
            }


        }
        else{
            return new ResponseEntity<>(new UserResponseError("Could not find your registration","Please try registering or sending another pin"), HttpStatus.OK);

        }


    }

    @RequestMapping(value = "/update/{sid}/" , method = RequestMethod.POST)
    public ResponseEntity<?> Update(@PathVariable("sid") String sid,@RequestBody UserDTO userDTO){

        System.out.println("USER Update : " +  userDTO.getEmail() + ": " + userDTO.getPassword());

        // first Check if user with the supplied email does exist.

        Login userBySession = loginService.findBySessionId(sid);
        if (userBySession.getUser() != null){

            User existingUser = userBySession.getUser();
            //Updating with values from DTO object
            existingUser = Utils.updateFromDTO(existingUser,userDTO);
            userService.save(existingUser);

        }
        return new ResponseEntity<Object>(userBySession,HttpStatus.OK);

    }


}
