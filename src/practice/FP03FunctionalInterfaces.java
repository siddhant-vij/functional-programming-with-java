package practice;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

		Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
			@Override
			public boolean test(Integer x) {
				return x % 2 == 0;
			}
		};

		Function<Integer, Integer> squareFunction = x -> x * x;

		Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer x) {
				return x * x;
			}
		};

		Consumer<Integer> soutConsumer = FP03FunctionalInterfaces::print;

		Consumer<Integer> soutConsumer2 = new Consumer<Integer>() {
			public void accept(Integer x) {
				FP03FunctionalInterfaces.print(x);
			}
		};

		numbers.stream()
				.filter(isEvenPredicate)
				.map(squareFunction)
				.forEach(soutConsumer);
		System.out.println();

		System.out.println("-------------------");

		numbers.stream()
				.filter(isEvenPredicate2)
				.map(squareFunction2)
				.forEach(soutConsumer2);
		System.out.println();
	}

	private static <T> void print(T t) {
		System.out.print(t + " ");
	}
}
