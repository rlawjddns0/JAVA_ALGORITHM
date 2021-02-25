package BAEK.month_202102.day_20210225;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_2798 {
	static int N;
	static int M;
	static int[] arr;
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		
		solve(new int[3], 0,0);
		System.out.println(max);

	}
	private static void solve(int[] sel, int k, int idx) {
		// TODO Auto-generated method stub
		
		if(k==3) {
			int sum=0;
			for(int i=0; i<sel.length; i++)
			{
				sum+=sel[i];
			}
			if(sum<=M) {
				max=Math.max(sum, max);
			}
			
			return;
		}
		
		for(int i=idx; i<arr.length; i++) {
			sel[k]=arr[i];
			solve(sel,k+1,i+1);
		}
		
		
	}

}
