package com.zero.kabelo.Reponse;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Kilobytes on 2016/09/02.
 */
public class UserResponseError implements Serializable {

    private String fault;
    private String resolution;
    private String date;

    public UserResponseError(){
        this.date = new Date().toString();
    }

    public UserResponseError(String fault, String resolution) {
        this.fault = fault;
        this.resolution = resolution;
        this.date = new Date().toString();
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
