public class Quiz06_07
{
	public static void main(String[] args)
	{
		for(int i=1; i<100; i++)
		{
			if((i % 7) == 0 || (i % 9) == 0)
			{
				System.out.print(i + " ");
			}			
		}
	}
}
//
//int num = 0;
//int count = 0;

//do
//{
//	num++;
//	
//	if( (num % 7) != 0 )
//		continue;
//	if( (num % 9) != 0 )
//		continue;
//	
//	                 
//	System.out.println(num);   // 7와 9의 배수인 경우에만 실행
//} while(num < 100);
//
