package com.zero.kabelo.dto;

import java.io.Serializable;

/**
 * Created by Kilobytes on 2016/09/08.
 */
public class VerifyDTO implements Serializable {

    private Long regID;
    private double OTP;


    public VerifyDTO() {
    }

    public VerifyDTO(Long regID, double OTP) {
        this.regID = regID;
        this.OTP = OTP;
    }

    public Long getRegID() {
        return regID;
    }

    public void setRegID(Long regID) {
        this.regID = regID;
    }

    public double getOTP() {
        return OTP;
    }

    public void setOTP(double OTP) {
        this.OTP = OTP;
    }
}
