package com.guddqs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wq
 */
@SpringBootApplication
@MapperScan("com.guddqs.mapper.**")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
/*
CREATE TABLE `de_user` (
  `userId` varchar(36) NOT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `userAge` int(11) DEFAULT NULL,
  `userGender` int(11) DEFAULT NULL,
  `userPhone` varchar(20) DEFAULT NULL,
  `userBirthday` varchar(19) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
 */