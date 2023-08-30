package quiz;

import java.util.Scanner;

public class Quiz06_01
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
			
		System.out.print("첫번째 숫자: ");
		int num1 = sc.nextInt();
		
		System.out.print("두번째 숫자: ");
		int num2 = sc.nextInt();
		
		int result = num1 - num2;
		
		if (result<0)
			result = -result;
		System.out.printf("%d - %d = %d %n", num1, num2, result);
	}
}
