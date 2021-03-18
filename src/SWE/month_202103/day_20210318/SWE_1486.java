package SWE.month_202103.day_20210318;

import java.util.Scanner;

public class SWE_1486 {
	static int N,B;//N명의 점원 B이상인 탑
	static int[] emp;
	static boolean[] v;
	static int min;
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			N=sc.nextInt();
			B=sc.nextInt();
			emp=new int[N];
			v=new boolean[N];
			for(int i=0;i<N; i++) {
				emp[i]=sc.nextInt();
			}
			min=Integer.MAX_VALUE;
			solve(0,v);
			System.out.println("#"+t+" "+(min-B));
			
			
		}
	}
	private static void solve(int k, boolean[] v) {
		
		if(k==v.length) {
			int sum=0;
			for(int i=0; i<N; i++) {
				if(v[i]) {
					sum+=emp[i];
				}
				
			}
			
			if(sum<B)return;
			//System.out.println(sum);
			min=Math.min(sum, min);
			return;
			
		}
		
		v[k]=true;
		solve(k+1,v);
		v[k]=false;
		solve(k+1,v);
		
		
		
	}

}
