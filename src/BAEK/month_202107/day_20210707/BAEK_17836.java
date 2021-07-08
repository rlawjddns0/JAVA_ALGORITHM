package BAEK.month_202107.day_20210707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_17836 {
	static int N, M, T;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1;  j<=M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int ans=bfs();
		if(ans==-1 || ans>T) {
			System.out.println("Fail");
		}else {
			System.out.println(ans);
		}
		
		
	}

	private static int bfs() {
		
		boolean[][][] visit=new boolean[2][N+1][M+1];//검이 있는경우 1, 검이 없는경우 0
		Queue<user> q=new LinkedList<user>();
		q.offer(new user(1,1,0,0));//(1,1)에서 시작하여 time=0, 검은 없다.
		visit[0][1][1]=true;//검이 있는 경우와 없는 경우를 나눴다
		
		while(!q.isEmpty()) {
			user cur=q.poll();
			
			
			if(cur.y==N && cur.x==M) {//목표에 도착하면
				return cur.time;//시간 리턴
			}
			
			for(int d=0; d<4; d++) {
				int ny=cur.y+dy[d];
				int nx=cur.x+dx[d];
				if(ny<1 || ny>N || nx<1 || nx>M || visit[cur.sord][ny][nx])continue;//범위를 벗어나거 방문했으면 컨티뉴~
				
				if(cur.sord==1) {//검을 가지고 있는 경우
					q.offer(new user(ny,nx,cur.time+1,1));
					visit[cur.sord][ny][nx]=true;//방문 체크
				}else {//없는 경우
					if(map[ny][nx]==0) {//다음 칸이 0이면 그냥 갈 수 있다
						q.offer(new user(ny,nx,cur.time+1,0));
						visit[cur.sord][ny][nx]=true;
					}
					else if(map[ny][nx]==2) {//검을 먹는다
						q.offer(new user(ny,nx,cur.time+1,1));
						visit[cur.sord][ny][nx]=true;
					}else if(map[ny][nx]==1) {//못간다.
						continue;
					}
				}
				
				
			}
			
			
			
			
			
		}
		
		return -1;
		
		
		
		
		
		
	}

}

class user {
	int y, x;
	int time;
	int sord;
	public user(int y, int x, int time, int sord) {
		super();
		this.y = y;
		this.x = x;
		this.time = time;
		this.sord = sord;
	}
	@Override
	public String toString() {
		return "user [y=" + y + ", x=" + x + ", time=" + time + ", sord=" + sord + "]";
	}

}