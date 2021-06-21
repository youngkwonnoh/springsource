package lambda;

import java.util.Arrays;
import java.util.List;

public class StreamTest5 {
	public static void main(String[] args) {
		
		// 중간연산 - 4. skip : 건너 뛰기, limit : 요소 제한
		List<String> list2 = Arrays.asList("바둑", "바나나", "포도", "딸기", "바질", "수박", "포도");
		
		list2.stream().skip(2).limit(3).forEach(System.out::println);
	}
}
