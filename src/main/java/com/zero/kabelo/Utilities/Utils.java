package com.zero.kabelo.Utilities;

import com.zero.kabelo.artifacts.User;
import com.zero.kabelo.dto.UserDTO;

import java.text.SimpleDateFormat;
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
        //TEsting values
        String start =    "01/15/2012 10:31:48";
        String dateStop = "01/15/2012 10:33:48";

        //HH converts hour in 24 hours format (0-23), day calculation
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        Date d1 = null;
        Date d2 = null;

        try {
            //Test Objects

            d1 = format.parse(generatedTime);
            d2 = format.parse(format.format(new Date()));


            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds.");

            //NOT A PROPER SOLUTION THOUGH NB LATER CHECK ANOTHER SOLUTION
            if (diffDays == 0 && diffHours == 0 && diffMinutes < 2 ){
                valid = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }




      return valid;
    }



    //This Method will be used to send email to user extracting emails and OTP from the user object
    public static void emailUserOTP(User user){

    }
}
