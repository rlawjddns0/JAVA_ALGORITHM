package BAEK.month_202105.day_20210516;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BAEK_14494 {
	static int n,m;
	static int DIV=1000000007;
	static int[] dx= {1,0,1};
	static int[] dy= {0,1,1};
	static int[][] map;
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		n=sc.nextInt();
		m=sc.nextInt();
		dp=new long[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dp[i][j]=-1;
			}
		}
		dp[0][0]=dfs(0,0);
		
		System.out.println(dp[0][0]%DIV);
		
		
		
		
	}
	private static long dfs(int i, int j) {
		if(dp[i][j]!=-1) {
			return dp[i][j]%DIV;
		}
		
		
		if(i==n-1 && j==m-1) {
			return 1;
		}
		dp[i][j]=0;
		
		
		for(int d=0; d<3; d++) {
			int ny=i+dy[d];
			int nx=j+dx[d];
			if(nx<0 || nx>=m || ny<0 || ny>=n)continue;
			dp[i][j]+=dfs(ny,nx);
		}
		
		
		return dp[i][j]%DIV;
		
		
		
		
		
	}

}
