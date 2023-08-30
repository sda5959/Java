import java.util.Scanner;

public class Quiz02_01
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 두개를 입력하고 엔터를 입력하세요.");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();				
	
		System.out.println(num1 + "+" + num2 + "=" + (num1 + num2));
		System.out.println(num1 + "-" + num2 + "=" + (num1 - num2));
		System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
		System.out.println(num1 + "/" + num2 + "=" + (num1 / num2));
		System.out.println(num1 + "%" + num2 + "=" + (num1 % num2));		
	}
}
