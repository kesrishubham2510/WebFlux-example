package com.myreflectionthoughts.webfluxdemo.Examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class OperatorFilterTest {
    
    private OperatorFilter operatorFilter;

    public OperatorFilterTest() {
        operatorFilter = new OperatorFilter();
    }

    @Test 
    void testGiveMeNegativeNumbers(){
        
        Flux<Integer> negativeNumbers = operatorFilter.giveMeNegativeNumbers();
        
        StepVerifier.create(negativeNumbers).expectNext(-6,-1).verifyComplete();
    }
    
}
