
//점을 표현한 클래스
class Point {
	//2개의 좌표를 통해 하나의 점을 표현한다. 
   	int xDot, yDot;
   	//생성자에서 멤버변수 초기화
   	public Point(int x, int y) {
 		xDot=x;
 		yDot=y;
   	}
   	//좌표값을 표현하는 멤버메서드
   	public void showPointInfo() {
        System.out.println("[x좌표:"+xDot+", y좌표"+yDot+"]");
   	}
}
//Point클래스를 기반으로 원(Circle) 클래스 표현하기
class Circle{	
	//멤버변수
	int radian;//반지름
	Point center;
	//생성자
	public Circle(int radian, int x, int y) {
		//멤버변수 반지름 초기화
		this.radian = radian;
		/*
		상속관계라면 super()가 필요하겠지만, 구성관계이므로 Point형
		객체 생성이 필요하다. 매개변수 x,y를 통해 생성하면된다.  
		 */
		center = new Point(x, y);
	}
	
	//멤버메서드
	public void showCircleInfo() {
		//포인트 정보를 먼저 출력한다. 
		center.showPointInfo();
		//반지름 정보 출력
		System.out.println("반지름:"+ this.radian);
	}
}
//원 2개를 겹쳐서 링을 표현하는 클래스
class Ring{
	//멤버변수
	Circle innerCircle;//안쪽의 원
	Circle outerCircle;//바깥쪽의 원
	//생성자(링은 2개의 원으로 구성되므로 총 6개의 인수가 필요하다)
	public Ring(int inX, int inY, int inR, int outX, int outY, int outR) {
		innerCircle = new Circle(inR, inX, inY);
		outerCircle = new Circle(outR, outX, outY);
	}
	
	//멤버메서드 : 링의 정보 출력
	public void showRingInfo() {
		System.out.println("안쪽원의정보:");
		innerCircle.showCircleInfo();
		System.out.println("바깥쪽원의정보:");
		outerCircle.showCircleInfo();
	}
}
class QuRingMake {
	public static void main(String[] args) {
		Ring c = new Ring(1,1,3,2,2,9);
		c.showRingInfo();
	}
}

