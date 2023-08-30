package quiz;

import java.util.Scanner;

public class Quiz06_02
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 :");
		int kor = sc.nextInt();
		
		System.out.print("영어 :");
		int eng = sc.nextInt();
		
		System.out.print("수학 :");
		int math = sc.nextInt();
		
		int result = (kor + eng + math) / 3;
		System.out.println(result);
		
		if (result >=90 && result <=100)
			System.out.println("A학점 입니다");
		
		if (result >=80 && result < 90)
			System.out.println("B학점 입니다");
		
		if (result >=70 && result < 80)
			System.out.println("C학점 입니다");
		
		if (result >=50 && result < 70)
			System.out.println("D학점 입니다");
		
		if (result < 50)
			System.out.println("F학점 입니다");
	}
}
