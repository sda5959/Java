package quiz;

import java.util.Scanner;

public class Quiz06_03
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
		int num1 = sc.nextInt();
		
		
		System.out.println(num1+ "의 팩토리얼 함수의 결과는: " +fact(num1));

		
	}
	public static int fact(int num1) 
	{
		if (num1 <=1)
			return num1;
		else
			return fact(num1-1) * num1;
	}
	
}
