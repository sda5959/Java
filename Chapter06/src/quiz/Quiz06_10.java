package quiz;

import java.util.Scanner;

public class Quiz06_10
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		int sum = 0;
		
		while (count < 5)
		{
			System.out.println("정수를 입력하세요.");
			int num = sc.nextInt();
			
			if (num < 1)
			{
				System.out.println("1이상의 정수를 입력하세요");
				continue;
			}
			sum += num;
			count++;
		}
		System.out.println("입력받은 정수의 합은 =" + sum);
	}
}
