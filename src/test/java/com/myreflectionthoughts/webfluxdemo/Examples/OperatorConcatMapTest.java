package com.myreflectionthoughts.webfluxdemo.Examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class OperatorConcatMapTest {
    
    private OperatorConcatMap operatorConcatMap;

    public OperatorConcatMapTest() {
        operatorConcatMap = new OperatorConcatMap();
    }

    @Test
    void testOperateUsingConcatMap(){

        Flux<String> uppercaseCarNames = operatorConcatMap.operateUsingConcatMap();

        StepVerifier.create(uppercaseCarNames).expectNext("S","u","p","r","a","S","w","i","f","t","K","i","g","e","r").verifyComplete();

    }
    
    /*
     *  On running the test, it can be confirmed from the debug console, the output sequence is not preserved
        as it is preserved in the output of the previous test
     */
    @Test
    void testAsynchronousFlatMap(){
        
        Flux<String> uppercaseCarNames = operatorConcatMap.transformUsingOperatorFlatMap();
        StepVerifier.create(uppercaseCarNames).expectNextCount(15).verifyComplete();

    }
    
}
