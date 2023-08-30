import java.util.Scanner;

public class Quiz15_01
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] ar= new int[5];
		
		System.out.println("정수 5개를 입력하세요.");
		for (int i=0; i<5 ; i++)
		{
			ar[i] = sc.nextInt();
		}
		System.out.println("===========================");
		System.out.println("최대값은 : " + maxNum(ar));
		System.out.println("최소값은 : " + minNum(ar));
		System.out.println("모든수의 합은 : " + sum(ar));
		System.out.println("===========================");
	}
	
	static int maxNum(int[] arr)
	{
		int result = arr[0];
		for(int i=0; i<5 ; i++)
		{
			if(result < arr[i])
				result = arr[i];
		}
		return result;
	}
	
	static int minNum(int[] arr)
	{
		int result = arr[0];
		for(int i=0; i<5; i++)
		{
			if(result > arr[i])
				result = arr[i];
		}
		return result;
	}
	
	static int sum(int[] arr)
	{
		int result = 0;
		for(int i=0; i<5; i++)
		{
			result = result + arr[i];
		}
		return result;
	}
//	
//	public static int big(int[] arr)
//	{
//		int big = arr[0];
//		for(int i=0;i<arr.length;i++)
//		{
//			if(big < arr[i])
//				big = arr[i];
//		}
//		return big;
//	}

}