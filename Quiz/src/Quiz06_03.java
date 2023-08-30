import java.util.Scanner;

public class Quiz06_03
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요.");
		int num = sc.nextInt();
		System.out.println("입력 점수 : " + num);
		
		int result = 1;
		while(num > 0)
		{
			result = result * num;
			System.out.print(num);
			num--;
			if(num != 0)
			{
				System.out.print("*");
		    }
		}
		System.out.print(" = " + result);
	}
}
