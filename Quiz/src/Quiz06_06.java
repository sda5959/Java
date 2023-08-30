import java.util.Scanner;

public class Quiz06_06
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int inNum = sc.nextInt();
		System.out.println("몇 개의 정수를 입력할지 숫자를 입력하세요.");
		
		int count =0;		
		int result = 0;
		while(true)
		{
			count++;
			Scanner nenum = new Scanner(System.in);
			
			System.out.println("정수를 입력하세요.");
			int num = nenum.nextInt();
			result = result + num;
			if(inNum == count)
			{
				break;
			}			
		}
		System.out.println("입력한 값의 합은 " + result);
		double avge = result / (double)inNum;
		System.out.printf("입력한 값의 모든 합의 평균은? %.2f" ,avge);		
	}
}
