package practice;

import java.util.*;
import java.util.stream.Collectors;

public class FP02Exercises {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    int sum7 = addSquaresOfNumbersInList(numbers);
    System.out.println(sum7);

    System.out.println("-------------------");

    int sum8 = addCubesOfNumbersInList(numbers);
    System.out.println(sum8);

    System.out.println("-------------------");

    int sum9 = addOddNumbersInList(numbers);
    System.out.println(sum9);

    System.out.println("-------------------");

    List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
        "Spring Boot", "Docker", "Kubernetes", "Spring Cloud", "Spring Security", "Spring", "Spring Boot", "API",
        "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes", "Spring Cloud", "Spring Security");

    List<String> courseList = getListOfDistinctStringSortedCourses(courses);
    System.out.println(courseList);

    System.out.println("-------------------");

    List<String> courseList2 = getListOfDistinctLengthSortedCourses(courses);
    System.out.println(courseList2);

    System.out.println("-------------------");

    List<Integer> evenNumbersList = getListOfDistinctEvenSortedNumbers(numbers);
    System.out.println(evenNumbersList);

    System.out.println("-------------------");

    List<String> listCourseLength = getListOfCourseLength(courses);
    listCourseLength.forEach(System.out::println);
  }

  private static int addSquaresOfNumbersInList(List<Integer> numbers) {
    return numbers.stream()
        .map(number -> number * number)
        .reduce(0, Integer::sum);
  }

  private static int addCubesOfNumbersInList(List<Integer> numbers) {
    return numbers.stream()
        .map(number -> number * number * number)
        .reduce(0, Integer::sum);
  }

  private static int addOddNumbersInList(List<Integer> numbers) {
    return numbers.stream()
        .filter(number -> number % 2 != 0)
        .reduce(0, Integer::sum);
  }

  private static List<String> getListOfDistinctStringSortedCourses(List<String> courses) {
    return courses.stream()
        .distinct()
        .sorted(Comparator.naturalOrder())
        .collect(Collectors.toList());
  }

  private static List<String> getListOfDistinctLengthSortedCourses(List<String> courses) {
    return courses.stream()
        .distinct()
        .sorted(Comparator.comparingInt(String::length))
        .collect(Collectors.toList());

    // return courses.stream()
    //     .distinct()
    //     .sorted(Comparator.comparing(str -> str.length()))
    //     .collect(Collectors.toList());
  }

  private static List<Integer> getListOfDistinctEvenSortedNumbers(List<Integer> numbers) {
    return numbers.stream()
        .distinct()
        .filter(number -> number % 2 == 0)
        .sorted()
        .collect(Collectors.toList());
  }

  private static List<String> getListOfCourseLength(List<String> courses) {
    return courses.stream()
        .map((str) -> str + " -> " + str.length())
        .collect(Collectors.toList());
  }
}
