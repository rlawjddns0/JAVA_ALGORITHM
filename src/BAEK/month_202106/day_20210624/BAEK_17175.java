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
			dp[i]=(1+dp[i-2]+dp[i-1])%1000000007; //1(���� ī��Ʈ) +dp[i-2](i-2��° ī��Ʈ ����)+ dp[i-1](i-1��° ī��Ʈ ����);
		}
		System.out.println(dp[n]);
		
		
	}
	

}
