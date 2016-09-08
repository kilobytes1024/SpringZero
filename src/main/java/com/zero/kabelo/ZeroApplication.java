package com.zero.kabelo;

import com.zero.kabelo.artifacts.Registration;
import com.zero.kabelo.artifacts.User;
import com.zero.kabelo.repository.RegistrationRepository;
import com.zero.kabelo.repository.UserRepository;
import com.zero.kabelo.services.RegistrationService;
import com.zero.kabelo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ZeroApplication {

	@Autowired
	private UserService userService;
	@Autowired
	private RegistrationService registrationService ;

	public static void main(String[] args) {
		SpringApplication.run(ZeroApplication.class, args);
	}

	@PostConstruct
	public void createRecords(){

//		User user = new User();
//		user.setFirstName("Kabelo");
//		user.setLastName("Thobejane");
//		user.setCell("0737994125");
//		user.setEmail("kabelo@gmail.com");
//		user.setProvince("Gauteng");
//		user.setActive(false);
//		user.setPassword("12345");
//		System.out.println(user.getUserId());
//
//
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%%");
//		System.out.println(user.getUserId());
//
//		Registration registration = new Registration();
//
//		user.setRegistration(registration);
//		userService.save(user);


	}

}
