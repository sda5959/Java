import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Book1
{
	Connection con = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	PreparedStatement pstmt4 = null;
	PreparedStatement pstmt5 = null;
	PreparedStatement pstmt6 = null;
	PreparedStatement pstmt7 = null;
	PreparedStatement pstmt8 = null;
	PreparedStatement pstmt9 = null;
	PreparedStatement pstmt10 = null;
	ResultSet rs = null;
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	Scanner sc = new Scanner(System.in);
	
	public void showIdMenu()
	{
		System.out.println("[메뉴 선택]");
		System.out.println("1.로그인");
		System.out.println("2.회원가입");
		System.out.println("9.종료");
		System.out.print("선택 : ");
	}
	
	public static void main(String[] args) {
		Book1 bid = new Book1();
		bid.doIdRun();
	}
	public void connectDB() {
		try 
		{
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"LIBRARY",
					"1234");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void doIdRun() {
		connectDB();	
		int choice;
		while(true) {
			showIdMenu();
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				signIn();
				break;
			case 2:
				signUp();
				break;
			case 3:
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
	public void signIn() {
		
		System.out.print("ID : ");
		String id = sc.nextLine();
		System.out.print("Password : ");
		String pw = sc.nextLine();
		try{	
			String sql = "select * from MEMBER1 where MEMBER_ID = ? and MEMBER_PW = ?";
			
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1, id);
			pstmt1.setString(2, pw);
			rs = pstmt1.executeQuery();
			
			int nResult = 0;
			while(rs.next()) {
				nResult++;
				rs.getString("MEMBER_ID");
				rs.getString("MEMBER_PW");
				System.out.println(rs.getString("name")+"님의 방문을 환영합니다.");
				System.out.println("----------------------------------------");
			}
			if (nResult == 0)
			{
				System.out.println("아이디 또는 패스워드가 다르거나");
				System.out.println("등록되어 있지 않은 계정입니다.");
				System.out.println("----------------------------------------");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("입력에 실패했습니다.");
		}
	}
	public void signUp() {
		
		System.out.print("ID : ");
		String id = sc.nextLine();
			try{	
			String sql = "select * from MEMBER1 where MEMBER_ID = ?";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setString(1, id);
			rs = pstmt2.executeQuery();
			int nResult = 0;
			while(rs.next()) {
				nResult++;
				rs.getString("MEMBER_ID");
				System.out.println(rs.getString("MEMBER_ID")+"는 이미 사용중인 ID입니다.");
				System.out.println("");
			}
			if (nResult == 0)
			{
				System.out.println(id+"는 사용 가능한 ID입니다.");
				System.out.print("Password : ");
				String pw = sc.nextLine();
				System.out.print("성함 : ");
				String name = sc.nextLine();
				try
				{
					String sql2 = "insert into MEMBER1 values(?, ?, ?)";
					pstmt3 = con.prepareStatement(sql2);
					pstmt3.setString(1, id);
					pstmt3.setString(2, pw);
					pstmt3.setString(3, name);
					int updateCount = pstmt3.executeUpdate();
				if(updateCount == 1) {
					System.out.println("회원가입이 정상적으로 처리 되었습니다.");
				}else {
					System.out.println("데이터 입력에 실패했습니다.(#가입오류)");
				}
				
				}catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("데이터 입력에 실패했습니다.(#데이터예외)");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("입력에 실패했습니다.(#3)");
		}	
	}

	public void disconnectDB() {
		try
		{
			if(rs != null) rs.close();
			if(pstmt1 != null) pstmt1.close();
			if(pstmt2 != null) pstmt2.close();
			if(pstmt3 != null) pstmt3.close();
			if(pstmt4 != null) pstmt4.close();
			if(pstmt5 != null) pstmt5.close();
			if(pstmt6 != null) pstmt6.close();
			if(pstmt7 != null) pstmt7.close();
			if(pstmt8 != null) pstmt8.close();
			if(pstmt9 != null) pstmt9.close();
			if(pstmt10 != null) pstmt10.close();

	} catch (Exception e) {}
	}
}
	
