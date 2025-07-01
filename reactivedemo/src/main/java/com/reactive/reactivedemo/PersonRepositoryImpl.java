package com.reactive.reactivedemo;

import com.reactive.reactivedemo.domain.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepositoryImpl implements PersonRepository {

	Person om=new Person(1,"Om","Phule");
	Person sarthak=new Person(1,"sarthak","nande");
	Person pranav=new Person(1,"pranav","adsule");
	Person prafful=new Person(1,"prafful","babar");
	
	@Override
	public Mono<Person> getById(Integer id) {
		// TODO Auto-generated method stub
		return Mono.just(om);
	}

	@Override
	public Flux<Person> findAll() {
		// TODO Auto-generated method stub
		return Flux.just(sarthak,pranav,prafful);
	}

}
