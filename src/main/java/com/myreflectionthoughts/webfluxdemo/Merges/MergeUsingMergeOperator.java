package com.myreflectionthoughts.webfluxdemo.Merges;

import java.time.Duration;
import java.util.List;

import reactor.core.publisher.Flux;

/**
      * When we use merge the reactive streams involved are subscribed at the same time, 
        hence they product the result in inter-leaved fashion          
 */
public class MergeUsingMergeOperator {
    
      public Flux<String> generateFlux_Merge(){
         
         Flux<String> flux1 = Flux
                                   .fromIterable(List.of(new String("flux Data 1"), new String("flux Data 2")))
                                   .delayElements(Duration.ofMillis(1000));
         Flux<String> flux2 = Flux
                                   .fromIterable(List.of(new String("flux Data 3"), new String("flux Data 4")))
                                   .delayElements(Duration.ofMillis(1500));
         return Flux.merge(flux1,flux2); 
      }

}

