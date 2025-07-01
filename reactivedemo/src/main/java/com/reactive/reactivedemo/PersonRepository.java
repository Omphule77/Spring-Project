package com.reactive.reactivedemo;

import com.reactive.reactivedemo.domain.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {

	Mono<Person> getById(Integer id);
	
	Flux<Person> findAll();
}
