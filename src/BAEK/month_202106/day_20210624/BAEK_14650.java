package BAEK.month_202106.day_20210624;

import java.util.Scanner;

public class BAEK_14650 {
	static int N;
	static int[] arr= {0,1,2};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		
		permutation(new int[N],0);
		
		System.out.println(cnt);
	}
	static int cnt=0;
	private static void permutation(int[] sel,  int k) {
		if(k==N) {
			if(sel[0]==0)return;
			
			StringBuffer sb=new StringBuffer();
			for(int i=0; i<k; i++) {
				sb.append(sel[i]);
			}
			int result=Integer.parseInt(sb.toString());
			if(result%3==0)cnt++;
			
			return;
		}
		
		for(int i=0; i<3; i++) {
			sel[k]=arr[i];
			permutation(sel, k+1);
		}
		
		
		
	}

}
