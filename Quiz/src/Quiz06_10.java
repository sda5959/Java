import java.util.Scanner;

public class Quiz06_10
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요.");
		
		int sum = 0;
		int count = 0;
				
		while(count <5)
		{
			int num = sc.nextInt();
			
			if(num > 0)
			{
				sum =  sum + num;
				count++;
			}
			else
			{
			System.out.println("1 미만의 숫자입니다.");
			System.out.println("1 이상의 숫자를 다시 입력하세요.");
			}
		}
		System.out.println("모두 더한수는 ; " + sum);		
	}
}