package SWE.month_202103.day_20210317;

import java.util.Scanner;

public class SWE_7733 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int cnt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		
		
		int TC=sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			N=sc.nextInt();
			map=new int[N][N];
			visit=new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			int day=0;
			int check=0;
			int ans=Integer.MIN_VALUE;
			while(true) {
				cnt=0;
				visit=new boolean[N][N];
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(map[i][j]==day) {
							map[i][j]=0;
							check++;
						}
						
					}
				}
				if(check==N*N)break;
				
				
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(map[i][j]!=0 && !visit[i][j]) {
							cnt++;
							dfs(i,j);
						}
					}
				}
				ans=Math.max(ans, cnt);
				
				
				
				day++;
				
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void dfs(int y, int x) {
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		
		visit[y][x]=true;
		for(int d=0; d<4; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[ny][nx] && map[ny][nx]!=0) {
				dfs(ny,nx);
			}
		}
		
		
		
	}

}
