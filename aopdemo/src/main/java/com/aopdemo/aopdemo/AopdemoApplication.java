package com.aopdemo.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.aopdemo.aopdemo.dao.AccountDao;
import com.aopdemo.aopdemo.dao.MembershipDao;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner clr(AccountDao accountDao,MembershipDao m) {
		return runner->{
			demoBeforeAdvice(accountDao,m);
		};
	}

	private void demoBeforeAdvice(AccountDao accountDao,MembershipDao m) {
		accountDao.addAccount();
		m.addSillyMember();
	}

}
