package practice;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Course {
  private String name;
  private String category;
  private int reviewScore;
  private int noOfStudents;

  public Course(String name, String category, int reviewScore, int noOfStudents) {
    this.name = name;
    this.category = category;
    this.reviewScore = reviewScore;
    this.noOfStudents = noOfStudents;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getReviewScore() {
    return reviewScore;
  }

  public void setReviewScore(int reviewScore) {
    this.reviewScore = reviewScore;
  }

  public int getNoOfStudents() {
    return noOfStudents;
  }

  public void setNoOfStudents(int noOfStudents) {
    this.noOfStudents = noOfStudents;
  }

  public String toString() {
    return name + ":" + noOfStudents + ":" + reviewScore;
  }
}

public class FP04CustomClass {
  public static void main(String[] args) {
    List<Course> courses = List.of(
        new Course("Spring", "Framework", 98, 20000),
        new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
        new Course("Microservices", "Microservices", 96, 25000),
        new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
        new Course("Azure", "Cloud", 99, 21000),
        new Course("Docker", "Cloud", 92, 20000),
        new Course("Kubernetes", "Cloud", 91, 20000));

    // allMatch, noneMatch, anyMatch
    Predicate<Course> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;
    Predicate<Course> reviewScoreLessThan90 = course -> course.getReviewScore() < 90;
    System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95));
    System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95));
    System.out.println(courses.stream().noneMatch(reviewScoreLessThan90));
    System.out.println(courses.stream().anyMatch(reviewScoreLessThan90));

    Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator
        .comparingInt(Course::getNoOfStudents);
    System.out.println(
        courses.stream()
            .sorted(comparingByNoOfStudentsIncreasing)
            .collect(Collectors.toList()));

    Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator
        .comparingInt(Course::getNoOfStudents).reversed();
    System.out.println(
        courses.stream()
            .sorted(comparingByNoOfStudentsDecreasing)
            .collect(Collectors.toList()));

    Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator
        .comparingInt(Course::getNoOfStudents)
        .thenComparingInt(Course::getReviewScore)
        .reversed();
    System.out.println(
        courses.stream()
            .sorted(comparingByNoOfStudentsAndNoOfReviews)
            .collect(Collectors.toList()));

    System.out.println(
        courses.stream()
            .sorted(comparingByNoOfStudentsAndNoOfReviews)
            .limit(5)
            .collect(Collectors.toList()));

    System.out.println(
        courses.stream()
            .sorted(comparingByNoOfStudentsAndNoOfReviews)
            .skip(3)
            .collect(Collectors.toList()));

    System.out.println(
        courses.stream()
            .sorted(comparingByNoOfStudentsAndNoOfReviews)
            .skip(3)
            .limit(5)
            .collect(Collectors.toList()));

    System.out.println(
        courses.stream()
            .takeWhile(course -> course.getReviewScore() >= 95)
            .collect(Collectors.toList()));

    System.out.println(
        courses.stream()
            .dropWhile(course -> course.getReviewScore() >= 95)
            .collect(Collectors.toList()));

    System.out.println(
        courses.stream()
            .max(comparingByNoOfStudentsAndNoOfReviews));

    System.out.println(
        courses.stream()
            .min(comparingByNoOfStudentsAndNoOfReviews)
            .orElse(new Course("Kubernetes", "Cloud", 91, 20000)));

    System.out.println(
        courses.stream()
            .filter(reviewScoreLessThan90)
            .min(comparingByNoOfStudentsAndNoOfReviews)
            .orElse(new Course("Kubernetes", "Cloud", 91, 20000)));

    System.out.println(
        courses.stream()
            .filter(reviewScoreLessThan90)
            .findFirst());

    System.out.println(
        courses.stream()
            .filter(reviewScoreGreaterThan95)
            .findFirst());

    System.out.println(
        courses.stream()
            .filter(reviewScoreGreaterThan95)
            .findAny());

    System.out.println(
        courses.stream()
            .filter(reviewScoreGreaterThan95)
            .mapToInt(Course::getNoOfStudents)
            .sum());

    System.out.println(
        courses.stream()
            .filter(reviewScoreGreaterThan95)
            .mapToInt(Course::getNoOfStudents)
            .average());

    System.out.println(
        courses.stream()
            .filter(reviewScoreGreaterThan95)
            .mapToInt(Course::getNoOfStudents)
            .count());

    System.out.println(
        courses.stream()
            .filter(reviewScoreGreaterThan95)
            .mapToInt(Course::getNoOfStudents)
            .max());

    System.out.println(
        courses.stream()
            .collect(Collectors.groupingBy(Course::getCategory)));

    System.out.println(
        courses.stream()
            .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));

    System.out.println(
        courses.stream()
            .collect(Collectors.groupingBy(Course::getCategory,
                Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));

    System.out.println(
        courses.stream()
            .collect(Collectors.groupingBy(Course::getCategory,
                Collectors.mapping(Course::getName, Collectors.toList()))));

  }
}
