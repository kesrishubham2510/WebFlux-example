package com.myreflectionthoughts.webfluxdemo.Merges;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class MergeUsingMergeWithOperatorTest {
   
    private MergeUsingMergeWithOperator mergeUsingMergeWithOperator;

    public MergeUsingMergeWithOperatorTest() {
        mergeUsingMergeWithOperator = new MergeUsingMergeWithOperator();
    }

    @Test
    void testGenerateflux(){
        Flux<String> combinedFlux = mergeUsingMergeWithOperator.generateFlux_Merge();
        StepVerifier.create(combinedFlux).expectNext("flux Data 1", "flux Data 3", "flux Data 2", "flux Data 4")
                .verifyComplete();
    }

    @Test
    void testGenerateFluxFromMono(){
        Flux<String> combinedFlux = mergeUsingMergeWithOperator.generateFluxFromMono();
        StepVerifier.create(combinedFlux).expectNext("Mono 2", "Mono 1")
                .verifyComplete();
    }
    
}
