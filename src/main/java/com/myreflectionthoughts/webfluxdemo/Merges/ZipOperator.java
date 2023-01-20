package com.myreflectionthoughts.webfluxdemo.Merges;

import com.myreflectionthoughts.webfluxdemo.Employee;

import reactor.core.publisher.Flux;

/*
       * The zip operator can be used to merge publishers.
       * The involved publisher's value can be used to prepare
         another value/data to be emitted by the new publisher.  

       * Scenario:- querying different set of information about a user
                    to display to the platform admin.  
*/

public class ZipOperator {
    
    public Flux<Employee> combinePublisher_to_genratePublisher(){
        
        // List<String> firstNames = new ArrayList<>(){
        //     {
        //         new String("Data");
        //         new String("Software");
        //         new String("Risk");
        //     }
        //   };
        // List<String> lastNames = new ArrayList<>(){
        //     {
        //         new String("Analyst");
        //         new String("Engineer");
        //         new String("Advisor");
        //     }
        // };
        // List<Integer> roleLevels = new ArrayList<>(){
        //     {
        //         Integer.valueOf(1);
        //         Integer.valueOf(2);
        //         Integer.valueOf(3);
        //     }
        // };

        // Flux<String> fluxFirstNames = Flux.fromIterable(firstNames);
        // Flux<String> fluxLastNames = Flux.fromIterable(lastNames);
        // Flux<Integer> fluxRoleLevels = Flux.fromIterable(roleLevels);

        Flux<String> fluxFirstNames = Flux.just( new String("Data"),new String("Software"),new String("Risk"));
        Flux<String> fluxLastNames = Flux.just(new String("Analyst"),new String("Engineer"),new String("Advisor"));
        Flux<Integer> fluxRoleLevels = Flux.just(Integer.valueOf(1),Integer.valueOf(2),Integer.valueOf(3));

        return Flux.zip(fluxFirstNames, fluxLastNames, fluxRoleLevels).map(combinedValueTuple-> new Employee(combinedValueTuple.getT1(),combinedValueTuple.getT1()+" "+combinedValueTuple.getT2()+"-"+combinedValueTuple.getT3())).log();
    }
}
