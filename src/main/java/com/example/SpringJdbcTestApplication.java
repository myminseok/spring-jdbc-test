package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringJdbcTestApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringJdbcTestApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTestApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public List<User> users(){
		return userService.users();
	}

	@RequestMapping(value="/{name}", method = RequestMethod.POST)
	public void add(@PathVariable String name){
		userService.add(name);
	}

	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public void delete(@PathVariable Integer id){
		userService.remove(id);
	}


//	@Bean
//	public CommandLineRunner load(UserRepository userRepository){
//		return (args) -> {
//			userRepository.save(new User("minseok"));
//			userRepository.save(new User("minseok2"));
//
//			for (User user:users()){
//				log.info(user.toString());
//			}
//		};
//	}
}
