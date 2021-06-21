package lambda;

public class LambdaEx3 {
	public static void main(String[] args) {
		
		// Lambda3 
		// Lambda3 lambda = (int a, int b) -> a > b ? a : b;
		Lambda3 lambda = (a, b) -> a > b ? a : b;
		System.out.println(lambda.max(2346, 5985));
	}
}
