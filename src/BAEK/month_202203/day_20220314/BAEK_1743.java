package BAEK.month_2022023.day_20220311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_1743 {
	static boolean[][] visit;
	static int[][] map;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		visit=new boolean[N][M];
		
		for(int i=0; i<K; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int y=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			map[y-1][x-1]=1;
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1 && !visit[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		
		
		System.out.println(ans);
		
		
		
		
	}
	static class pos{
		int y,x;

		public pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	static int ans=Integer.MIN_VALUE;
	private static void bfs(int i, int j) {
		int cnt=1;
		visit[i][j]=true;
		Queue<pos> q=new LinkedList<>();
		q.offer(new pos(i,j));
		int[] dx= {1,0,-1,0};
		int[] dy= {0,-1,0,1};
		
		while(!q.isEmpty()) {
			pos cur=q.poll();
			
			for(int d=0; d<4; d++) {
				int ny=cur.y+dy[d];
				int nx=cur.x+dx[d];
				if(ny>=N || ny<0 || nx>=M || nx<0)continue;
				if(visit[ny][nx])continue;
				if(map[ny][nx]!=1)continue;
				visit[ny][nx]=true;
				cnt++;
				q.offer(new pos(ny,nx));
			}
			
			
			
			
		}
		
		
		ans=Math.max(ans, cnt);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
