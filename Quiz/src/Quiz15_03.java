import java.util.Scanner;

public class Quiz15_03
{
	public static void main(String[] args)
	{
		int[] ar= new int[10];
		Scanner sc = new Scanner(System.in);
				
		System.out.println("정수 10개를 입력하세요.");
		for (int i=0; i<ar.length ; i++)
		{
			ar[i] = sc.nextInt();
		}
		System.out.println("===========================");	

		int addnum = 0;
		System.out.print("짝수 : ");
		for (int i=0; i<ar.length ; i++)
		{
			if (ar[i] % 2 == 0)
			{
				System.out.print(ar[i] + " ");
			}
		}
		System.out.println();
		System.out.println("===========================");	
		
		int evennum = 0;
		System.out.print("홀수 : " );
		for (int i=0; i<ar.length ; i++)
		{
			if (ar[i] % 2 == 1)
			{
				System.out.print(ar[i] + " ");
			}
		}
		System.out.println();
		System.out.println("===========================");	
	}
}
