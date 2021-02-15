package SWE.month_202101.day_20210128;

import java.util.Scanner;

public class SWE_1948 {
	public static void main(String args[]) {
		int[] month= {31,28,31,30,31,30,31,31,30,31,30,31};
		
		Scanner sc=new Scanner(System.in);
		
		int testCase=sc.nextInt();
		
		for(int t=0; t<testCase; t++) {
			int first=sc.nextInt();
			int firstOfDay=sc.nextInt();
			int second=sc.nextInt();
			int secondOfDay=sc.nextInt();
			int sum=0;
			if(first==second) {
				sum+=secondOfDay-firstOfDay+1;
			}
			else {
			sum+=month[first-1]-firstOfDay;
			for(int i=first; i<second-1; i++) {
				sum+=month[i];
				
			}
			sum+=secondOfDay+1;
			}
			
			System.out.println("#"+(t+1)+" "+sum);
			
			
		}
	}

}
