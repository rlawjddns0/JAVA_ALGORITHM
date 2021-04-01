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
		int N=sc.nextInt();//�� �ð�
		int M=sc.nextInt();//B�� �ð�
		
		
		for(int i=1; i<M; i++) {//M �����϶��� ������ 1��
			dp[i]=1;
		}
		dp[M]=2;//�� M�� �϶��� 2��
		for(int i=M+1; i<=N; i++) {
			if(dp[i-1]>=div)dp[i-1]%=div;
			if(dp[i-M]>=div)dp[i-M]%=div;
			dp[i]=dp[i-1]+(dp[i-M]);//1�ð� ���� ������ ���Ҵ��� ����
			if(dp[i]>=div) {
				dp[i]%=div;
			}
		}
		
		System.out.println(dp[N]);
		
		
		
		
	}

}
