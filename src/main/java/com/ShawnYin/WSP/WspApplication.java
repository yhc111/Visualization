package com.ShawnYin.WSP;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ShawnYin.WSP.mapper")
@EnableScheduling
public class WspApplication {

	public static void main(String[] args) {
		SpringApplication.run(WspApplication.class, args);
	}

}
