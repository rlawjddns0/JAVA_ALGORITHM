package BAEK.month_2022023.day_20220330;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_14923 {
	static int N,M;
	static int[][] map;
	static pos start;
	static pos end;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		map=new int[N+1][M+1];
		boolean[][][] visit=new boolean[2][N+1][M+1];
		
		st=new StringTokenizer(br.readLine()," ");
		start=new pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0,0);
		
		
		st=new StringTokenizer(br.readLine()," ");
		end=new pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0,0);
		
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		Queue<pos> q=new LinkedList<>();
		
		q.offer(start);
		
		visit[0][start.y][start.x]=true;
		
		while(!q.isEmpty()) {
			pos cur=q.poll();
			
			
			if(cur.y==end.y && cur.x==end.x) {
				
				System.out.println(cur.time);
				System.exit(0);
			}
			
			for(int d=0; d<4; d++) {
				int nx=dx[d]+cur.x;
				int ny=dy[d]+cur.y;
				if(ny>=N+1|| ny<1 || nx>=M+1 || nx<1)continue;
				if(visit[cur.crush][ny][nx])continue;
				if(map[ny][nx]==1) {
					if(cur.crush==1) {
						continue;
					}else {
						if(!visit[cur.crush][ny][nx]) {
							q.offer(new pos(ny,nx,cur.time+1, 1));
						}else {
							continue;
						}
					}
				}else {
					q.offer(new pos(ny,nx,cur.time+1,cur.crush));
					visit[cur.crush][ny][nx]=true;
				}
			
			}
			
			
		}
		
		
		System.out.println("-1");
		
		
		
		
		
		
		
		
		
	}
	
	
	static class pos{
		int y,x,time,crush;

		public pos(int y, int x, int time, int crush) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
			this.crush = crush;
		}

		@Override
		public String toString() {
			return "pos [y=" + y + ", x=" + x + ", time=" + time + ", crush=" + crush + "]";
		}
		
	}
}
