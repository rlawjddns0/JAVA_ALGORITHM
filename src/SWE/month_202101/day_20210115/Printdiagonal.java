package SWE.month_202101.day_20210115;

public class Printdiagonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="+++++";
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i==j) {
					System.out.print("#");
				}
				else
					System.out.print("+");
			}
			System.out.println();
		}

	}

}
