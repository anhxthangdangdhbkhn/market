package com.market;

import com.market.domain.Role;
import com.market.domain.User;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class MarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	CommandLineRunner runner(UserService userService){
//		return  args -> {
//			userService.saveRole(new Role(null,"ROLE_USER"));
//			userService.saveRole(new Role(null,"ROLE_MANAGER"));
//			userService.saveRole(new Role(null,"ROLE_ADMIN"));
//			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
//
//			userService.saveUser(new User(null,"anhxthangdang","thang","26071993",new ArrayList<>()));
//			userService.saveUser(new User(null,"dangtuananh","anh","26071993",new ArrayList<>()));
//			userService.saveUser(new User(null,"dangthikhuyen","khuyen","26071993",new ArrayList<>()));
//
//			userService.addRoleToUser("thang","ROLE_SUPER_ADMIN");
//			userService.addRoleToUser("anh","ROLE_MANAGER");
//			userService.addRoleToUser("khuyen","ROLE_USER");
//		};
//	}
}
