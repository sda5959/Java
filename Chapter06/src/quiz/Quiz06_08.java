package quiz;

public class Quiz06_08{

	public static void main(String[] args){
		
		for (int dan = 2; dan <= 8; dan+=2)
		{
			System.out.println(dan +"단");
			for (int i = 1; i <= dan; i++)
			{
				System.out.println(dan + "*" + i + "=" + (dan*i));
				if (i == dan*2)
				{
					break;
				}
			}
			System.out.println();
		}
	}
}
