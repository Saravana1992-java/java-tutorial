package com.saravana.pp.fp;

public class PureFunctions {
    // Pure function: no side effects, same output for same input
    public static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        System.out.println(square(5)); // Output: 25
    }
}
