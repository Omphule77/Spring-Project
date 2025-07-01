package com.reactive.reactivedemo;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.reactive.reactivedemo.domain.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepoImpTest {

	PersonRepositoryImpl personRepo;
	
	@BeforeEach
	void set() {
		personRepo=new PersonRepositoryImpl();
	}
	
	@Test
	void getById() {
		Mono<Person> personMono=personRepo.getById(1);
		
		Person p=personMono.block();
		System.out.println(p.toString());
	}
	
	@Test
	void getByIdUsingSubsriber() {
		Mono<Person> personMono=personRepo.getById(1);
		
		personMono.subscribe(person->{
			System.out.println(person.toString());
		});
	}
	
	@Test
	void getByIdMapFunction() {
		Mono<Person> perMono=personRepo.getById(1);
		
		perMono.map(person->{
			System.out.println(person.toString());
			return person.getFirstName();
		}).subscribe(name->{
			System.out.println("From Map: "+name);
		});
	}
	
	@Test
	void getFluxFirstBlock() {
		Flux<Person> personflux=personRepo.findAll();
		
		System.out.println(personflux.blockLast());
	}
	
//	@Test
//	void getFluxUsingSubscriber() {
//		Flux<Person> perFlux=personRepo.findAll();
//		
//		perFlux.subscribe(person->{
//			System.out.println(person.toString());
//		});
//	}
	
	@Test
	void getFluxToMono() {
		Flux<Person> perFlux=personRepo.findAll();
		Mono<List<Person>> mp=perFlux.collectList();
		
		mp.subscribe(list->{
			list.forEach(person->{
				System.out.println(person.toString());
			});
		});
	}
}
