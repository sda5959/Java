import java.util.Scanner;

public class BookMenu
{
	Scanner sc = new Scanner(System.in);
	bookController bc = new bookController();
	
	public void displayBookMenu() {
		while (true) {
			System.out.println("==== 도서 관리 프로그램 ====");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 아이디로 조회");
			System.out.println("3. 도서 목록 전체 조회");
			System.out.println("4. 도서 삭제");
			System.out.println("9. 끝내기");
			System.out.println("================================");
			System.out.print("번호 입력 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			switch (num)
			{		
			case 1 :
					bc.bookInsert(bookAdd());
				break;
			case 2 :
				bc.bookSelectId(bookId());
				break;
			case 3 :
				bc.bookSelectAll();
				break;
			case 4 :
					bc.bookDelete(bookId());
				break;
			case 9 :
					System.out.println("프로그램을 종료합니다.");
				break;
			default:
					System.out.println("번호를 다시 입력해주세요.");
			}
		}
	}
	
	public Book bookAdd() {
		System.out.println("=== 도서 추가 ===");
		System.out.print("도서명 : ");
		String title = sc.nextLine();
		
	}
}
