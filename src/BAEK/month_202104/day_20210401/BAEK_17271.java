package BAEK.month_202104.day_20210401;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_17271 {
	static long[] dp;
	static int div=1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp=new long[10001];
		dp[1]=1;
		
		Arrays.fill(dp, -1);
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();//총 시간
		int M=sc.nextInt();//B의 시간
		
		
		for(int i=1; i<M; i++) {//M 이하일때는 무조건 1개
			dp[i]=1;
		}
		dp[M]=2;//딱 M초 일때는 2개
		for(int i=M+1; i<=N; i++) {
			if(dp[i-1]>=div)dp[i-1]%=div;
			if(dp[i-M]>=div)dp[i-M]%=div;
			dp[i]=dp[i-1]+(dp[i-M]);//1시간 동안 지지고 볶았더니 나옴
			if(dp[i]>=div) {
				dp[i]%=div;
			}
		}
		
		System.out.println(dp[N]);
		
		
		
		
	}

}
