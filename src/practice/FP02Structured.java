package practice;

import java.util.List;

public class FP02Structured {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    int sum = addAllNumbersInListStructured(numbers);
    System.out.println(sum);
  }

  private static int addAllNumbersInListStructured(List<Integer> numbers) {
    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }
    return sum;
  }
}
