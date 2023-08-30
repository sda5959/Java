package quiz;

import java.util.Scanner;

public class Quiz06_06
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("입력할 정수의 개수를 입력하세요:");
		int count =sc.nextInt();
		
		int sum = 0;
		for (int i = 0; i < count; i++)
		{
			System.out.println("정수를 입력하세요: ");
			int num = sc.nextInt();
			
			sum += num;
		}
			double avg = (double)sum/count;
			System.out.println("입력한 정수들의 평균은=" + avg);
	}
}
