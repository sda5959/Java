import java.util.Scanner;

public class Quiz02_02
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("하나의 정수를 입력하고 엔터를 입력하세요.");
		int num = sc.nextInt();
		
	    System.out.println("입력한 " + num + "의 제곱은"  + (num * num));
	}
}
