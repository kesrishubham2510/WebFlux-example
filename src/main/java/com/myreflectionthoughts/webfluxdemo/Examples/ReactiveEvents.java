package com.myreflectionthoughts.webfluxdemo.Examples;

import java.util.List;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * An example to demonstrate the series of events between a publisher and
   subscriber using log
 * In logs the 'request(unbounded)' means send all the data that the Flux has   
 * In logs the 'onComplete()' means end of the data stream is reached & no more data is available to be sent. 
 */

public class ReactiveEvents {

    // A class to generate a Flux
    public Flux<String> fluxOfCars() {
        return Flux.fromIterable(
            List.of(
                new String("Supra"), 
                new String("Swift"),
                 new String("Kiger")
               )
            ).log();
    }

    // A class to generate a Mono
    public Mono<String> monoOfCar() {
        return Mono.just(new String("Aventador")).log();
    }

    public static void main(String[] args) {

        ReactiveEvents reactiveEvents = new ReactiveEvents();

        Consumer<String> printCarName = (carName)->System.out.println(carName);
        // consuming the data returned by fluxOfCars in the form of reative stream
        reactiveEvents.fluxOfCars().subscribe(printCarName);

        reactiveEvents.monoOfCar().subscribe(printCarName);
    }

}
