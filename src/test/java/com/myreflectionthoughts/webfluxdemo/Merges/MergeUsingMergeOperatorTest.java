package com.myreflectionthoughts.webfluxdemo.Merges;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class MergeUsingMergeOperatorTest {

    private MergeUsingMergeOperator mergeUsingMergeOperator;

    public MergeUsingMergeOperatorTest() {
        mergeUsingMergeOperator = new MergeUsingMergeOperator();
    }

    @Test
    void testGenerateFlux_Merge() {
          /*
               * The reactive streams involved are subscribed at the same time, hence producing
                 the result in a inter-leaved fashion.
          */
        Flux<String> combinedFlux = mergeUsingMergeOperator.generateFlux_Merge();
        StepVerifier.create(combinedFlux).expectNext("flux Data 1", "flux Data 3", "flux Data 2", "flux Data 4")
                .verifyComplete();
    }
}
