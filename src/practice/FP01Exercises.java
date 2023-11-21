package practice;

import java.util.List;

public class FP01Exercises {
  public static void main(String[] args) {
    List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
    printOddNumbersInListFunctional(numbers);
    System.out.println("-------------------");

    List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes", "Spring Cloud", "Spring Security");

    printAllCourses(courses);
    System.out.println("-------------------");
    printCoursesWithWord(courses, "Spring");
    System.out.println("-------------------");
    printCoursesWithMinLength(courses, 4);
    System.out.println("-------------------");
    printCubesOfOddNumbersInListFunctional(numbers);
    System.out.println("-------------------");
    printNumberOfCharactersInListFunctional(courses);
    System.out.println("-------------------");
  }

  private static <T> void print(T t) {
    System.out.print(t + ", ");
  }

  private static void printOddNumbersInListFunctional(List<Integer> numbers) {
    numbers.stream()
        .filter(number -> number % 2 != 0)
        .forEach(FP01Exercises::print);
    System.out.println();
  }

  private static void printAllCourses(List<String> courses) {
    courses.stream()
        .forEach(FP01Exercises::print);
    System.out.println();
  }

  private static void printCoursesWithWord(List<String> courses, String word) {
    courses.stream()
        .filter(course -> course.contains(word))
        .forEach(FP01Exercises::print);
    System.out.println();
  }

  private static void printCoursesWithMinLength(List<String> courses, int length) {
    courses.stream()
        .filter(course -> course.length() >= length)
        .forEach(FP01Exercises::print);
    System.out.println();
  }

  private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
    numbers.stream()
        .filter(number -> number % 2 != 0)
        .map(number -> number * number * number)
        .forEach(FP01Exercises::print);
    System.out.println();
  }

  private static void printNumberOfCharactersInListFunctional(List<String> courses) {
    courses.stream()
        .map(course -> course + " -> " + course.length())
        .forEach(System.out::println);
  }
}
