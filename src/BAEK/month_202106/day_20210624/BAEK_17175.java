package BAEK.month_202106.day_20210624;

import java.util.Scanner;

public class BAEK_17175 {
	static int n;
	static int[] dp=new int[51];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		
		dp[0]=1;
		dp[1]=1;
		for(int i=2; i<=50; i++) {
			dp[i]=(1+dp[i-2]+dp[i-1])%1000000007; //1(지금 카운트) +dp[i-2](i-2번째 카운트 갯수)+ dp[i-1](i-1번째 카운트 ㄳ수);
		}
		System.out.println(dp[n]);
		
		
	}
	

}
