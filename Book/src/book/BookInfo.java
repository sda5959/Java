package book;

public class BookInfo implements java.io.Serializable 
// implements java.io.Serializable 저장을 위해 입력 해야함 없으면 save 안됨 
{
	String name;
	String bookNumber;
	Integer bookCount;
	String humanname;
	String PhoneNumber;
	String nickname;
	
	public BookInfo() {}
	
	public BookInfo(String name,Integer bookCount, String bookNumber,
			String humanname, String nickname, String PhoneNumber)
	{
		this.name = name;
		this.bookNumber = bookNumber;
		this.bookCount = bookCount;
		this.humanname = humanname;
		this.PhoneNumber = PhoneNumber;
	}
	
	public void showBookInfo()
	{
		System.out.println("Name : " + name);
		System.out.println("bookNumber : " + bookNumber);
		System.out.println("bookCount : " + bookCount);
		System.out.println("------------------------");
	}
	public void showhumanInfo()
	{
		System.out.println("Name : " + humanname);
		System.out.println("NickName : "+ nickname);
		System.out.println("PhoneNumber : " + PhoneNumber);
		System.out.println("------------------------");
	}
}

