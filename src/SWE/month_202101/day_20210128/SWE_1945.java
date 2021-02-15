package SWE.month_202101.day_20210128;

import java.util.Scanner;

public class SWE_1945 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int[] num= {2,3,5,7,11};
		int testCase=sc.nextInt();
		
		for(int t=0; t<testCase; t++) {
			int n=sc.nextInt();
			int[] arr=new int[5];
			for(int i=4; i>=0; i--) {
				arr[i]=n%num[i];
				n/=num[i];
			}
			
			System.out.print("#"+(t+1)+" ");
			for(int i=0; i<5; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			
			
			
			
			
		}
		
		
	}

}
