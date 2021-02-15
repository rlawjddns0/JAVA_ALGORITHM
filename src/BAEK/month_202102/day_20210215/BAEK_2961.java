package BAEK.month_202102.day_20210215;

import java.util.Scanner;

public class BAEK_2961 {
	static int N;
	static food[] f;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		f=new food[N];
		int S=0,B=0;
		for(int i=0; i<N; i++) {
			S=sc.nextInt();
			B=sc.nextInt();
			f[i]=new food(S,B);
		}
		
		solve(0,0 ,new boolean[N]);
		System.out.println(min);
	}
	public static void solve(int idx,int k, boolean[] v) {
		
		if(idx==N ) {
			if(k>0) {//1∞≥ ¿ÃªÛ
				int sumS = 1;
				int sumB = 0;
				for (int i = 0; i < N; i++) {
					if (v[i] == true) {
						sumS *= f[i].S;
						sumB += f[i].B;
					}
				}
				min=Math.min(Math.abs(sumS-sumB), min);
			}
			return;
		}
		
		
		
		v[idx]=true;
		solve(idx+1,k+1,v);
		v[idx]=false;
		solve(idx+1,k,v);
	
		
	}

}
class food {
		int  S;//Ω≈∏¿
		int B;//æ¥∏¿
		food(int S, int B){
			this.S=S;
			this.B=B;
		}
		
	}