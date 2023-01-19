package com.myreflectionthoughts.webfluxdemo.Examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class OperatorFlatMapTest {
    
    private OperatorFlatMap operatorFlatMap;

    OperatorFlatMapTest(){
        operatorFlatMap = new OperatorFlatMap();
    }

    @Test
    void testTransformUsingOperatorFlatMap(){

        Flux<String> carNames = operatorFlatMap.transformUsingOperatorFlatMap();

        StepVerifier.create(carNames).expectNext("SUPRA","SWIFT","KIGER").verifyComplete();

    }
}
