package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {
	public static void main(String[] args) {
		List<String> strList = Arrays.asList("사과", "바나나", "딸기", "포도", "메론");
		String[] strArr = {"비행기", "자동차", "배", "자전거", "버스", "오토바이"};
		
		// 정렬
		Collections.sort(strList);
		for(String s:strList) {
			System.out.println(s + " ");
		}
		System.out.println();
		
		// 배열 정렬
		Arrays.sort(strArr);
		for(String s: strArr) {
			System.out.println(s + " ");
		}
		
		System.out.println();
		Stream<String> stream1 = strList.stream();
		Stream<String> stream2 = Arrays.stream(strArr);
		
		stream1.sorted().forEach(System.out::print);
		System.out.println();
		stream2.sorted().forEach(System.out::print);
		
		strList.stream().sorted().forEach(System.out::print);
		
		Arrays.stream(strArr).sorted().forEach(System.out::print);
		
	}
}
