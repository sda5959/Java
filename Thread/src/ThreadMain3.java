import java.util.Scanner;

public class ThreadMain3
{
	public ThreadMain3() {
		
	}
	
	public void init()
	{
		System.out.println("숫자를 입력해 주세요.");
		Scanner s = new Scanner(System.in);
		String s_num = s.nextLine();
		int n_num = Integer.parseInt(s_num);
		
		try
		{
			Thread tsub = new ThreadSub(n_num);
			tsub.start();
					
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("이름을 입력해주세요.");
		String s_name = s.nextLine();
	}
	public static void main(String[] args)
	{
		ThreadMain3 tm = new ThreadMain3();
		tm.init();
	}
	static class ThreadSub extends Thread
	{
		int nNum;
		
		public ThreadSub(int num)
		{
			this.nNum = num;
		}
		@Override
		public void run() {
			int i = 0;
			while (i < nNum) {
				try {
					Thread.sleep(1000);
					i = i + 1;
					System.out.println("Thread : " + i);
				
			} catch(Exception e) {
				System.out.println("예외:"+e);
				}
			}
		}
	}
}
