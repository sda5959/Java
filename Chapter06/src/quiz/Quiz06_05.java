package quiz;

import java.util.Scanner;

public class Quiz06_05
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int num;
		
		do
		{
			System.out.print("정수를 입력하세요(0입력시 종료):");
			num = sc.nextInt();
			sum += num;
			
		} 
		while (num != 0);
		System.out.println("입력한 숫자의 합:" + sum);
	}
}
