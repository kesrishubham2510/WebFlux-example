package com.myreflectionthoughts.webfluxdemo.Errors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.myreflectionthoughts.webfluxdemo.Exceptions.NoElementException;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class SwitchWhenEmptyTest {
    
     private SwitchWhenEmpty switchWhenEmpty;

    public SwitchWhenEmptyTest() {
        switchWhenEmpty = new SwitchWhenEmpty();
    }

    @Test
    void testHandleTheNameFlux(){
        Flux<String> nameFlux = switchWhenEmpty.handleTheNameflux();

        StepVerifier.create(nameFlux).expectError(NoElementException.class);
    }


     
}
