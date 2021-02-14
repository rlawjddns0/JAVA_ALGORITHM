package BAEK.month_202102.day_20210207;

import java.util.Scanner;

public class BACK_2445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		
		int N=sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			for(int j=0; j<(N*2)-i*2;j++) {
				System.out.print(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i=N-1; i>=1; i--) {
			
			
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			for(int j=0; j<(N*2)-i*2;j++) {
				System.out.print(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
			
			
		}
		
		
		
		
		
	}

}
