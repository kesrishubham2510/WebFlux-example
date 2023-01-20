package com.myreflectionthoughts.webfluxdemo.Merges;

import java.time.Duration;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
      * mergeWith() is similar to merge(), the key difference being 
        former is a instance level method and later being static method.
      * A Mono can be merged with another Mono to generate a flux.  
 */

public class MergeUsingMergeWithOperator {
    
    public Flux<String> generateFlux_Merge(){
         
        Flux<String> flux1 = Flux
                                  .fromIterable(List.of(new String("flux Data 1"), new String("flux Data 2")))
                                  .delayElements(Duration.ofMillis(1000));
        Flux<String> flux2 = Flux
                                  .fromIterable(List.of(new String("flux Data 3"), new String("flux Data 4")))
                                  .delayElements(Duration.ofMillis(1500));
        return flux1.mergeWith(flux2); 
     }

     public Flux<String> generateFluxFromMono(){
        Mono<String> mono1 = Mono.just("Mono 1").delayElement(Duration.ofMillis(1000));
        Mono<String> mono2 = Mono.just("Mono 2").delayElement(Duration.ofMillis(100));

        return mono1.mergeWith(mono2);
     }

}
