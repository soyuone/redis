package com.song.redis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.song.redis.beans.UserBean;
import com.song.redis.service.UserService;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-redis.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");

		UserBean user1 = new UserBean("2016", "漩涡鸣人");
		UserBean user2 = new UserBean("2017", "雏田");

		System.out.println("==== getting objects from redis ====");
		System.out.println("User is not in redis yet: " + userService.get(user1));
		System.out.println("User is not in redis yet: " + userService.get(user2));

		System.out.println("==== putting objects into redis ====");
		userService.put(user1);
		userService.put(user2);

		System.out.println("==== getting objects from redis ====");
		System.out.println("User should be in redis yet: " + userService.get(user1));
		System.out.println("User should be in redis yet: " + userService.get(user2));

		System.out.println("==== deleting objects from redis ====");
		userService.delete(user1);
		userService.delete(user2);

		System.out.println("==== getting objects from redis ====");
		System.out.println("User is not in redis yet: " + userService.get(user1));
		System.out.println("User is not in redis yet: " + userService.get(user2));
	}

}
