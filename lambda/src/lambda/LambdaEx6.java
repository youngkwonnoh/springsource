package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx6 {
	public static void main(String[] args) {
		// 자바 표준 API의 함수적 인터페이스
		// Consumer : 매개값은 있고 리턴값은 없음
		// BiConsumer or DoubleConsumer...
		Consumer<String> consumer = str -> System.out.println(str);
		consumer.accept("Hello");
		
		// Supplier : 매개값은 없고, 리턴값은 있음
		// BooleanSupplier / IntSupplier
		Supplier<Integer> supplier = () -> (int)(Math.random()*100) + 1;
		// IntSupplier<Integer> supplier = () -> (int)(Math.random()*100) + 1;
		System.out.println(supplier.get());
		
		// Function : 매개값과 리턴값 모두 있음, 주로 매개값을 리턴값으로 매핑
		// DoublieFunction / IntToLongFunction..
		Function<Integer, Integer> function = i -> i/10*10;
		System.out.println(function.apply(545));
		
		// Predicate : 매개값은 있고, 리턴 타입은 boolean, 매개값을 조사해서 t/f 리턴
		Predicate<Integer> p = i -> i > 10;
		System.out.println(p.test(6));
	}
}
