package com.myreflectionthoughts.webfluxdemo.Examples;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
      *  The flatMapMany() operator is used in the case, we need to create a flux 
         by tranforming a mono.

      * If the mono pipeline needs to return a Flux, we use flatMapMany() operator.   
 */
public class OperatorFlatMapMany {
    
    public Flux<String> usesFlatMapManyOperator(String input){
        return Mono.just(input).flatMapMany(this::splitInputString).log();
    }

    public Flux<String> splitInputString(String stringToSplit){
        return Flux.fromArray(stringToSplit.split(""));
    }

    public static void main(String[] args) {
        
    }
}
