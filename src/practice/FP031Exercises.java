package practice;

import java.util.List;
import java.util.function.BinaryOperator;

public class FP031Exercises {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

    /*
     * Exercise 12: Find Functional Interface behind the second argument of reduce
     * method. Create an implementation for the Functional Interface.
     * 
     * int sum = numbers.stream().reduce(0, Integer::sum);
     */

    BinaryOperator<Integer> add1 = (x, y) -> x + y;
    int sum1 = numbers.stream()
        .reduce(0, add1);
    System.out.println(sum1);

    System.out.println("-------------");

    BinaryOperator<Integer> add2 = Integer::sum;
    int sum2 = numbers.stream()
        .reduce(0, add2);
    System.out.println(sum2);

    System.out.println("-------------");

    BinaryOperator<Integer> add3 = new BinaryOperator<>() {
      @Override
      public Integer apply(Integer x, Integer y) {
        return x + y;
      }
    };
    int sum3 = numbers.stream()
        .reduce(0, add3);
    System.out.println(sum3);

    System.out.println("-------------");
  }
}
