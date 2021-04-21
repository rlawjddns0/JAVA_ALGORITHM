package SWE.month_202104.day_20210420;

import java.util.Scanner;

public class SWE_5515 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] month= {31,29,31,30,31,30,31,31,30,31,30,31};
		int[] day= {3,4,5,6,0,1,2};
		int TC=sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			
			int m=sc.nextInt();
			int d=sc.nextInt();
			
			int day_sum=0;
			for(int i=0; i<m-1; i++) {
				day_sum+=month[i];
			}
			
			day_sum+=d;
			
			System.out.println("#"+t+" "+day[day_sum%7]);
			
			
			
		}
		
		
	}

}
