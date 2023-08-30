/*
문제1) 파일명 : QuSimpleCalculator.java (난이도:하)
기본 4칙연산을 할때마다 연산의 결과와 몇번 수행되었는지를 출력하는 
계산기 클래스를 정의해보자.
아래 main함수에 부합하는 CalculatorEx 클래스를 정의하면되고 해당 
수치는 임의로 바꿔도 된다. init() 멤버메소드에서는 계산의 결과를 
카운트하는 멤버변수를 0으로 초기화 한다.
*/
class CalculatorEx {	
	//멤버변수 : 계산의 결과를 카운트한다.
	int addCount;
	int minCount;
	int mulCount;
	int divCount;
	  
	//연산의 횟수를 카운트 하는 변수를 초기화한다.
	public void init() {
		addCount = 0;
		minCount = 0;
		mulCount = 0;
		divCount = 0;
	}
	/*
	연산의 횟수를 카운트 한 후 연산의 결과를 변수에 저장한 후
	반환한다.
	 */
	public double add(double number1, double number2) {
		addCount++;
		double result = number1 + number2;
		return result;
	}
	public double min(double number1, double number2) {
		minCount++;
		double result = number1 - number2;
		return result;	
	}
	/*
	연산의 횟수를 카운트한 후 계산결과를 즉시 반환한다. 
	 */
	public double mul(double number1, double number2) {
		mulCount++;
		return number1 * number2;
	}
	public double div(double number1, double number2) {
		divCount++;
		return number1 / number2;
	}
	//연산의 횟수를 출력한다.
	public void showOpCount() {
		System.out.println("덧셈횟수:"+ addCount);
		System.out.println("뺄셈횟수:"+ minCount);
		System.out.println("곱셈횟수:"+ mulCount);
		System.out.println("나눗셈횟수:"+ divCount);
	}
}
public class QuSimpleCalculator {

	public static void main(String[] args)
	{
		CalculatorEx cal = new CalculatorEx();
		cal.init();
		System.out.println("1 + 2 = " + cal.add(1 , 2));
		System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
		System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
		System.out.println("100 / 25 = " + cal.div(100 , 25));
		System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
		cal.showOpCount();
	}
}
