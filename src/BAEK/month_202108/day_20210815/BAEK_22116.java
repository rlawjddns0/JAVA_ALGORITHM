package BAEK.month_202108.day_20210815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_22116 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int l,r,m;
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		visit=new boolean[N][N];
		l=0;
		
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				r=Math.max(map[i][j], r);
			}
		}
		int ans=0;
		while(l<=r) {
			m=(l+r)/2;
			
			
			if(bfs(m)) {
				r=m-1;
				ans=m;
			}else {
				
				l=m+1;
			}
		}
		
		
		
		
		System.out.println(ans);
		
		
		
		
	}
	private static boolean bfs(int m) {
		
		for(int i=0; i<N; i++) {
			Arrays.fill(visit[i], false);
		}
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		visit[0][0]=true;
		Queue<pos> q=new LinkedList<pos>();
		q.offer(new pos(0,0));
//		System.out.println(m);
		while(!q.isEmpty()) {
			pos cur=q.poll();
			if(cur.y==N-1 && cur.x==N-1) {
				return true;
			}
			
			for(int d=0; d<4; d++) {
				int ny=cur.y+dy[d];
				int nx=cur.x+dx[d];
				if(ny<0 || ny>=N || nx<0 || nx>=N)continue;
				if(visit[ny][nx])continue;
				if(Math.abs(map[ny][nx]-map[cur.y][cur.x])>m)continue;
				visit[ny][nx]=true;
				q.offer(new pos(ny,nx));
			
			}
		}
		
		return false;
	}

}
class pos{
	int y,x;

	public pos(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
}
