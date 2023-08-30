import java.util.Scanner;

public class Quiz06_05
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int result = 0;
		
		while(true)
		{
			System.out.println("정수를 입력하세요.");
			int num = sc.nextInt();
						
			if(num == 0)
			{
				break;
			}
			result = result + num;
		}		
		System.out.println("입력한 값의 모든 합은 : " + result);
	}
}
