package lambda;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamTest7 {
	public static void main(String[] args) {
		IntStream stream = Arrays.stream(new int[] {1, 2, 3, 4, 5});
		
		// 2의 배수 개수
//		long count = stream.filter(i -> i % 2 == 0).count();
//		System.out.println("2의 배수 개수 : " + count);
		
		// 2의 배수 합
//		int sum = stream.filter(i -> i % 2 == 0).sum();
//		System.out.println("2의 배수 합 : " + sum);
		
		// 2의 배수 평균
//		OptionalDouble avergage = stream.filter(i -> i % 2 == 0).average();
//		System.out.println("2의 배수 평균 : " + avergage);

		// 2의 배수 최대
//		OptionalInt max = stream.filter(i -> i % 2 == 0).max();
//		System.out.println("2의 배수 최대 : " + max);

		// 2의 배수 최소
		OptionalInt min = stream.filter(i -> i % 2 == 0).min();
		System.out.println("2의 배수 최소 : " + min);
	}
}
