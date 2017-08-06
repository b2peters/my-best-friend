package org.launchcode.mybestfriend;

import org.launchcode.mybestfriend.models.upload.StorageProperties;
import org.launchcode.mybestfriend.models.upload.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(StorageProperties.class)

@SpringBootApplication

public class MyBestFriendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBestFriendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService){
		return(args) ->{
//			storageService.deleteAll();
			storageService.init();

		};
	}
}
