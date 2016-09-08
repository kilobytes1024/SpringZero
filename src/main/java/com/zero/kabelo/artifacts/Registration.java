package com.zero.kabelo.artifacts;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Kilobytes on 2016/09/01.
 */

@Entity
public class Registration implements Serializable {

    private static final String verification= "not_verified";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registrationID;
    private String verificationStatus;
    private String date;
    private double OTP;



    public Registration() {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        this.date = format.format(new Date());
        this.verificationStatus = Registration.verification;
        this.OTP = Math.floor(100000 + Math.random()* 900000);
    }

    public static String getVerification() {
        return verification;
    }

    public Long getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(Long registrationID) {
        this.registrationID = registrationID;
    }

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getOTP() {
        return OTP;
    }

    public void setOTP(Double OTP) {
        this.OTP = OTP;
    }
}
