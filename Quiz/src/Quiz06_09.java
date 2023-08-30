import java.util.Scanner;

public class Quiz06_09
{
	// 입력한 정수까지 역순으로 구구단 출력하기
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요. ");
		int num = sc.nextInt();
		System.out.println("===============================");
		
		while(true)
		{
			for (int i =1; i<9 ; i++)
			{
			System.out.println(num + " * " + i + " = " + (num * i));
			}
			System.out.println("===============================");
			num--;
			if ( num-1 == 0)
			{			
				break;
			}
		}
	}
}