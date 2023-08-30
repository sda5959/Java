import java.util.Scanner;

public class Quiz06_01
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 두개를 입력하고 엔터를 입력하세요.");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int result = num1 - num2;
		
		if (result > 0)	System.out.println("두수의 차는 " + result);
		else System.out.println("두수의 차는 " + (-1 * result));	
	}
}
