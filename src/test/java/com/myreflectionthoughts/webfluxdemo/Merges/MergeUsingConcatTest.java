package com.myreflectionthoughts.webfluxdemo.Merges;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class MergeUsingConcatTest {
    
    private MergeUsingConcat mergeUsingConcat;

    public MergeUsingConcatTest() {
       mergeUsingConcat = new MergeUsingConcat(); 
    }

    @Test
    void testDemonstrateMergeUsingConcat(){
        Flux<String> flux = mergeUsingConcat.demonstrateMergeUsingConcat();

        StepVerifier.create(flux).expectNext("Hello 1", "Hello 2", "Hello 3","Hello 4").verifyComplete();
    }

     
}
