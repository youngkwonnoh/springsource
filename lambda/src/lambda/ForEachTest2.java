package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachTest2 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동", 90, 96),
				new Student("김수정", 85, 87));
		
		// 홍길동 - 90, 96
		// stream 변환
		Stream<Student> stream = list.stream();
		stream.forEach(s -> {
			System.out.println(s.getName() + " - " + s.getEng() + ", " + s.getMath());
		});
		
	}
}
