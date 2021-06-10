package BAEK.month_202106.day_20210609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_21772 {
	static int R,C,T;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		visit=new boolean[R][C][T];
		int starty=0;
		int startx=0;
		for(int i=0; i<R; i++) {
			char[] tmp=br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				map[i][j]=tmp[j];
				if(map[i][j]=='G') {
					starty=i;
					startx=j;
				}
			}
		}
		//print();
		visit[starty][startx][0]=true;
		dfs(starty, startx,0,0,0);
		
		System.out.println(ans);
		
		
		
		
		
	}
	private static void print() {
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	static int ans=0;//Integer.MAX_VALUE;로 하면 틀린다.....
	private static void dfs(int y, int x, int t, int g,int now) {
		if(t==T) {
			ans=Math.max(ans, g);
			
			
			return;
		}
		for(int d=0; d<4; d++) {
			int ny=y+dy[d];
			int nx=x+dx[d];
			if(ny>=R || ny<0 || nx>=C || nx<0 || map[ny][nx]=='#')continue;
			if(visit[ny][nx][now])continue;
//			System.out.println("y: "+ ny +" x: "+nx);
			if(map[ny][nx]=='S') {
				visit[ny][nx][now]=true;
				map[ny][nx]='.';
				dfs(ny,nx,t+1,g+1,now);
				map[ny][nx]='S';
				visit[ny][nx][now]=false;
			}else{
				
				visit[ny][nx][now]=true;
				
				dfs(ny,nx,t+1,g,now);
				
				visit[ny][nx][now]=false;
			}
			
			
		}
		if(t<T) {
			for(int d=0; d<4; d++) {
				int ny=y+dy[d];
				int nx=x+dx[d];
				if(ny>=R || ny<0 || nx>=C || nx<0 || map[ny][nx]=='#')continue;
				if(visit[ny][nx][now]) {
					visit[ny][nx][now+1]=true;
					dfs(ny,nx,t+1,g,now+1);
				}
			}
		}
		
	}

}