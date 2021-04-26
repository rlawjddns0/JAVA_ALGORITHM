package SWE.month_202104.day_20210427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_11315 {
	static int[] dx= {1,1,0,-1,-1,-1,0,1};
	static int[] dy= {0,1,1,1,0,-1,-1,-1};
	static char[][] map;
	static int N;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			N=Integer.parseInt(br.readLine());
			map=new char[N][N];
			visit=new boolean[N][N];
			for(int i=0; i<N; i++) {
				map[i]=br.readLine().toCharArray();
			}
			boolean flag=false;
			int cnt=1;
			L:for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='o') {
						
						
						for(int d=0; d<8; d++) {
							visit[i][j]=true;
							if(dfs(i,j,cnt,d)) {
								flag=true;
								break L;
							}
							visit[i][j]=false;
						}
						
					}
				}
			}
			
			if(flag) {
				System.out.println("#"+t+" "+"YES");
			}else {
				System.out.println("#"+t+" "+"NO");				
			}
			
		}
		
	}
	private static boolean dfs(int i, int j, int cnt,int d) {
		if(cnt>=5) {
			return true;
		}
		
		int ny=i+dy[d];
		int nx=j+dx[d];
		if(ny>=N || ny<0 || nx>=N || nx<0)return false;
		if(map[ny][nx]=='o') {
			return dfs(ny,nx,cnt+1,d);
		}else {
			return false;
		}
		
		
		
		
	}

}
