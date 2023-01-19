package com.myreflectionthoughts.webfluxdemo.Examples;

import java.util.List;
import java.util.function.Function;

import reactor.core.publisher.Flux;

public class OperatorTransform {

    // A class to generate a Flux
    public Flux<String> fluxOfCars() {
        return Flux.fromIterable(
                List.of(
                        new String("Supra"),
                        new String("Swift"),
                        new String("Kiger"),
                        new String("Maruti 800")
                        ));
    }

    // transform the Flux using 'map' operator
    public Flux<String> transformedCarFlux() {
        return fluxOfCars().map(String::toUpperCase);
    }

    public Flux<String> useTransformOperator(){
         

        /*
            the same pipeline can be re-written with the help of transform() operator
             `fluxOfCars().map(carName->carName.toUpperCase()).filter(carName-> carName.length()<=5);`
         *  
         * 
        */ 

        Function<Flux<String>, Flux<String>> transformAndFilter = (cars)-> cars.map(car-> car.toUpperCase()).filter(carName-> carName.length()<=5);
        return fluxOfCars().transform(transformAndFilter);
    }

}
