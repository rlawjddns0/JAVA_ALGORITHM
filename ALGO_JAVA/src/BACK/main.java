package BACK;

import java.util.Scanner;
//BACK_10950
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		int Test_Case_num=0;
		int [][] array;
		Test_Case_num=scanner.nextInt();
		array=new int[Test_Case_num][2];
		for(int i=0; i<Test_Case_num; i++) {
			for(int j=0; j<2; j++) {
				array[i][j]=scanner.nextInt();
			}
		}
		
		for(int i=0; i<Test_Case_num; i++) {
			System.out.println(array[i][0]+ array[i][1]);
		}
		

	}

}
