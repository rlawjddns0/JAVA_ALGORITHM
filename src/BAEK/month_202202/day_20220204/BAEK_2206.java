package BAEK.month_202202.day_20220204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2206 {
	static int N,M;
	static int[][] map;
	static boolean[][][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		visit=new boolean[2][N][M];
		map=new int[N][M];
		for(int i=0; i<N; i++) {
			char[] tmp=br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j]=tmp[j]-'0';
			}
		}
		int dy[]= {0,1,0,-1};
		int dx[]= {1,0,-1,0};
		
		visit[0][0][0]=true;
		Queue<pos> q=new LinkedList<>();
		q.offer(new pos(0,0,1,0));
		int ans=Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			
			pos cur=q.poll();
			if(cur.y==N-1 && cur.x==M-1) {
				ans=Math.min(ans, cur.cnt);
			}
			
			for(int d=0; d<4; d++) {
				int nx=dx[d]+cur.x;
				int ny=dy[d]+cur.y;
				if(ny>=N || ny<0 || nx>=M || nx<0)continue;
				if(visit[cur.crush][ny][nx])continue;
				if(cur.crush==0){
					if(map[ny][nx]==0) {
						q.offer(new pos(ny,nx,cur.cnt+1,0));
						visit[0][ny][nx]=true;
					}
					else {
						q.offer(new pos(ny,nx,cur.cnt+1,1));
						visit[1][ny][nx]=true;
					}
				}else {
					if(map[ny][nx]==0) {
						q.offer(new pos(ny,nx,cur.cnt+1,1));
						visit[1][ny][nx]=true;
					}
				}
			}
			
			
			
		}
		
		if(ans==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
		
		
		
		
	}
	static class pos{
		int y,x,cnt,crush;

		public pos(int y, int x, int cnt, int crush) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.crush = crush;
		}
		
		
		
	}
}
 
