package book; // 07.프로그램 시작시 연락처 로드하기

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BookMain
{
	static Scanner sc = new Scanner(System.in);
	static Map<String, BookInfo> map = new HashMap<>();


	public static void showMenu()
	{
		System.out.println("[메뉴 선택]");
		System.out.println("1.회원 가입");
		System.out.println("2.책 등록");
		System.out.println("3.책 조회");
		System.out.println("4.낡은 책 버리기");
		System.out.println("9.종료");
		System.out.print("선택 : ");
	}
		public static void addHuman() {
		System.out.print("이름 입력 :");
		String humanname = sc.nextLine();
		System.out.print("아이디 입력 :");
		String nickname = sc.nextLine();		
		System.out.print("전화 번호 입력 : ");
		String PhoneNumber = sc.nextLine();
		
		BookInfo bInfo = new BookInfo();
		
		bInfo.showhumanInfo();

	}
	public static void addBook()
	{
		System.out.print("책 이름 : ");
		String name = sc.nextLine();
		System.out.print("책번호 : ");
		String BookNumber = sc.nextLine();
		System.out.print("권수 : ");
		Integer bookCount = sc.nextInt();

		BookInfo bInfo = new BookInfo();
		 bInfo.showBookInfo();
		map.put(name, bInfo);
	}
	
	public static void selBook()
	{
		System.out.println("----------------------");
		System.out.print("조회할 책 제목입력 : ");
		String name = sc.nextLine();

		BookInfo bInfo = map.get(name);
		if (bInfo != null)
			bInfo.showBookInfo();
		else
			System.out.println("[" + name + "] 데이터가 없습니다.");
	}

	public static void delBook()
	{
		System.out.println("삭제할 책 제목 : ");
		String name = sc.nextLine();

		BookInfo bInfo = map.remove(name); // 삭제
		if (bInfo != null)
		{
			System.out.println("삭제되었습니다.");
			bInfo.showBookInfo();
		} else
		{
			System.out.println("해당 값이 없습니다.");
		}
	}

	public static void main(String[] args)
	{
		readInfo();
		int choice;
		while (true)
		{
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice)
			{
			case 1: addHuman();
				break;
			case 2:
				addBook();
				break;
			case 3:
				selBook();
				break;
			case 4:
				delBook();
				break;
			case 9:
				saveInfo();
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		}
	
	}

	public static void saveInfo()
	// 패기지가 다르면 Object.bin 도 다름 그래서 삭제하고 다시 만들어야 함
	{
		try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("Object.bin")))
		{
			Set<String> ks = map.keySet();
			for (String s : ks)
			{
				BookInfo bInfo = map.get(s);
				oo.writeObject(bInfo);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void readInfo()
	{
		try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("Object.bin")))
		{
			while (true)
			{
				BookInfo bInfo = (BookInfo) oi.readObject();
				if (bInfo == null)
					break;
				map.put(bInfo.name, bInfo);
			}
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			// e.printStackTrace();
		}
	}
	
}
