package practice;

import java.util.List;

public class FP01Functional {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    printAllNumbersInListFunctional(numbers);
    System.out.println("-------------------");
    printEvenNumbersInListFunctional(numbers);
    System.out.println("-------------------");
  }

  private static void print(int num) {
    System.out.print(num + " ");
  }

  private static void printAllNumbersInListFunctional(List<Integer> numbers) {
    // Using Lambda Expression
    numbers.stream().forEach((number) -> System.out.print(number + " "));
    System.out.println();

    // Using Method Reference - System.out::println
    // numbers.stream().forEach(System.out::println);
    // System.out.println();

    // Using Method Reference - print
    numbers.stream().forEach(FP01Functional::print);
    System.out.println();
  }

  private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
    numbers.stream()
        .filter(number -> number % 2 == 0)
        .forEach(FP01Functional::print);
    System.out.println();
  }
}
