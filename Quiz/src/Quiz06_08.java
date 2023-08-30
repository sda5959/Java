public class Quiz06_08
{
	// 짝수단만 자신의 수 까지 곱한겂 출력
	
	public static void main(String[] args)
	{
		int num = 0;
		while((num++) < 9)
		{
			if ( (num % 2) == 0)
			{			
				for (int i =1; i<= num; i++)
				{
				System.out.println(num + " * " + i + " = " + (num * i));
				}
				System.out.println("=======================");
			}
		}
	}
}
