
import static book.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Book.model.vo.Book;


public class BookDAO
{
	public List<Book> bookSelectAll(Connection conn) {
		String query = "SELECT * FROM BOOK";
		Statement stmt = null;
		ResultSet rs = null;
		List<Book> bookList = new ArrayList<>(); // 책 전체정보 담기위한 컬렉션
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int bookId = rs.getInt("BOOK_ID");
				String title = rs.getString("TITLE");
				
				
				Book book = new Book(bookId, title);
				
				bookList.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
		}
		
		return bookList;
	}

	// 도서 추가
	public int bookInsert(Connection conn, Book b) {
		String query = "INSERT INTO BOOK ";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getTitle());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int bookDelete(Connection conn, int bookId) {
		String query = "DELETE FROM BOOK "
				     + "WHERE BOOK_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	// 4. 도서 아이디로 조회
	public Book bookSelectId(Connection conn, int bookId) {
		String query = "SELECT * FROM BOOK "
				     + "WHERE BOOK_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				book = new Book(rs.getInt("BOOK_ID"),
								rs.getString("TITLE"));
					
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return book;
	}

	// 5. 도서 제목으로 조회
	public List<Book> bookSelectTitle(Connection conn, String bookTitle) {
		String query = "SELECT * FROM BOOK "
				     + "WHERE TITLE LIKE ('%' || ? || '%')";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Book> listBook = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookTitle);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setbookId(rs.getInt("BOOK_ID"));
				b.setTitle(rs.getString("TITLE"));
				
				
				listBook.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listBook;
	}

}

