package practice;

import java.util.List;

public class FP02Functional {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    int sum = addAllNumbersInListFunctional(numbers);
    System.out.println(sum);
  }

  private static int addAllNumbersInListFunctional(List<Integer> numbers) {
    // Using Lambda Expression & identity element
    // return numbers.stream().reduce(0, (x, y) -> x + y);

    // Using method reference & identity element
    // return numbers.stream().reduce(0, Integer::sum);

    // Using Lambda Expression without identity element
    return numbers.stream().reduce((x, y) -> x + y).get();

    // Using Method Reference without identity element
    // return numbers.stream().reduce(Integer::sum).get();
  }
}
