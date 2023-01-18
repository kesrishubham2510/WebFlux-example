package com.myreflectionthoughts.webfluxdemo.Examples;

import java.util.List;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *  A Simple example to demonstrate acessing of the values published by a Publisher
 *  i.e., Mono and Flux 
 */

public class FluxSubscribe {
    // A class to generate a Flux
    public Flux<String> fluxOfCars(){
        return Flux.fromIterable(List.of(new String("Supra"), new String("Swift"), new String("Kiger")));
    }

    // A class to generate a Mono
    public Mono<String> monoOfCar(){
        return Mono.just(new String("Aventador"));
    }

    public static void main(String[] args) {
        
        FluxSubscribe fluxSubscriptionDemo = new FluxSubscribe();

        Consumer<String> printCarName = (name)->System.out.println(name);
        
        /**
         *  to access the value we need to 'subscribe' to the Flux<String>
            returned by the fluxOfCars() method. 
        */
        fluxSubscriptionDemo.fluxOfCars().subscribe(printCarName);

        /**
         *  to access the value we need to 'subscribe' to the Mono<String>
            returned by the monoOfCar() method. 
        */
         fluxSubscriptionDemo.monoOfCar().subscribe(printCarName);
     
    }
}
