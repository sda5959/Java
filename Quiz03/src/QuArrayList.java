import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;
class Student implements Comparable<Student>
{
	private String name;
	private int age;
	private String yob;

	public Student(String name, int age , String yob)
	{
		this.name = name;
		this.age = age;
		this.yob = yob;
	}
	public String toString()  
	{
		return name + ":" + ":" + age + ":" + yob;
	}
	public int compareTo(Student p) 
	{
		return this.name.compareTo(p.name);  
	}
	public class QuArrayList
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요 : " + sc);
		
		
		
		//ArrayList<Student> list = new ArrayList<Student>();
		LinkedList<Student> list = new LinkedList<Student>();
		
		//저장할 객체 생성
		Student st1 = new Student("가길동", 10, "2018");
		Student st2 = new Student("나길동", 20, "2017");
		Student st3 = new Student("다길동", 30, "2016");
		Student st4 = new Student("마길동", 40, "2015");
		
		//객체 추가(컬렉션에 저장)
		list.add(st1);
		list.add(st2);
		list.add(st3);
		list.add(st4);
		
		
		list.remove(sc);
		
		String [] arr = {"st1", "st2", "st3", "st4"};
		System.out.println(Arrays.asList(arr).indexOf("st1"));
	}
	}
}
