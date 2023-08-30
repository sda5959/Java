import java.util.Scanner;

public class Quiz02_05
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 두개를 입력하고 엔터를 입력하세요.");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int diff1 = num1 * num2;
		System.out.println("두 수의 곱은  " + diff1);
		
		int diff2 = (diff1 > 0) ? diff1 : -diff1;
		System.out.println("두 수의 곱의 절대값  " + diff2);
	}
}
