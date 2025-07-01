package com.aopdemo.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Override
	public void addAccount() {
		System.out.println(getClass()+" : I am Under The ACcount Dao");
	}

}
