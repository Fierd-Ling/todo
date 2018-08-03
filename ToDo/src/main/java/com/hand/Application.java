package com.hand;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



// 我也玩一玩
/**
 * 
 * 程序启动入口
 * 
 * @author zhongLingYun
 * 
 */
@SpringBootApplication
@MapperScan("com.hand.mapper")
public class Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("启动完毕");
	}
}