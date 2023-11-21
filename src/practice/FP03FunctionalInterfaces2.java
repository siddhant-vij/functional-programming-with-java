package practice;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces2 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

		Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

		Function<Integer, Integer> squareFunction = x -> x * x;

		Function<Integer, String> stringOutputFunction = x -> x + " ";

		Consumer<Integer> soutConsumer = x -> System.out.println(x);

		BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;

		Supplier<Integer> randomIntegerSupplier = () -> new Random().nextInt(1000);
		System.out.println(randomIntegerSupplier.get());

		UnaryOperator<Integer> unaryOperator = x -> 3 * x;
		System.out.println(unaryOperator.apply(10));

		BiPredicate<Integer, String> biPredicate = (number, str) -> number < 10 && str.length() > 5;
		System.out.println(biPredicate.test(10, "tempStringTest"));

		BiFunction<Integer, String, String> biFunction = (number, str) -> number + ", " + str;
		System.out.println(biFunction.apply(15, "tempStringTest"));

		BiConsumer<Integer, String> biConsumer = (s1, s2) -> {
			System.out.println(s1 + " " + s2);
		};
		biConsumer.accept(25, "tempStringTest");

		// IntBinaryOperator
		// IntConsumer
		// IntFunction
		// IntPredicate
		// IntSupplier
		// IntToDoubleFunction
		// IntToLongFunction
		// IntUnaryOperator

		// Long, Double, Int
	}
}
