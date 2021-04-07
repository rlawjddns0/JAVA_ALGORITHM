package SWE.month_202104.day_20210408;

import java.util.Scanner;

public class SWE_9997 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			double seta=sc.nextInt();
			
			if(seta==360 || seta==0) {
				System.out.println("#"+t+" "+0+" "+0);
				continue;
			}
			double hour=Math.floor(seta/30);
			double min=(seta%30)*2;
			
			
			
			
			System.out.println("#"+t+" "+(int)hour+" "+(int)min);
		}
		
		
	}

}
