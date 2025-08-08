package com.saravana.pp.fp;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable(getName());

        String result = name.map(String::toUpperCase)
                            .orElse("UNKNOWN");

        System.out.println(result); // Output: UNKNOWN or uppercase name
    }

    static String getName() {
        return null; // Simulate missing value
    }


}
