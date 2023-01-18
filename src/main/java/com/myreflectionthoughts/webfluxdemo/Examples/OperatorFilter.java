package com.myreflectionthoughts.webfluxdemo.Examples;

import java.util.function.Predicate;

import reactor.core.publisher.Flux;

public class OperatorFilter {
    
    public Flux<Integer> getNumbers(){
        Integer[]  numbers =  {1,2,3,4,5,-6,8,33,-1,2};
        return Flux.fromArray(numbers);
    }

    public Flux<Integer> giveMeNegativeNumbers(){
        
        // creating a predicate
        Predicate<Integer> filterNegative = (number)->number<0;
        
        /*
           Method uses filter operator to filter out the negative numbers
           from the Flux<Integer> returned by getNumbers 
        */

        return getNumbers().filter(filterNegative);
    }

    public static void main(String[] args) {
        
       OperatorFilter operatorFilter = new OperatorFilter();

       System.out.println("Printing out the negative numbers:---"); 
       operatorFilter.giveMeNegativeNumbers().subscribe(System.out::println);

    }
}
