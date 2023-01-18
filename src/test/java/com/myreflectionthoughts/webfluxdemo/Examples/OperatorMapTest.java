package com.myreflectionthoughts.webfluxdemo.Examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class OperatorMapTest {
     
    private OperatorMap operatorMap;

    public OperatorMapTest() {
      
       operatorMap = new OperatorMap();
    }

    @Test
    void testTransformedCarflux(){
        
          Flux<String> upperCaseCarNames = operatorMap.transformedCarFlux();

          // after asserting the first element to be SUPRA, checking the length of the remaining list   

          StepVerifier.create(upperCaseCarNames).expectNext("SUPRA")
          .expectNextCount(2)
          .verifyComplete();
        
    }
    
}
