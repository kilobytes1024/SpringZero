package com.zero.kabelo.Utilities;

import com.zero.kabelo.artifacts.User;
import com.zero.kabelo.dto.UserDTO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by Kilobytes on 2016/09/07.
 */
public class Utils {

    //Method used to update User using DTO
    public static User updateFromDTO(User user, UserDTO updater){

        user.setFirstName(updater.getFirstName());
        user.setLastName(updater.getLastName());
        user.setPassword(updater.getPassword());
        user.setCell(updater.getCell());
        user.setProvince(updater.getProvince());

        return user;
    }

    public static Integer getRandomNumberFrom(int min, int max, int length) {
        Random foo = new Random();

        String OTP = "";

        for (int i=0; i<length; i++){
            int randomNumber = foo.nextInt((max + 1) - min) + min;
            OTP += randomNumber;
        }


        return Integer.parseInt(OTP);

    }

    public static Boolean isOTPStillValid(String generatedTime){

        Boolean valid = false;
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        try {
            Date createdDate = format.parse(generatedTime);

            Calendar cal = Calendar.getInstance();
            cal.setTime(createdDate);
            cal.add(Calendar.MINUTE, 2);//Adding 2 Minutes to generated Time to get its expiry Date Time

            Date expirydate = format.parse(format.format(cal.getTime()));


            Date currentDate = new Date();
            System.out.println("OTP CREATE DATE : " + createdDate);
            System.out.println("OTP EXPIRY DATE : " + expirydate);
            System.out.println("CURRENT DATE : "+ currentDate);

            System.out.println("RESULTS------");
            System.out.println("VALID : " + currentDate.before(expirydate));
            if (currentDate.before(expirydate)){
                valid = true;
            }



        }
        catch (Exception e){

        }


      return valid;
    }



    //This Method will be used to send email to user extracting emails and OTP from the user object
    public static void emailUserOTP(User user){

    }
}
