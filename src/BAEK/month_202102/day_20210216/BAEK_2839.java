package BAEK.month_202102.day_20210216;

import java.util.Scanner;

public class BAEK_2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		int three=0;
		int five=0;
		
		
		five=N/5;
		N=N%5;
		
		
		while(five>=0) {
			
			if((N%3)==0) {
				three=N/3;
				N%=3;
				break;
			}
			five--;
			N+=5;
		}
		
		if(N!=0) {
			System.out.println("-1");
		}
		else
			System.out.println(three+five);
		
	}

}
