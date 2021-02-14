package BACK.month_202102.day_20210207;

import java.util.Arrays;
import java.util.Scanner;

public class BACK_2446 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] arr=new int[N];
		
		int num=1;
		for(int i=0; i<N; i++) {
			arr[i]=num;
			num+=2;
		}
		for(int i=N-1; i>=0; i--) {
			
			for(int j=0; j<(arr[arr.length-1]-arr[i])/2; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<arr[i]; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<(arr[arr.length-1]-arr[i])/2; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<arr[i]; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}

}
