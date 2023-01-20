package com.myreflectionthoughts.webfluxdemo.Merges;

import java.time.Duration;
import java.util.List;

import reactor.core.publisher.Flux;

/**
       * The operator concat() is used to merge two reactive streams.
       * This is a static method of the Flux class.
       * Scenario:- Suppose there are two micro-services that return Flux<String> but have
                   different responseTimes, this can cause disruption in the 
                   expected sequence of the emitted Data.
       * To overcome this we should use concat() operator.
       * The Streams are subscribed one after the other, hence the sequence of emitted data is
         preserved.
 */
public class MergeUsingConcat {
 
    public Flux<String> demonstrateMergeUsingConcat(){
       Flux<String> flux1 = Flux.just(new String("Hello 1"), new String("Hello 2"));
       Flux<String> flux2 = Flux.just(new String("Hello 3"), new String("Hello 4"));

    /*
         * The flux1 is first subscribed and proceeds to send the data, when 
           flux1 sends the onComplete() signal the flux2 starts to emit the 
           data. 
    */
       return Flux.concat(flux1,flux2);
    }  

    public Flux<String> generateFlux_Concat(){
         
      Flux<String> flux1 = Flux
                                .fromIterable(List.of(new String("flux Data 1"), new String("flux Data 2")))
                                .delayElements(Duration.ofMillis(1000));
      Flux<String> flux2 = Flux
                                .fromIterable(List.of(new String("flux Data 3"), new String("flux Data 4")))
                                .delayElements(Duration.ofMillis(1500));
      return Flux.concat(flux1,flux2); 
   }

}
