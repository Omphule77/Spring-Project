package com.aopdemo.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao {

	@Override
	public void addSillyMember() {
		System.out.println("I am Under Membership Dao");
	}

}
