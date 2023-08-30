import java.util.Scanner;

public class MyCalculator
{
	// 메뉴를 출력한다.
	public static void showMenu()
	{
		System.out.println("============================");
		System.out.println("메뉴를 선택하세요.숫자를 입력하세요.꼭이요");
		System.out.println("1.더하기");
		System.out.println("2.빼기");
		System.out.println("3.곱하기");
		System.out.println("4.나누기");
		System.out.println("0.끝내기");
		System.out.println("============================");
	}
	
	// 계산 메소드
	public static void addNum(int num1, int num2)
	{
		int result = num1 + num2;
		System.out.printf("%d + %d = %d %n", num1, num2, result);
	}
	
	public static void minusNum(int num1, int num2)
	{
		int result = num1 - num2;
		System.out.printf("%d - %d = %d %n", num1, num2, result);
	}
	
	public static void multiplyNum(int num1, int num2)
	{
		int result = num1 * num2;
		System.out.printf("%d * %d = %d %n", num1, num2, result);
	}
	
	public static void divideNum(int num1, int num2)
	{
		if (num2 == 0)
		{
			System.out.println("0으로 나눌수 없습니다.");
			return;  // if문인 경우 continue 대신 사용.
		}
		int result1 = num1 / num2;
		int result2 = num1 % num2;
		System.out.printf("%d / %d = %d %n", num1, num2, result1);
		System.out.printf("%d %% %d = %d %n", num1, num2, result2);
	}
	
	// 유효성 검사
	public static boolean checkNum(char ch)
	{
		if(ch >= '0' && ch <= '9')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);  // 입력 처리 객체
		
		while (true)
		{
			/*
			while안에 너무 많은 것이 들어오면 안되어서 메뉴를 외부에
			메서드로 만들어서 호출함.
			 */
			showMenu();
			
//			int num = scanner.nextInt();
			// nextLine() 으로 하면 런타임 에러남. 다음줄에 공백을 인식함.
			char myChar = scanner.next().charAt(0);
			if ( !checkNum(myChar) )
			{
				System.out.println("메뉴를 잘못 선택했습니다.");
				continue;
			}
//			int num = (int)myChar;
//			System.out.println(num);
//			int num = Character.getNumericValue(myChar);
			// 자동 형변환으로 정수로 변경
			int num = myChar - '0';
			System.out.println(num);
			if (num == 0)
			{
				break;
			} else
			{
				if (num>4)
				{
					System.out.println("메뉴를 잘못 선택햇습니다.");
					continue;
				}
				
				 System.out.print("첫번째 숫자 : ");
				 int num1 = scanner.nextInt();
				 
				 System.out.print("두번째 숫자 : ");
				 int num2 = scanner.nextInt();
				 
				 if (num==1)
				{
					addNum(num1, num2);
				} else if(num ==2)
				{
					minusNum(num1, num2);
				}else if(num==3)
				{
					multiplyNum(num1, num2);
				}else if (num==4)
				{
					divideNum(num1, num2);
				}
			}
		}
		System.out.println("계산기를 종료합니다.");
	}

}
