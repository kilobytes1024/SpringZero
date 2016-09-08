package com.zero.kabelo.dto;

import com.zero.kabelo.artifacts.Registration;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Kilobytes on 2016/09/01.
 */
public class UserDTO implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String cell;
    private String province;

    private String password;
    private Boolean active;




    //

    public UserDTO() {
        //this.registration = new Registration(this.userId);
    }

    public UserDTO(String email) {
        this.email = email;
    }

    public UserDTO(String firstName, String lastName, String email, String cell, String province) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cell = cell;
        this.province = province;

        //this.registration = new Registration(userId);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    }
