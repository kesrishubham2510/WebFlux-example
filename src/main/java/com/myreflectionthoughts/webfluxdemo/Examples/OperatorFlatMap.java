package com.myreflectionthoughts.webfluxdemo.Examples;

import java.util.List;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;

public class OperatorFlatMap {
    
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

    public Flux<String> transformUsingOperatorFlatMap(){

         return fluxOfCars().flatMap(car-> Flux.just(car.toUpperCase()));
    }


    public static void main(String[] args) {
        
        //  creating a consumer to print the car names
        Consumer<String> printCarNames = (carName)->System.out.println(carName);

         OperatorFlatMap operatorFlatMap = new OperatorFlatMap();

         operatorFlatMap.transformUsingOperatorFlatMap().subscribe(printCarNames);
    }
}
