package SWE.month_202106.day_20210601;

import java.util.Scanner;

public class SWE_12004 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int t=1; t<=TC; t++) {
			int n=sc.nextInt();
			boolean check=false;
			for(int i=1; i<=9; i++) {
				for(int j=1; j<=9; j++) {
					if(i*j==n) {
						check=true;
						break;
					}
				}
			}
			
			if(check) {
				System.out.println("#"+t+" "+"Yes");
			}else {
				System.out.println("#"+t+" "+"No");
			}
			
			
		}
	}

}
