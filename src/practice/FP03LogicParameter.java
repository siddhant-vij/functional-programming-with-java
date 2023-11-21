package practice;

import java.util.List;
import java.util.function.Predicate;

public class FP03LogicParameter {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

    Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
    filterAndPrint(numbers, isEvenPredicate);
    System.out.println("--------------------");

    filterAndPrint(numbers, x -> x % 2 != 0);
    System.out.println("--------------------");

    Predicate<Integer> isDivisibleByThree = x -> x % 3 == 0;
    filterAndPrint(numbers, isDivisibleByThree);
    System.out.println("--------------------");
  }

  private static <T> void print(T t) {
    System.out.print(t + " ");
  }

  private static <T> void filterAndPrint(List<T> list, Predicate<T> predicate) {
    list.stream()
        .filter(predicate)
        .forEach(FP03LogicParameter::print);
    System.out.println();
  }
}
