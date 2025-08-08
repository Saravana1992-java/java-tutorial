package com.saravana.pp.fp;

import java.util.List;

public class DeclarativeNature {
public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Declarative: what to do, not how
        int sumOfSquares = numbers.stream()
                                  .map(n -> n * n)
                                  .reduce(0, Integer::sum);

        System.out.println(sumOfSquares); // Output: 55
    }

}
