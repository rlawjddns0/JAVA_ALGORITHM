package BAEK.month_202105.day_20210503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1520 {
	static int M,N;
	static int[][] map;
	static int[][] dp;
	static int ant;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new int[M][N];
		dp=new int[M][N];
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
		
		dfs(0,0);
		System.out.println(dp[0][0]);
	
	
	}
	private static int dfs(int y, int x) {
		
		
		if(y==M-1 && x==N-1) {
			return 1 ;
		
		}
		if(dp[y][x]!=-1) {
			return dp[y][x];
		}
		 
		dp[y][x]=0;
		
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		
		for(int d=0; d<4; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			if(nx<0 || nx>=N || ny<0 || ny>=M)continue;
			if(map[y][x]>map[ny][nx]) {
				dp[y][x]+=dfs(ny,nx);
			}
		}
		
		return dp[y][x];
	}

}
