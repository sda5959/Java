
public class Ex09_Order
{
	// 연산자 우선순위
	public static void main(String[] args)
	{
		/*
		println(); : 내용을 출력한 후 자동으로 줄바꿈 처리한다.
		print(); : 출력 후 줄바꿈 처리를 하지 않는다. 만약 줄바꿈이 필요하면
			\n을 추가해야한다. 
		 */
		System.out.println();              // println()을 이용한 줄바꿈
		System.out.println("\n");          // 특수 문자를 이용한 줄바꿈
		System.out.println("-------------------");
		
		int num = 5;
		
		/*
		 print()문에서의 +기호의 역활
		 1.숫자(정수 혹은 실수)끼리는 실제 덧셈 연산을 한다.
		 2.문자열, 숫자, 실수 등 서로 성격이 다른 데이터끼리는 단순
		 	연결하는 기능만 제공한다.
		 */
		/*
		num 변수에는 값이 이미 이진수로 들어 있습니다. ‘\n’은 문자형 
		데이터이기 때문에 2바이트 크기를 가질 것이고 이진수로 변환, 
		즉 인코딩이 됩니다. 그 결과 ‘이진수 + 이진수’ 산술 연산이 
		일어납니다. 크기가 다르니 뒤쪽 값이 2바이트에서 4바이트로 
		형변환이 되고 그 후 산술 연산인 더하기가 실행됩니다. 산술 
		연산의 결과 15가 출력되고 줄바꿈하려는 의도와 달리 줄바꿈이 
		되지 않습니다.
		 */
		// 기본 자료형끼리는 산술 연산. + 먼저 함
		System.out.println(num + '\n'); // \n 아스키코드에서 10 그래서 15
		System.out.println("-------------------");
		 // 결과 '5\n'이다 특수문자(\n)가 있으므로 줄바꿈
		System.out.println(num + "\n"); 
		// 논리연산자인 (3 >= 2)이 먼저 계산됨.
		System.out.println("3 >= 2 : " + (3 >= 2));
		// 비교를 할 수 없고, 다른 동작도 정의되어 있지 않으므로 에러
		// "3>=2 : 3 "으로 두 문자열이 먼저 합해짐. 구래서 안됨.
//		 System.out.println("3 >= 2 : " + 3 >= 2); 
	}
}
