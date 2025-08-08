package com.saravana.pp.fp;

import java.util.function.Function;

public class FirstClassHigherOrderFunction {
// Higher-order function: accepts a function as argument
    public static int applyFunction(int x, Function<Integer, Integer> func) {
        return func.apply(x);
    }

    public static void main(String[] args) {
        Function<Integer, Integer> doubleIt = n -> n * 2;
        System.out.println(applyFunction(5, doubleIt)); // Output: 10
    }

}
