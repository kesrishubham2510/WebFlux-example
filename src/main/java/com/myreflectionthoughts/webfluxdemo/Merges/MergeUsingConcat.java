package com.myreflectionthoughts.webfluxdemo.Merges;

import reactor.core.publisher.Flux;

/**
       * The operator concat() is used to merge two reactive streams.
       * This is a static method of the Flux class.
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

}
