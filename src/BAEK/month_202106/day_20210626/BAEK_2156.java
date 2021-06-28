package BAEK.month_202106.day_20210626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 다시 풀어보기...
 */
public class BAEK_2156 {
	static int N;
	static int[] dp;
	static int[] grape;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		dp=new int[N+1];
		grape=new int[N+1];
		
		for(int i=1; i<=N; i++) {
			grape[i]=Integer.parseInt(br.readLine());
		}
		dp[1] = grape[1];
		if(N>1) {
			dp[2]=grape[1]+grape[2];
		}
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grape[i], dp[i - 3] + grape[i - 1] + grape[i]));
		}
		System.out.println(dp[N]);
	}

}
