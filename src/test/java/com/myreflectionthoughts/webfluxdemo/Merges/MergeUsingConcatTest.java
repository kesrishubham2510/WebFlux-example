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

    @Test
    void testGenerateFlux_WithConcat(){
        /*
               * The reactive streams are subscribed in a sequence
                 hence they emit the data in a sequence.
         */
        Flux<String> combinedFlux = mergeUsingConcat.generateFlux_Concat();
        StepVerifier.create(combinedFlux).expectNext("flux Data 1", "flux Data 2", "flux Data 3", "flux Data 4")
                .verifyComplete();
    }
     
}
