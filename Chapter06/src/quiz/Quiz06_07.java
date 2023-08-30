package quiz;

public class Quiz06_07{
	
	public static void main(String[] args){
		boolean found = false;
		for (int i = 1; i < 100; i++){
			
			if (i % 7 == 0 && i % 9 == 0){
				if (!found){
					System.out.println(i);
					found = true;
				}
			} else if(i % 7 == 0 || i % 9 == 0) {
				System.out.println(i);
			}
		}
	}
}
