package SWE.month_202103.day_20210315;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWE_8382 {
	static int startx,starty,endx,endy;
	static int[] dx= {1,0,-1,0};
	static int[]dy= {0,-1,0,1};
	public static void main(String[] args) {
		//1 :가로 2:세로
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			startx=sc.nextInt()+100;
			starty=sc.nextInt()+100;
			endx=sc.nextInt()+100;
			endy=sc.nextInt()+100;
			
			
			
			
			System.out.println("#"+t+" "+bfs(startx, starty, endx,endy));
			
			
		}
	}
	
	public static int bfs(int x1, int y1, int x2, int y2) {
		 int[] dx= {1,0,-1,0};//0,2==right 1,3 left
		 int[] dy= {0,-1,0,1};
		Queue<Point> q=new LinkedList<SWE_8382.Point>();
		boolean[][][] visit=new boolean[201][201][2];
		q.add(new Point(x1,y1,0));
		q.add(new Point(x1,y1,1));
		q.add(new Point(x1,y1,2));
		q.add(new Point(x1,y1,3));
		
		visit[x1][y1][0]=true;//0:가로 방향
		visit[x1][y1][1]=true;//1세로방향
		
		int dist=0;
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0; i<size; i++) {
				Point tmp=q.poll();
				
				
				if(tmp.x==x2 && tmp.y==y2) {
					return dist;
				}
				
				for(int d=0; d<4; d++) {
					if(tmp.dir%2!=d%2) {
						
						int nx=tmp.x+dx[d];
						int ny=tmp.y+dy[d];
						
						if(nx>=0 && nx <201 && ny>=0 && ny<201 && !visit[nx][ny][d%2]) {
							visit[nx][ny][d%2]=true;
							q.add(new Point(nx,ny,d));
						}	
					}	
				}	
			}
			dist++;
		}
		return dist;
		
		
		
		
	}
	static class Point{
		int x,y,dir;

		public Point(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}
}
