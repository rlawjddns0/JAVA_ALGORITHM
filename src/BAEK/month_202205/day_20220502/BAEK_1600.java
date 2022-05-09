package BAEK.month_202205.day_20220502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_1600 {
	static int K,W,H;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dx1= {1,0,-1,0};
	static int[] dy1= {0,1,0,-1};
	static int[] dx2= {2,1,-1,-2,-2,-1,1,2};
	static int[] dy2= {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		K=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		W=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		map=new int[H][W];
		visit=new boolean[H][W][K+1];
		for(int i=0; i<H; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<W; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		Queue<pos> q=new LinkedList<>();
		q.offer(new pos(0,0,0,K));
		visit[0][0][K]=true;
		int ans=Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			pos cur=q.poll();
			
			if(cur.y==H-1 && cur.x==W-1) {
				
				ans=Math.min(ans, cur.cnt);
			}
			
			if(cur.k>0) {
				for(int d=0; d<8; d++) {
					int ny=dy2[d]+cur.y;
					int nx=dx2[d]+cur.x;
					if(ny>=H || ny<0 || nx>=W || nx<0)continue;
					if(visit[ny][nx][cur.k-1])continue;
					if(map[ny][nx]==1)continue;
					q.offer(new pos(ny,nx,cur.cnt+1,cur.k-1));
					visit[ny][nx][cur.k-1]=true;
				}
			}
			
			
			
			for(int d=0; d<4; d++) {
				int ny=dy1[d]+cur.y;
				int nx=dx1[d]+cur.x;
				if(ny>=H || ny<0 || nx>=W || nx<0)continue;
				if(visit[ny][nx][cur.k])continue;
				if(map[ny][nx]==1)continue;
				q.offer(new pos(ny,nx,cur.cnt+1,cur.k));
				visit[ny][nx][cur.k]=true;
			}
			
			
		}
		
		
		
		
		if(ans==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
		
		
		
	
		
		
	}
	private static void print1(boolean[][] visit2) {
		for(int i=0; i<visit2.length; i++) {
			System.out.println(Arrays.toString(visit2[i]));
		}
		System.out.println();
		
	}
	private static void print(int[][] map2) {
		
		for(int i=0; i<map2.length; i++) {
			System.out.println(Arrays.toString(map2[i]));
		}
		System.out.println();
		
	}
	static class pos{
		int y,x,cnt,k;

		public pos(int y, int x, int cnt, int k) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.k=k;
		}
		
		
	}
	static class posTmp{
		int y,x;

		public posTmp(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
