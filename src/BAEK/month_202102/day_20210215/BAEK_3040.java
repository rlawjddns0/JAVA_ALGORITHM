package BAEK.month_202102.day_20210215;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_3040 {
	static int[] arr;
	static StringBuffer sb=new StringBuffer();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		arr=new int[9];
		for(int i=0; i<9; i++) {
			arr[i]=sc.nextInt();
		}
		
		solve(new int[7],0,0);
		System.out.println(sb);
		
	}
	public static void solve(int[]sel , int k, int idx) {
		if(k==sel.length) {
			int sum=0;
			for(int i=0; i<sel.length; i++) {
				sum+=sel[i];
			}
			if(sum==100) {
				for (int i : sel) {
					sb.append(i+"\n");
				}
			}
			//System.out.println(Arrays.toString(sel));
			return;
		}
		
		
		
		for(int i=idx; i<arr.length; i++) {
			sel[k]=arr[i];
			solve(sel,k+1,i+1);
			
		}
		
		
	}

}
