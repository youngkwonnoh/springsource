package lambda;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest4 {
	public static void main(String[] args) {
		
		// 중간연산 - 3. distinct : 중복 제거
		List<String> list2 = Arrays.asList("바둑", "바나나", "포도", "딸기", "바질", "수박", "포도");
		
		list2.stream().distinct().forEach(System.out::println);
		
		// 파일의 확장자만 추출하고 중복을 제거한 후 출력하기
		Stream<File> stream = Stream.of(new File("file1.txt"), new File("file2.back"), new File("file3.txt"), new File("file4.java"), new File("Ex1"));
		
//		File f = new File("file5.txt");
//		// int pos=  f.getName().indexOf(".");
//		
//		if(f.getName().indexOf(".") > -1) {
//			int pos = f.getName().indexOf(".") + 1;
//			System.out.println(f.getName().substring(pos));
//		}
		
		stream.map(File::getName) // 파일명 수집 => {"file.txt", "file2.back", "file3.txt", "file4.java", "Ex1"}
			.filter(f -> f.indexOf(".") > -1) // 확장자가 있는 것만
			.map(f -> f.substring(f.indexOf(".")+1)) // 확장자만 수집
			.distinct() // 중복제거
			.forEach(System.out::println); // 출력
		
	}
}
