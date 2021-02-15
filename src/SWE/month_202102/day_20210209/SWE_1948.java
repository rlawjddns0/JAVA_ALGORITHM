package SWE.month_202102.day_20210209;

import java.util.Scanner;

public class SWE_1948 {
	static int[] month= {0,31,28,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		int testCase=sc.nextInt();
		for(int t=1; t<=testCase; t++) {
			int pMonth=sc.nextInt();
			int pDay=sc.nextInt();
			int nMonth=sc.nextInt();
			int nDay=sc.nextInt();
			
			if(pMonth==nMonth) {
				System.out.println("#"+t+" "+(nDay-pDay+1));
				continue;
			}
			
			int sum=0;
			for(int i=pMonth; i<nMonth; i++) {
				sum+=month[i];
			}
			sum-=pDay;
			sum+=nDay;
			
			System.out.println("#"+t+" "+(sum+1));
		}

	}

}
