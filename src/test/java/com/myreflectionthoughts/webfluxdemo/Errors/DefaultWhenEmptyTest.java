package com.myreflectionthoughts.webfluxdemo.Errors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class DefaultWhenEmptyTest {
    
    private DefaultWhenEmpty defaultWhenEmpty;

    public DefaultWhenEmptyTest() {
      defaultWhenEmpty = new DefaultWhenEmpty();
    }

    @Test
    void testHandleTheNameFlux(){
        Flux<String> filteredNames = defaultWhenEmpty.handleTheNameflux();
        StepVerifier.create(filteredNames).expectNext("This is empty").verifyComplete();
    }

    /*
        The method sends the onComplete() reactive-stream-event since the publisher had nothing to sent
        onNext() has nothing to sent and this was not handled properly in the pipeline.
    */
    @Test
    void testFilterTheNameFlux(){
       Flux<String> filteredNames = defaultWhenEmpty.filterTheNameflux();
       StepVerifier.create(filteredNames).expectComplete();
    }
    
}
