package BAEK.month_2022023.day_20220324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_17142 {
	static int N,M;
	static int[][] map;
	static ArrayList<virusLocation> virusSpace;
	static int emptySpace;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		virusSpace=new ArrayList<>();
		int ex1=0;
		int ex2=0;
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					map[i][j]=-2;
					ex1++;
				}
				if(map[i][j]==2) {
					ex2++;
					virusSpace.add(new virusLocation(i,j));
				}
				if(map[i][j]==0)emptySpace++;
			}
		}
		
		if(ex1+ex2==N*N) {
			System.out.println(0);
			System.exit(0);
		}
		
		
		step1(new boolean[virusSpace.size()],0,0);
		
		
		
		if(TIME==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(TIME);
		}
		
		
		
	}
	private static void step1(boolean[] visit, int idx,int k) {
		
		if(k==M) {
			
			int cnt=0;
			int[][] tmpMap=map.clone();
			virusLocation[] select=new virusLocation[M];
			for(int i=0; i<visit.length; i++) {
				if(visit[i]) {
					select[cnt++]=virusSpace.get(i);
				}else {
					tmpMap[virusSpace.get(i).y][virusSpace.get(i).x]=-1;
				}
			}
			
			step2(tmpMap, select);
			
			
			return;
			
		}
		if(idx==visit.length)return;
		
		
		
		
		
		
		visit[idx]=true;
		step1(visit,idx+1,k+1);
		visit[idx]=false;
		step1(visit,idx+1,k);
		
		
		
		
		
	
		
		
		
	}
	
	static int TIME=Integer.MAX_VALUE;
	private static void step2(int[][] tmpMap, virusLocation[] select) {
		boolean[][] visit=new boolean[N][N];
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		int tmpEmpty=emptySpace;
		for(int i=0; i<select.length; i++) {
			visit[select[i].y][select[i].x]=true;
		}
	
		for(int i=0; i<select.length; i++) {
			tmpMap[select[i].y][select[i].x]=0;
		}
		
		
		Queue<virusTime> q=new LinkedList<>();
		for(int i=0; i<select.length; i++) {
			q.offer(new virusTime(select[i].y,select[i].x,0));
		}
		
		
		while(!q.isEmpty()) {
			virusTime cur=q.poll();
			
			for(int d=0; d<4; d++) {
				int ny=dy[d]+cur.y;
				int nx=dx[d]+cur.x;
				if(ny>=N || ny<0 || nx>=N || nx<0)continue;
				if(visit[ny][nx])continue;
				if(tmpMap[ny][nx]==-2) {
					
					visit[ny][nx]=true;
					continue;
				}
				if(tmpMap[ny][nx]==-1) {
					q.offer(new virusTime(ny,nx,cur.time+1));
					tmpMap[ny][nx]=cur.time;
					visit[ny][nx]=true;
					
				}else {
					tmpMap[ny][nx]=cur.time+1;
					q.offer(new virusTime(ny,nx,cur.time+1));
					visit[ny][nx]=true;
					tmpEmpty--;
					
				}
				
			}
			if(tmpEmpty<=0)break;
			
		}
		
		System.out.println("============================================================");
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(tmpMap[i]));
		}
		System.out.println();
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
		System.out.println();
		
		
		int cnt=0;
		int tmpAns=Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j] || tmpMap[i][j]==-2) {
					cnt++;
					tmpAns=Math.max(tmpAns, tmpMap[i][j]);
				}
			}
		}
		
		if(cnt==N*N)
		{
			TIME=Math.min(tmpAns, TIME);
		}
		
		
		
		
	}
	
	
	
	
	static class virusTime{
		int y,x,time;

		public virusTime(int y, int x, int time) {
			super();
			this.y = y;
			this.x = x;
			this.time = time;
		}
		
	}
	

	static class virusLocation{
		int y,x;

		public virusLocation(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
