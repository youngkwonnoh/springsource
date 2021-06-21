package lambda;

import java.util.function.IntBinaryOperator;

public class LambdaEx7 {
	
	private static int[] scores = {92, 95, 87};
	
	public static int maxOrMin(IntBinaryOperator operator) {
		int result = scores[0];
		for(int score : scores) {
			result = operator.applyAsInt(result, score);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// Operator : 매개값과 리턴값 모두 있음, 주로 매개값을 연산하고 결과를 리턴
		int max = maxOrMin(
				(a,b) -> {
					if(a>=b) return a;
					else return b;
				}
			);
		System.out.println("최대값 : " + max);
		int min = maxOrMin(
				(a, b) -> {
					if(a<=b) return a;
					else return b;
				}
			);
		System.out.println("최소값 : " + min);		
		
	}
}
