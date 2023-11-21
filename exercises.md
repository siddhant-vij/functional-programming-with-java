## Exercise 1 - FP01Exercises.java

Print Only Odd Numbers from the List

## Exercise 2 - FP01Exercises.java

Print All Courses individually

`List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes")`

## Exercise 3 - FP01Exercises.java

Print Courses Containing the word "Spring"

## Exercise 4 - FP01Exercises.java

Print Courses Whose Name has atleast 4 letters

## Exercise 5  - FP01Exercises.java

Print the cubes of odd numbers

## Exercise 6  - FP01Exercises.java

Print the number of characters in each course name


## Exercise 7 - FP02Exercises.java

Square every number in a list and find the sum of squares

## Exercise 8 - FP02Exercises.java

Cube every number in a list and find the sum of cubes

## Exercise 9 - FP02Exercises.java

Find Sum of Odd Numbers in a list

## Exercise 10 - FP02Exercises.java

Create a List with Even Numbers Filtered from the Numbers List

## Exercise 11 - FP02Exercises.java

Create a List with lengths of all course titles.

## Exercise 12

Find Functional Interface behind the second argument of reduce method. Create an implementation for the Functional Interface.

int sum = numbers.stream()
	.reduce(0, Integer::sum);

## Exercise 13

Do Behavior Parameterization for the mapping logic.

List<Integer> squaredNumbers =  numbers.stream()
									   .map(x -> x*x)
									   .collect(Collectors.toList());
