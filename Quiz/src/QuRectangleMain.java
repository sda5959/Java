
//직사각형을 표현한 클래스
class Rectangle
{
	//멤버변수
    private int width;//가로
    private int height;//세로
    //생성자
    public Rectangle(int width, int height) {
    	this.width = width;
    	this.height = height;
    }
    //멤버메서드 : 넓이를 출력
    public void showAreaInfo() {
    	System.out.println("직사각형의 넓이:"+ (width*height));
    }
    /*
    getter메서드 : 멤버변수가 private으로 선언되는 경우 외부클래스에서는
   	접근이 불가능하므로, getter를 통해 값을 반환받아야 한다. 
     */    
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
} 
//정사각형을 표현한 클래스(정사각형은 직사각형의 일종)
class Square extends Rectangle
{
    /*
   	멤버변수의 확장이 필요없다. 동일한 사각형이므로 가로, 세로 
   	이외에 다른 변수를 필요로 하지 않기 때문이다.  
     */
	
	//생성자
	/*
	정사각형은 직사각형의 일종이다. 정사각형은 가로, 세로 길이가
	동일하므로 하나의 값으로 두개의 멤버변수를 초기화하면 된다.
	즉 하나의 매개변수로 두개의 멤머변수를 초기화한다.  
	 */
	public Square(int x) {
		super(x, x);
	}
	/*
	부모의 멤버메서드를 오버라이딩 하여 재정의 하였다. 
	부모는 직사각형의 넓이를 자식에서는 정사각형의 넓이를 출력한다.
	 */
	@Override
	public void showAreaInfo() {
		//멤버변수에 직접 접근이 가능할때의 코드(권장사항 아님)
//		System.out.println("정사각형의 넓이:"+ (width*height));
		//private으로 선언하여 getter를 통해 접근한다.(권장사항)
		System.out.println("정사각형의 넓이:"+ getWidth()*getHeight());
	}	
} 
class QuRectangleMain {
	
	public static void main(String[] args) {
       	Rectangle rec = new Rectangle(4, 3);
       	rec.showAreaInfo();

 		Square sqr = new Square(7);
       	sqr.showAreaInfo();
 	}
}

