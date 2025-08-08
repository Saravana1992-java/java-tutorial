package com.saravana.pp.fp;

import java.util.List;
import java.util.stream.Collectors;

public class Immutability {

    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Instead of modifying the original list, create a new one
        List<String> upperNames = names.stream()
                                       .map(String::toUpperCase)
                                       .collect(Collectors.toList());

        System.out.println(upperNames); // [ALICE, BOB, CHARLIE]
    }
}
