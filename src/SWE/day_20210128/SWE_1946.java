package SWE.day_20210128;

import java.util.Scanner;

public class SWE_1946 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		
		int testCase=sc.nextInt();
		for(int t=0; t<testCase; t++) {
			int n=sc.nextInt();
			StringBuffer sb=new StringBuffer();
			int[][] arr=new int[n][2];
			int sum=0;
			int count=0;
			for(int i=0; i<n; i++) {
				char alpha = sc.next().charAt(0);
				int num=sc.nextInt();
				for(int j=0; j<num; j++,count++)
				{
					if(count!=0) {
						if(count%10==0) {
							sb.append("\n");
						}
					}
					sb.append(alpha);
					
				}
	
			}
			
				
			System.out.println("#"+(t+1));
			System.out.println(sb);
			
			
			
			
			
		}
	}

}
