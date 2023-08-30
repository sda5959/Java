public class Quiz06_04
{
	public static void main(String[] args)
	{
		int num = 0;
		int result = 0;
		
		do
		{
			num++;
			System.out.print(num);
			result = result + num;
			if(num < 1000)
			{
				System.out.print("+");
			}
		} while(num != 1000);
		System.out.print(" = " + result);
	}
}
