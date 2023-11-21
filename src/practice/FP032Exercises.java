package practice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Function;

public class FP032Exercises {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

    /*
     * Exercise 13: Do Behavior Parameterization for the mapping logic.
     * 
     * List<Integer> squaredNumbers = numbers.stream()
     *                                       .map(x -> x*x)
     *                                       .collect(Collectors.toList());
     */

    numbers.forEach(FP032Exercises::print);
    System.out.println();

    System.out.println("-------------");

    Function<Integer, Integer> doubled = x -> x + x;
    mapAndCreateNewList(numbers, doubled);
    System.out.println("-------------");

    Function<Integer, Integer> squared = x -> x * x;
    mapAndCreateNewList(numbers, squared);
    System.out.println("-------------");

    Function<Integer, Integer> cubed = new Function<>() {
      @Override
      public Integer apply(Integer x) {
        return x * x * x;
      }
    };
    mapAndCreateNewList(numbers, cubed);
    System.out.println("-------------");
  }

  private static <T> void print(T t) {
    System.out.print(t + " ");
  }

  private static <T, R> void mapAndCreateNewList(List<T> numbers, Function<T, R> map) {
    numbers.stream()
        .map(map)
        .collect(Collectors.toList())
        .forEach(FP032Exercises::print);
    System.out.println();
  }
}
