package SWE.month_202101.day_20210125;

import java.util.Scanner;

public class SWE_1970 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Won= {50000,10000,5000,1000,500,100,50,10};
		
		Scanner sc=new Scanner(System.in);
		
		int testCase=sc.nextInt();
		for(int t=0; t<testCase; t++) {
			int money=sc.nextInt();
			
			System.out.println("#"+(t+1));
			for(int i=0; i<Won.length; i++)
			{
				int tp=money/Won[i];//
				if(tp==0) {
					System.out.print("0 ");
				}
				else {
					
					
					System.out.print(money/Won[i]+" ");
					money%=Won[i];
				}
				
				
			}
			System.out.println();
			
			
			
		}
		
		
		
		
		
	}

}
