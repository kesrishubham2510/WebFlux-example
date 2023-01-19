package com.myreflectionthoughts.webfluxdemo.Examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class OperatorFlatMapManyTest {

    private OperatorFlatMapMany operatorFlatMapMany;

    public OperatorFlatMapManyTest() {
        operatorFlatMapMany = new OperatorFlatMapMany();
    }

    @Test
    void testUsesFlatMapManyOperator(){
        String myInput = "Reactive";
        Flux<String> stringArray = operatorFlatMapMany.usesFlatMapManyOperator(myInput);

        StepVerifier.create(stringArray).expectNext("R","e","a","c","t","i","v","e").verifyComplete();
    }

}
