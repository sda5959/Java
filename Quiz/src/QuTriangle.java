class Triangle {
	//멤버변수 : 밑변, 높이
	/*
	멤버변수의 직접적인 접근을 차단하기 위해 private으로 선언하는
	것을 정보은닉(Information hiding)이라고 한다. 
	*/
	private int bottom;
	private int height;
	
	//멤버메서드
	//멤버변수 전체를 초기화한다. 
	public void init(int _bottom, int height) {
		//매개변수와 멤버변수명이 다르므로 this가 없어도 된다.
		bottom = _bottom;
		//this는 멤버변수를 가리키는 키워드이다. 이를 통해 구분한다.
		this.height = height;
	}
	
	//우리가 직접 생성한 setter메서드
//	//밑변을 설정한다. 
//	public void setBottom(int bot) {
//		this.bottom = bot;
//	}
//	//높이를 설정한다. 
//	public void setHeight(int hei) {
//		this.height = hei;
//	}
	//이클립스의 자동 생성 메뉴를 이용하여 작성한 setter 메서드
	public void setBottom(int bottom) {
		this.bottom = bottom;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	/*
	삼각형의 넓이는 밑변*높이*0.5 이므로 계산의 결과가 소수점으로 
	나올 가능성이 있다. 따라서 int보다는 double형으로 설정하는것이
	안전하다.
	 */
	public double getArea() {
		return bottom * height * 0.5;
	}	
}
public class QuTriangle {

	public static void main(String[] args)
	{
		Triangle t = new Triangle();
		
		//멤버변수를 private으로 선언했으므로 직접 접근은 불가능하다.
//		t.bottom = 9999;
//		t.height = 8888;
		
		t.init(10, 17); //밑변10, 높이17로 초기화
		System.out.println("삼각형의 넓이 : " + t.getArea());  
		t.setBottom(50);//밑변 50으로 변경
		t.setHeight(14);//높이 14로 변경
		System.out.println("삼각형의 넓이 : " + t.getArea());
	}

}
