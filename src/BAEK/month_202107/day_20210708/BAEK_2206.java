package BAEK.month_202107.day_20210708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2206 {
	static int N,M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		
		
		for(int i=1; i<=N; i++) {
			char[] tmp=br.readLine().toCharArray();
			for(int j=1; j<=M; j++) {
				map[i][j]=tmp[j-1]-'0';
			}
		}
		
		int ans=solution();
		if(ans==-1) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
		
		
		
		
		
		
	}
	private static int solution() {
		boolean[][][] visit=new boolean[2][N+1][M+1];
		Queue<user> q=new LinkedList<user>();
		q.offer(new user(1,1,1,0));
		visit[0][1][1]=true;
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		
		while(!q.isEmpty()) {
			
			user tmp= q.poll();
			
			if(tmp.y==N && tmp.x==M) {
				return tmp.cnt;
			}
			
			
			for(int d=0; d<4; d++) {
				int ny=tmp.y+dy[d];
				int nx=tmp.x+dx[d];
				if(ny<1 || ny>N || nx<1 || nx>M || visit[tmp.flag][ny][nx])continue;
				if(tmp.flag==0) {//벽을 한번도 안부셨을때
					if(map[ny][nx]==1) {//벽이 나왔다
						q.offer(new user(ny,nx,tmp.cnt+1,1));
						visit[1][ny][nx]=true;
					}else {//벽이 안나왔다
						q.offer(new user(ny,nx,tmp.cnt+1,0));
						visit[0][ny][nx]=true;
					}
				}else {//벽을 부셨을때
					if(map[ny][nx]==0) {//이미 한번 벽을 부셨기 땜에 0으로만 갈 수 있다.
						q.offer(new user(ny,nx,tmp.cnt+1,1));
						visit[1][ny][nx]=true;
					}
					
				}
			}
			
			
		}
		
		
		
		
		
		
		return -1;
	}

}
class user{
	int y,x,cnt;
	int flag;
	public user(int y, int x, int cnt, int flag) {
		super();
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.flag = flag;
	}
	
	
	
}