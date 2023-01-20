package com.myreflectionthoughts.webfluxdemo.Errors;

import java.util.List;
import java.util.function.Function;

import com.myreflectionthoughts.webfluxdemo.Exceptions.NoElementException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
     * If the publisher doesn't emit any data, we might want to handle the 
       situation using some exception handling based on the cause.
     * SwitchIfEmpty is used, it can emit an publisher that can contain
       the exception object. 
     * DefaultIfEmpty emits data of the same type as the flux was supposed
       to.  
       
 */
public class SwitchWhenEmpty {
    
    public Flux<String> fluxOfNames(){
        return Flux.fromIterable(List.of(new String("Student 1"), new String("Professor 1"), new String("Principal 1")));
    }

    // this method handles the case when the flux is empty
    public Flux<String> handleTheNameflux(){
        
        Function<Flux<String>, Flux<String>> filterNames = (name)-> name.filter(personName->personName.length()<9);
        return fluxOfNames().transform(filterNames).switchIfEmpty(Mono.error(new NoElementException("No element with size less than 9 exists"))).log();
    }
}
