package com.myreflectionthoughts.webfluxdemo.Merges;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
      * Operator concatwith() is an instance method
      * It works similar to the concat() method of the Flux class
      * ConcatWith can be used to merge a 'Mono' with another 'Mono' to generate a Flux result
 */

public class MergeUsingConcatWith {
    
    public Flux<String> demonstrateMergeUsingConcatWith(){
        Flux<String> flux1 = Flux.just(new String("Hello 1"), new String("Hello 2"));
        Flux<String> flux2 = Flux.just(new String("Hello 3"), new String("Hello 4"));
        
     /*
          * Concating the flux2 with flux1 using concatWith() operator.
     */
        return flux1.concatWith(flux2);
    }  

    public Flux<String> combineMonoToGenerateFlux(){
        Mono<String> mono1 = Mono.just("Mono 1");
        Mono<String> mono2 = Mono.just("Mono 2");

        return mono1.concatWith(mono2);
    }

 
}
