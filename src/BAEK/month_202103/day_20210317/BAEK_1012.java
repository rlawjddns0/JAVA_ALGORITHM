package BAEK.month_202103.day_20210317;

import java.util.Scanner;

public class BAEK_1012 {
	static int T,M,N,K;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		
		for(int t=0; t<T; t++) {
			M=sc.nextInt();
			N=sc.nextInt();
			map=new int[N][M];
			visit=new boolean[N][M];
			K=sc.nextInt();
			for(int i=0; i<K; i++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				map[y][x]=1;
			}
			
			
			int cnt=0;
			for(int i=0;i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && !visit[i][j]) {
						cnt++;
						dfs(i,j);
					}
				}
			}
			System.out.println(cnt);
			
				
		}

	}
	private static void dfs(int y, int x) {
		
		
		visit[y][x]=true;
		
		for(int d=0; d<4; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			if(nx>=0 && nx<M && ny>=0 && ny<N && !visit[ny][nx] && map[ny][nx]==1) {
				dfs(ny,nx);
			}
		}
		
	}

}
