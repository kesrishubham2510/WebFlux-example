package com.myreflectionthoughts.webfluxdemo.Errors;

import java.util.List;
import java.util.function.Function;

import reactor.core.publisher.Flux;

/**
       * Example to illustrate the use of deafultIfEmpty() operator in reactive programming.
       * In a failure scenario when the publisher does not contain any data to emit,
         we should handle it using to provide a better understanding of the cause of the 
         error/issue.
 */
public class DefaultWhenEmpty {

    public Flux<String> fluxOfNames(){
        
        return Flux.fromIterable(List.of(new String("Student 1"), new String("Professor 1"), new String("Principal 1")));
    }

    // this method does not handle the case when Flux is empty
    public Flux<String> filterTheNameflux(){
        
        Function<Flux<String>, Flux<String>> filterNames = (name)-> name.filter(personName->personName.length()<9);

        return fluxOfNames().transform(filterNames).log();
    }


    // this method handles the case when the flux is empty
    public Flux<String> handleTheNameflux(){
        
        Function<Flux<String>, Flux<String>> filterNames = (name)-> name.filter(personName->personName.length()<9);

        return fluxOfNames().transform(filterNames).defaultIfEmpty("This is empty").log();
    }
}
