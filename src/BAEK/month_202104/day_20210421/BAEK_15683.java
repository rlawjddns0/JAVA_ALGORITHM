package BAEK.month_202104.day_20210421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_15683 {
	static int N,M;
	static int[][] map;
	static int[][] tmp;
	static ArrayList<cctv> c;
	//static boolean[][] visit;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		c=new ArrayList<>();
		map=new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]>=1 && map[i][j]<=5)c.add(new cctv(i,j,map[i][j]));
			}
		}
		
		
		
		dfs(0,map);
		System.out.println(ans);
		
		
		
	}
	static int ans=Integer.MAX_VALUE;
	private static void dfs(int cnt, int[][] map) {
		int[][] visit=new int[N][M];
		if(cnt==c.size()) {
			int count=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0) {
						count++;
					}
				}
			}
			ans=Math.min(count, ans);
			return;
			
		}
		else {
			cctv tmp=c.get(cnt);
			int y=tmp.y;
			int x=tmp.x;
			int num=tmp.num;//cctv ¹øÈ£
			
			if(num==1) {
				
				for(int d=0; d<4; d++) {
					for(int i=0; i<N; i++) {
						visit[i]=map[i].clone();
					}
					visit=check(y,x,d,visit);
					dfs(cnt+1,visit);
					
				}
				
			}else if(num==2) {

				for(int d=0; d<2; d++) {
					for(int i=0; i<N; i++) {
						visit[i]=map[i].clone();
					}
					visit=check(y,x,d,visit);
					visit=check(y,x,d+2,visit);
					dfs(cnt+1,visit);
					
				}
				
			}else if(num==3) {

				for(int d=0; d<4; d++) {
					for(int i=0; i<N; i++) {
						visit[i]=map[i].clone();
					}
					visit=check(y,x,d,visit);
					visit=check(y,x,(d+1)%4,visit);
					dfs(cnt+1,visit);
					
				}
				
			}else if(num==4) {

				for(int d=0; d<4; d++) {
					for(int i=0; i<N; i++) {
						visit[i]=map[i].clone();
					}
					visit=check(y,x,(d+1)%4,visit);
					visit=check(y,x,d,visit);
					visit=check(y,x,(d+2)%4,visit);
					dfs(cnt+1,visit);
					
				}
				
			}else if(num==5) {

					for(int i=0; i<N; i++) {
						visit[i]=map[i].clone();
					}
					visit=check(y,x,0,visit);
					visit=check(y,x,1,visit);
					visit=check(y,x,2,visit);
					visit=check(y,x,3,visit);
					dfs(cnt+1,visit);
			}
			
		}
	}
	public static int[][] check(int y,int x,int d, int[][] visit){
		while(true) {
			int ny=y+dy[d];
			int nx=x+dx[d];
			if(ny>=N || ny<0 || nx>=M || nx<0 || map[ny][nx]==6)break;
			visit[ny][nx]=7;
			y=ny;
			x=nx;
		}
		return visit;
	}
	
	
}
class cctv{
	int y,x,num;


	public cctv(int y, int x,int num) {
		super();
		this.y = y;
		this.x = x;
		this.num=num;
	}
	
}
