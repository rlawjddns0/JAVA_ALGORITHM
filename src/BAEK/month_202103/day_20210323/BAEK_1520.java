package BAEK.month_202103.day_20210323;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BAEK_1520 {
	static int M,N;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dp;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int ans;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("./src/input/내리막길.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		map=new int[M][N];
		dp=new int[M][N];
		visit=new boolean[M][N];
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}
		//visit[0][0]=true;
		ans=dfs(0,0);
		print();
		
		System.out.println(ans);
		
	}
	
	private static int dfs(int i, int j) {
		if(i==M-1 &&  j==N-1) {
			
			return 1;
		}
		
		if(dp[i][j]!=-1) {//한번 왔었다 그럼 고대로 다시 리턴
			return dp[i][j];
		}
		
		
		dp[i][j]=0;//안간곳 체크
		
		for(int d=0; d<4; d++) {
			int ni=i+dy[d];
			int nj=j+dx[d];
			if(ni>=0 && ni<M && nj>=0 && nj<N && map[i][j]>map[ni][nj] ) {
				dp[i][j]+=dfs(ni,nj);
			}
		}
		
		return dp[i][j];
	}

	public static void print() {
		for(int i=0; i<M; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		for(int i=0; i<M; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}

}
