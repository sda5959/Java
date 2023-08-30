package quiz;

import java.util.Scanner;

public class Quiz06_09
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요: ");
		int num = sc.nextInt();
		System.out.println(num + "단의 역순");
		
		for (int i = num; i >= 1; i--)
		{
			System.out.println(num + "*" + i + "=" + num * i);
		}
	}
}
