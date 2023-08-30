import java.util.Scanner;

public class Quiz06_02
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 점수를 입력하세요.");
		int num1 = sc.nextInt();
		System.out.println("영어 점수를 입력하세요.");
		int num2 = sc.nextInt();
		System.out.println("수학 점수를 입력하세요.");
		int num3 = sc.nextInt();
		
		double avg = (num1 + num2 + num3) / 3.0;
		
		if (avg >= 90) System.out.printf("당신의 평균 점수는 %.2f 이고 학점은 A 입니다", avg);
		else if (avg >= 80) System.out.printf("당신의 평균 점수는 %.2f 이고 학점은 B 입니다", avg);
		else if (avg >= 70) System.out.printf("당신의 평균 점수는 %.2f 이고 학점은 C 입니다", avg);
		else if (avg >= 50) System.out.printf("당신의 평균 점수는 %.2f 이고 학점은 D 입니다", avg);
		else System.out.printf("당신의 평균 점수는 %.2f 이고 학점은 F 입니다", avg);
	}
}
