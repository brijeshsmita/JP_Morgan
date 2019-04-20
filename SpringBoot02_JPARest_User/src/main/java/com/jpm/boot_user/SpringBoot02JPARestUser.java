package com.jpm.boot_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jpm.boot_user.controller.UserController;

@SpringBootApplication
@ComponentScan(basePackages="com.jpm.boot_user")
public class SpringBoot02JPARestUser {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot02JPARestUser.class,
				args);
		}
}
