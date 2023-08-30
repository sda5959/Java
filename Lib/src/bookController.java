import java.util.List;

public class bookController
{
	private BookService bs = new BookService();
	private BookView bv = new BookView();

	// 도서 추가
	public void bookInsert(Book bookAdd)
	{
		int result = bs.bookInsert(bookAdd);

		if (result > 0)
		{
			System.out.println("도서 정보 추가 완료");
		} else
		{
			bv.bookErrorMsg("insert");
		}
	}

	// 도서 전체 조회
	public void bookSelectAll()
	{
		List<Book> bookList = bs.bookSelectAll();

		if (bookList.isEmpty())
		{
			System.out.println("조회 정보가 없습니다.");
		} else
		{
			bv.bookSelectView(bookList);
		}
	}

	// 도서 삭제
	public void bookDelete(int bookId)
	{
		int result = bs.bookDelete(bookId);

		if (result > 0)
		{
			System.out.println("도서 정보 삭제 완료");
		} else
		{
			bv.bookErrorMsg("delete");
		}
	}

	public void bookSelectId(int bookId) {
		Book book = bs.bookSelectId(bookId);
		
		if(book == null) {
				bv.bookErrorMsg("bookId");
		}else {
				bv.bookSelectId(book)
		}

	public void bookSelectTitle(String bookTitle)
	{
		List<Book> bookList = bs.bookSelectTitle(bookTitle);

		if (bookList.isEmpty())
		{
			System.out.println("조회 정보가 없습니다.");
		} else
		{
			bv.bookSelectView(bookList);
		}

	}
}
