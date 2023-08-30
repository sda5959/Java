
public class Book
{


	private int bookId;
	private String title;
	
	
	
	public Book() {}

	public Book(int bookId, String title)
	{
		super();
		this.bookId = bookId;
		this.title = title;
		
	}
	
	public int getbookId()
	{
		return bookId;
	}
	
	public void setbookId(int bookId)
	{
		this.bookId = bookId;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	
	@Override
	public String toString()
	{
		return "Book [bookId=" + bookId + ", title=" + title + "]";
	}
}
