package com.myreflectionthoughts.webfluxdemo.Examples;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;

/**
 * The concatMap() operator preserves the sequence of the reactive streams.
 * 
 * Suppose, we are to apply a service which transforms the input passed
 * but takes random amount time for every input, in such scenario the
 * result returned might not be in the expected order. This is a possible
 * scenario
 * when using a flatMap
 * 
 * Requirement(flatMap() + preserve the order) = concatMap()
 */
public class OperatorConcatMap {

    // A class to generate a Flux
    public Flux<String> fluxOfCars() {
        return Flux.fromIterable(
                List.of(
                        new String("Supra"),
                        new String("Swift"),
                        new String("Kiger")));
    }

    public Flux<String> transformUsingOperatorFlatMap() {
        return fluxOfCars().flatMap(this::splitTheString);
    }

    /**
     * The flatMap() operator also supports asynchronous operations
     */
    public Flux<String> operateUsingConcatMap() {
        return fluxOfCars().concatMap(this::splitTheString);
    }

    public Flux<String> splitTheString(String stringToSplit) {
        String[] charArray = stringToSplit.split("");
        int delay = new Random().nextInt(0, 1000);
        return Flux.fromArray(charArray).delayElements(Duration.ofMillis(delay)).log();
    }

    public static void main(String[] args) {

        // creating a consumer to print the car names
        Consumer<String> printCarNames = (carName) -> System.out.println(carName);

        OperatorConcatMap operatorConcatMap = new OperatorConcatMap();

        operatorConcatMap.operateUsingConcatMap().subscribe(printCarNames);
    }
}
