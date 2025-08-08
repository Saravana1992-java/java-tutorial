package com.saravana.pp.fp;

import java.util.function.Function;

public class Composition {

    public static void main(String[] args) {
        Function<Integer, Integer> multiplyBy2 = x -> x * 2;
        Function<Integer, Integer> add10 = x -> x + 10;

        // Compose functions: (x * 2) + 10
        Function<Integer, Integer> composed = multiplyBy2.andThen(add10);

        System.out.println(composed.apply(5)); // Output: 20
    }


}
