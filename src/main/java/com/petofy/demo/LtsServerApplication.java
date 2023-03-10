package com.petofy.demo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.petofy.Services.FilesStorageService;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.petofy.Repository")
@EntityScan(basePackages = "com.petofy.Model")
@ComponentScan(basePackages = "com.petofy")
public class LtsServerApplication  implements CommandLineRunner{

	@Resource
	FilesStorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(LtsServerApplication.class, args);
	}
	
	@Override
	  public void run(String... arg) throws Exception {
//	    storageService.deleteAll();
	    storageService.init();
	  }

}
