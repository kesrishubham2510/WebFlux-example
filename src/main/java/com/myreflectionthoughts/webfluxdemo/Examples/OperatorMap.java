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


    // to test immutability of reactive streams
    public Flux<String> immutateTheFlux(){
       // assigning the flux
       Flux<String> carNames = fluxOfCars();
     
       /**
        *  If we try to apply the transformation to the flux
           by assigning it to the different variable, it does not
           work
           
        * We can modify or transform the flux only using the operators.   
        */
       
       // applying transformation to the flux
       carNames.map(String::toUpperCase);
       return carNames;    
    }

    public static void main(String[] args) {

        OperatorMap reactiveEvents = new OperatorMap();

        Consumer<String> printCarName = (carName)->System.out.println(carName);
        // transforming the data returned by fluxOfCars
        reactiveEvents.immutateTheFlux().subscribe(printCarName);

    }

}
