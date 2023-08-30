import java.util.List;

public class BookView
{
	public void bookErrorMsg(String msg) {
		switch(msg) {
		case "insert" :
			System.out.println("도서 정보 추가 실패");
			break;
		case "delete" :
			System.out.println("도서 정보 삭제 실패");
			break;
		case "bookId" :
			System.out.println("도서 검색 아이디 찾기 실패");
			break;
		default :
			System.out.println("오류를 찾을수 없음");
		}
		
	}
	
	public void bookSelectView(List<Book> bookList) {
		System.out.println("=== 도서 전체 목록 조회 ===");
		for(Book book : bookList) {
			System.out.println(book);
		}
	}
	
	public void bookSelectId(Book b) {
		System.out.println("=== 도서 조회 ===");
		System.out.println(b);
	}
	
	
}
