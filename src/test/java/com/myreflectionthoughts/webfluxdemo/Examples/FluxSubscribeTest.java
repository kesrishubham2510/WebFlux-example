package com.myreflectionthoughts.webfluxdemo.Examples;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
public class FluxSubscribeTest {

    private FluxSubscribe fluxSubscribe;

    public FluxSubscribeTest(){
        fluxSubscribe = new FluxSubscribe();
    }

    @Test
    void testFluxOfCars(){
        Flux<String> cars = fluxSubscribe.fluxOfCars();

        // the create() method takes care of subscribing to the publisher
        // testing every element in the sequence
        StepVerifier.create(cars).expectNext("Supra","Swift","Kiger").verifyComplete();

        // testing the number of elements in the flux
        StepVerifier.create(cars).expectNextCount(3).verifyComplete();
    }

    @Test
    void testMonoOfCar(){
        Mono<String> car = fluxSubscribe.monoOfCar();

        // the create() method takes care of subscribing to the publisher
        // testing every element in the sequence
        StepVerifier.create(car).expectNext("Aventador").verifyComplete();

        // testing the number of elements in the flux
        StepVerifier.create(car).expectNextCount(1).verifyComplete();
    }



    

}
