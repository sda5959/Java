import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Test {
    static {
	try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException cnfe) {
	    cnfe.printStackTrace();
	}
    }
    Scanner sc = new Scanner(System.in);
    Connection con = null;
    PreparedStatement login = null;
    PreparedStatement allSelect = null;
    PreparedStatement deleteBook = null;
    PreparedStatement insertBook = null;
    PreparedStatement selectBook = null;
    PreparedStatement rentBook = null;
    PreparedStatement findUser = null;
    PreparedStatement returnBook = null;
    PreparedStatement duplicateId = null;
    PreparedStatement insertMember = null;
    PreparedStatement findPw = null;
    PreparedStatement updateQUANT = null;
    PreparedStatement insertRent = null;
    PreparedStatement BlackMem = null;

    ResultSet rs = null;

    public void connectDB() {
	try {
	    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "1234");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public void showIdMenu() {
	System.out.println();
	System.out.println("┌────[메뉴 선택]────┐");
	System.out.println("│1.    로 그 인     │");
	System.out.println("│2.    회원가입     │");
	System.out.println("│3.  비밀번호찾기   │");
	System.out.println("│4.      종료       │");
	System.out.println("└───────────────────┘");
	System.out.print("     선택 : ");
    }

    public void doUserRun() {
	int choice;
	while (true) {
	    showUserMenu();
	    choice = sc.nextInt();
	    sc.nextLine();
	    switch (choice) {
	    case 1:
		selBook();
		break;
	    case 2:
		allBook();
		break;
	    case 3:
		rentBook();
		break;
	    case 4:
		returnBook();
		break;
	    case 5:
		System.out.println("정상 로그아웃 되었습니다.");
		return;
	    default:
		System.out.println("잘못 입력하셨습니다.");
		break;
	    }
	}
    }

    public void doAdminRun() {
	int choice;
	while (true) {
	    showAdminMenu();
	    choice = sc.nextInt();
	    sc.nextLine();
	    switch (choice) {
	    case 1:
		addBook();
		break;
	    case 2:
		selBook();
		break;
	    case 3:
		allBook();
		break;
	    case 4:
		delBook();
		break;
	    case 5:
		System.out.print("관리자 모드를 종료합니다.");
		return;
	    default:
		System.out.println("잘못 입력하셨습니다.");
		break;
	    }
	}
    }

    public void showUserMenu() {
	System.out.println("┌────[메뉴 선택]────┐");
	System.out.println("│1.    도서조회     │");
	System.out.println("│2.    전체조회     │");
	System.out.println("│3.      대여       │");
	System.out.println("│4.      반납       │");
	System.out.println("│5.    로그아웃     │");
	System.out.println("└───────────────────┘");
	System.out.print("     선택 : ");
    }

    public void showAdminMenu() {
	System.out.println("┌────[메뉴 선택]────┐");
	System.out.println("│1.    책 등록      │");
	System.out.println("│2.    도서조회     │");
	System.out.println("│3.전체 리스트 조회 │");
	System.out.println("│4. 낡은 책 버리기  │");
	System.out.println("│5.관리자 모드 종료 │");
	System.out.println("└───────────────────┘");
	System.out.print("     선택 : ");
    }

    public void signIn() {

	System.out.print("ID : ");
	String id = sc.nextLine();
	System.out.print("Password : ");
	String pw = sc.nextLine();
	try {
	    String sql = "SELECT * FROM MEMBER1 WHERE MEMBER_ID = ? AND MEMBER_PW = ?";

	    login = con.prepareStatement(sql);
	    login.setString(1, id);
	    login.setString(2, pw);
	    rs = login.executeQuery();

	    int nResult = 0;
	    while (rs.next()) {
		nResult++;
		rs.getString("MEMBER_ID");
		rs.getString("MEMBER_PW");
		System.out.println(rs.getString("NAME") + "님의 방문을 환영합니다.");
		if (rs.getString("ADMIN").equals("Y")) {
		    doAdminRun();
		} else {
		    doUserRun();
		}
		System.out.println("----------------------------------------");
	    }
	    if (nResult == 0) {
		System.out.println("아이디 또는 패스워드가 다르거나");
		System.out.println("등록되어 있지 않은 계정입니다.");
		System.out.println("----------------------------------------");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("입력에 실패했습니다.");
	}
    }

    public void delBook() {
	System.out.print("삭제할 책 제목 : ");
	String bookName = sc.nextLine();
	try {
	    // 유효성 검사: 입력값이 null 또는 빈 문자열인 경우 처리
	    if (bookName == null || bookName.trim().isEmpty()) {
		System.out.println("책 제목을 입력해주세요.");
		return;
	    }

	    String sql = "DELETE FROM BOOK WHERE TITLE = ?";
	    deleteBook = con.prepareStatement(sql);
	    deleteBook.setString(1, bookName);

	    // 권한 및 접근 제어: 필요한 권한과 접근 제어를 수행
	    // 예시로 모든 사용자가 삭제 작업을 수행할 수 있도록 설정되어 있다고 가정
	    int updateQUANT = deleteBook.executeUpdate();
	    if (updateQUANT > 0) {
		System.out.println("삭제되었습니다.");
	    } else {
		System.out.println("해당 책이 존재하지 않습니다.");
	    }

	} catch (Exception e) {
	    System.out.println("삭제 에러입니다.");
	}
    }

    public void addBook() {
	System.out.print("제목 : ");
	String bookName = sc.nextLine();
	System.out.print("권수 : ");
	String randomString = generateRandomString();
	int quant = sc.nextInt();
	if (quant == 0)
	    quant = 0;
	try {
	    String sql = "INSERT INTO BOOK VALUES(?, ?, ?)";
	    insertBook = con.prepareStatement(sql);
	    insertBook.setString(1, randomString);
	    insertBook.setString(2, bookName);
	    insertBook.setInt(3, quant);
	    int updateQUANT = insertBook.executeUpdate();
	    if (updateQUANT == 1) {
		System.out.println("데이터가 정상적으로 추가되었습니다.");
	    } else {
		System.out.println("데이터 입력에 실패했습니다.");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("데이터 입력에 실패했습니다.(#데이터예외)");
	}
    }

    public void selBook() {
	System.out.print("조회할 책 제목 : ");
	String bookName = sc.nextLine();
	try {
	    String sql = "SELECT * FROM BOOK WHERE TITLE = ?";
	    selectBook = con.prepareStatement(sql);
	    selectBook.setString(1, bookName);
	    rs = selectBook.executeQuery();
	    int nResult = 0;
	    while (rs.next()) {
		nResult++;
		System.out.println("책ID : " + rs.getString("BOOK_ID"));
		System.out.println("제  목 : " + rs.getString("TITLE"));
		System.out.println("수  량 : " + rs.getInt("QUANT"));
		System.out.println("----------------------------------------");
	    }
	    if (nResult == 0) {
		System.out.println("조회할 데이터가 없습니다.");
		System.out.println("----------------------------------------");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("데이터 입력에 실패했습니다.(#3)");
	}
    }

    public void allBook() {
	try {
	    String sql = "SELECT * FROM BOOK ORDER BY QUANT";
	    allSelect = con.prepareStatement(sql);
	    rs = allSelect.executeQuery();

	    while (rs.next()) {
		System.out.println("책번호 : " + rs.getString("BOOK_ID"));
		System.out.println("제  목 : " + rs.getString("TITLE"));
		System.out.println("수  량 : " + rs.getInt("QUANT"));
		System.out.println("----------------------------------------");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    

    // pstmt9
    public void rentBook() {
	System.out.print("본인확인을 위해 핸드폰번호를 입력해주세요 : ");
	String pn = sc.nextLine();

	try {
	    String sql = "SELECT * FROM MEMBER1 WHERE MEMBER_PN = ?";
	    rentBook = con.prepareStatement(sql);
	    rentBook.setString(1, pn);
	    rs = rentBook.executeQuery();
	    int nResult = 0;
	    while (rs.next()) {
		nResult++;
		String id = rs.getString("MEMBER_ID");
		LocalDate sysdate = LocalDate.now();
		LocalDate rentdate = sysdate;
		LocalDate backdate = sysdate.plusWeeks(1);
		System.out.print("대여할 도서의 번호를 입력하세요: ");
		String bookId = sc.nextLine();
		String randomString = generateRandomString();

		try {
		    // 도서번호가 존재하는지 확인하는 쿼리 추가
		    String sql2 = "SELECT * FROM BOOK WHERE BOOK_ID = ?";
		    rentBook = con.prepareStatement(sql2);
		    rentBook.setString(1, bookId);
		    rs = rentBook.executeQuery();
		    if (rs.next()) {
			if (rs.getInt("QUANT") == 0) {
			    System.out.println("품절");
			} else {
			    int QUANT = rs.getInt("QUANT");
			    String sql3 = "UPDATE BOOK SET QUANT = ? WHERE BOOK_ID = ?";
			    updateQUANT = con.prepareStatement(sql3);

			    updateQUANT.setInt(1, QUANT - 1);
			    updateQUANT.setString(2, bookId);
			    updateQUANT.executeUpdate(); // 변경 내용을 데이터베이스에 적용

			    String sql4 = "INSERT INTO LENT VALUES(?, ?, ?, ?, ?)";

			    insertRent = con.prepareStatement(sql4);
			    insertRent.setString(1, randomString);
			    insertRent.setString(2, bookId);
			    insertRent.setString(3, id);
			    insertRent.setDate(4, java.sql.Date.valueOf(rentdate));
			    insertRent.setDate(5, java.sql.Date.valueOf(backdate));
			    insertRent.executeUpdate(); // 변경 내용을 데이터베이스에 적용
			    System.out.println();

			    System.out.println("대여가 정상적으로 완료되었습니다");

			}
		    } else {
			System.out.println("해당 도서번호가 존재하지 않습니다.");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    System.out.println("입력에 실패했습니다.(#4)");
		}
	    }
	    if (nResult == 0) {
		System.out.println("회원 정보가 일치하지 않습니다.");
	    }
	} catch (Exception e) {
	    System.out.println("입력에 실패했습니다.(#3)");
	    e.printStackTrace();
	}
    }

    public void returnBook() {
	    System.out.print("본인확인을 위해 핸드폰번호를 입력해주세요 : ");
	    String pn = sc.nextLine();

	    try {
	        String sql = "SELECT * FROM MEMBER1 WHERE MEMBER_PN = ?";
	        findUser = con.prepareStatement(sql);
	        findUser.setString(1, pn);
	        rs = findUser.executeQuery();
	        int nResult = 0;
	        while (rs.next()) {
	            nResult++;
	            String id = rs.getString("MEMBER_ID");

	            System.out.print("반납할 책 번호 입력하세요: ");
	            String bookNum = sc.nextLine();

	            // 반납할 책 번호 조회
	            sql = "SELECT * FROM LENT WHERE BOOK_ID = ? AND MEMBER_ID = ?";
	            PreparedStatement findLent = con.prepareStatement(sql);
	            findLent.setString(1, bookNum);
	            findLent.setString(2, id);
	            ResultSet bookResultSet = findLent.executeQuery();

	            if (bookResultSet.next()) {
	                String sql2 = "SELECT * FROM BOOK WHERE BOOK_ID = ?";
	                PreparedStatement findBook = con.prepareStatement(sql2);
	                findBook.setString(1, bookNum);
	                ResultSet findBookSet = findBook.executeQuery();

	                if (findBookSet.next()) {
	                    int QUANT = findBookSet.getInt("QUANT");

	                    // 반납 처리
	                    String sql3 = "UPDATE BOOK SET QUANT = ? WHERE BOOK_ID = ?";
	                    updateQUANT = con.prepareStatement(sql3);
	                    updateQUANT.setInt(1, QUANT + 1);
	                    updateQUANT.setString(2, bookNum);
	                    updateQUANT.executeUpdate(); // 변경 내용을 데이터베이스에 적용

	                    LocalDate backdate = bookResultSet.getDate("RETURN_DATE").toLocalDate();
	                    LocalDate currentDate = LocalDate.now();

	                    // Check if the book is returned late
	                    if (currentDate.isAfter(backdate)) {
	                        // Perform blacklisting
	                        String sql4 = "UPDATE MEMBER1 SET BLACKLISTED = 1 WHERE MEMBER_ID = ?";
	                        PreparedStatement blacklistUser = con.prepareStatement(sql4);
	                        blacklistUser.setString(1, id);
	                        blacklistUser.executeUpdate();

	                        System.out.println("반납이 정상처리 되었습니다. 도서 반납이 지연되어 블랙리스트 처리되었습니다.");
	                    } else {
	                        String sql4 = "DELETE FROM LENT WHERE BOOK_ID = ? AND MEMBER_ID = ?";
	                        PreparedStatement deleteLENT = con.prepareStatement(sql4);
	                        deleteLENT.setString(1, bookNum);
	                        deleteLENT.setString(2, id);
	                        deleteLENT.executeUpdate();

	                        System.out.println("반납이 정상처리 되었습니다.");
	                    }

	                    // Delete the record from LENT table
	                    String deleteRecordSql = "DELETE FROM LENT WHERE BOOK_ID = ? AND MEMBER_ID = ?";
	                    PreparedStatement deleteRecordStmt = con.prepareStatement(deleteRecordSql);
	                    deleteRecordStmt.setString(1, bookNum);
	                    deleteRecordStmt.setString(2, id);
	                    deleteRecordStmt.executeUpdate();
	                } else {
	                    System.out.println("반납할 책 번호가 유효하지 않습니다.");
	                }
	            } else {
	                System.out.println("대여 기록이 없는 도서입니다.");
	            }
	        }

	        if (nResult == 0) {
	            System.out.println("비밀번호가 일치하는 회원이 없습니다.");
	        }

	    } catch (Exception e) {
	        System.out.println("입력에 실패했습니다.(#3)");
	        e.printStackTrace();
	    }
	}    
    
    	public void signUp() {
	
	System.out.print("ID : ");
	String id = sc.nextLine();
	try {
	    String sql = "SELECT * FROM MEMBER1 WHERE MEMBER_ID = ?";
	    duplicateId = con.prepareStatement(sql);
	    duplicateId.setString(1, id);
	    rs = duplicateId.executeQuery();
	    int nResult = 0;
	    while (rs.next()) {
		nResult++;
		rs.getString("MEMBER_ID");
		System.out.println(rs.getString("MEMBER_ID") + "는 이미 사용중인 ID입니다.");
		System.out.println("");
	    }
	    if (nResult == 0) {
		System.out.println(id + "는 사용 가능한 ID입니다.");
		System.out.print("Password : ");
		String pw = sc.nextLine();
		System.out.print("성함 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰번호 : ");
		String pn = sc.nextLine();
		try {
		    String sql2 = "INSERT INTO MEMBER1 VALUES(?, ?, ?, ?, ?, ?)";
		    insertMember = con.prepareStatement(sql2);
		    insertMember.setString(1, id);
		    insertMember.setString(2, pw);
		    insertMember.setString(3, name);
		    insertMember.setString(4, pn);
		    insertMember.setString(5, "N");
		    insertMember.setString(6, "");
		    int updateQUANT = insertMember.executeUpdate();
		    if (updateQUANT == 1) {
			System.out.println("회원가입이 정상적으로 처리 되었습니다.");
		    } else {
			System.out.println("데이터 입력에 실패했습니다.(#가입오류)");
		    }
		    // System.out.println("insertQUANT : " + updateQUANT);

		} catch (Exception e) {
		    e.printStackTrace();
		    System.out.println("데이터 입력에 실패했습니다.(#데이터예외)");
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("입력에 실패했습니다.(#3)");
	}
    }

    public void findPw() {
	System.out.print("비밀번호 조회할 아이디를 입력하세요 : ");
	String id = sc.nextLine();
	System.out.print("본인의 성함을 입력하세요 : ");
	String name = sc.nextLine();
	try {
	    String sql = "SELECT * FROM MEMBER1 WHERE MEMBER_ID = ? AND NAME = ?";
	    findPw = con.prepareStatement(sql);
	    findPw.setString(1, id);
	    findPw.setString(2, name);
	    rs = findPw.executeQuery();
	    int nResult = 0;
	    while (rs.next()) {
		nResult++;
		rs.getString("MEMBER_ID");
		rs.getString("MEMBER_PW");
		System.out.println(rs.getString("NAME") + "님의 비밀번호는 " + rs.getString("MEMBER_PW") + " 입니다.");
	    }
	    if (nResult == 0) {
		System.out.println("입력된 정보가 다르거나");
		System.out.println("등록되어 있지 않은 계정입니다.");
		System.out.println("----------------------------------------");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    System.out.println("입력에 실패했습니다.(#3)");
	}
    }

    public void doIdRun() {
	connectDB();
	int choice;
	while (true) {
	    showIdMenu();
	    choice = sc.nextInt();
	    sc.nextLine();
	    switch (choice) {
	    case 1:
		signIn();
		break;
	    case 2:
		signUp();
		break;
	    case 3:
		findPw();
		break;
	    case 4:
		disconnectDB();
		System.out.println("프로그램을 종료합니다.");
		System.out.println("이용해주셔서 감사합니다.");
		return;
	    default:
		System.out.println("잘못 입력하셨습니다.");
		break;
	    }
	}
    }

    public void disconnectDB() {
	try {
	    if (rs != null)
		rs.close();
	    if (login != null)
		login.close();
	    if (allSelect != null)
		allSelect.close();
	    if (deleteBook != null)
		deleteBook.close();
	    if (deleteBook != null)
		deleteBook.close();
	    if (insertBook != null)
		insertBook.close();
	    if (selectBook != null)
		selectBook.close();
	    if (rentBook != null)
		rentBook.close();
	    if (findUser != null)
		findUser.close();
	    if (returnBook != null)
		returnBook.close();
	    if (duplicateId != null)
		duplicateId.close();
	    if (insertMember != null)
		insertMember.close();
	    if (findPw != null)
		findPw.close();

	    if (con != null)
		con.close();
	} catch (Exception e) {

	}
    }

    public static String generateRandomString() {
	int length = 6;
	String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	StringBuilder sb = new StringBuilder();

	Random random = new Random();
	for (int i = 0; i < length; i++) {
	    int index = random.nextInt(characters.length());
	    char randomChar = characters.charAt(index);
	    sb.append(randomChar);
	}

	return sb.toString();
    }

    public static void main(String[] args) {
	Test test = new Test();
	test.doIdRun();
    }

}
