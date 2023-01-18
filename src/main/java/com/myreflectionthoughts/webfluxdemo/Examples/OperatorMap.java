package com.myreflectionthoughts.webfluxdemo.Examples;

import java.util.List;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;

/**
 * class illustrates example of using map operator for data transaformation
 */
public class OperatorMap {
    
     // A class to generate a Flux
     public Flux<String> fluxOfCars() {
        return Flux.fromIterable(
            List.of(
                new String("Supra"), 
                new String("Swift"),
                 new String("Kiger")
               )
            );
    }

    // transform the Flux using 'map' operator
    public Flux<String> transformedCarFlux(){
        return fluxOfCars().map(String::toUpperCase);
    }

    public static void main(String[] args) {

        OperatorMap reactiveEvents = new OperatorMap();

        Consumer<String> printCarName = (carName)->System.out.println(carName);
        // transforming the data returned by fluxOfCars
        reactiveEvents.transformedCarFlux().subscribe(printCarName);

    }

}
