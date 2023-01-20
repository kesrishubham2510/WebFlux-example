package com.myreflectionthoughts.webfluxdemo.Merges;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class MergeUsingConcatWithTest {

    private MergeUsingConcatWith mergeUsingConcatWith;

    public MergeUsingConcatWithTest() {
        mergeUsingConcatWith = new MergeUsingConcatWith();
    }

    @Test
    void testDemonstrateMergeUsingConcatwith() {
        Flux<String> flux = mergeUsingConcatWith.demonstrateMergeUsingConcatWith();

        StepVerifier.create(flux).expectNext("Hello 1", "Hello 2", "Hello 3", "Hello 4").verifyComplete();
    }

    @Test
    void testCombineMonoToGenerateFlux(){
        Flux<String> fluxOfMonos  = mergeUsingConcatWith.combineMonoToGenerateFlux();
        StepVerifier.create(fluxOfMonos).expectNext("Mono 1","Mono 2").verifyComplete();
    }
}
