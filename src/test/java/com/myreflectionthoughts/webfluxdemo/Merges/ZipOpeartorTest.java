package com.myreflectionthoughts.webfluxdemo.Merges;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.myreflectionthoughts.webfluxdemo.Employee;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class ZipOpeartorTest {
    
    private ZipOperator zipOperator;

    ZipOpeartorTest(){
        zipOperator = new ZipOperator();
    }
    
    @Test
    void testCombinePublisher_to_generatePublisher(){

        Flux<Employee> employeeFlux = zipOperator.combinePublisher_to_genratePublisher();
        
        // employeeFlux.subscribe(System.out::println);
        StepVerifier.create(employeeFlux).consumeNextWith(emp->{
            assertEquals("Data", emp.getFirstName());
            assertEquals("Data Analyst-1", emp.getRole());
        }).expectNextCount(2)
        .verifyComplete();
    }
}
