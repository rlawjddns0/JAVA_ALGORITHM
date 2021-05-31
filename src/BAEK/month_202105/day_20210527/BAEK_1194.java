package BAEK.month_202105.day_20210527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_1194 {
	static int N,M;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int starty,startx;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new char[N][M];
		visit=new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			char[] tmp=br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(tmp[j]=='0') {
					startx=j;
					starty=i;
				}
				map[i][j]=tmp[j];
			}
		}
		print();
		dfs(startx,starty,0);
		System.out.println(ans);
		
		
	
	}
	static int key;
	static int ans=Integer.MAX_VALUE;
	private static void dfs(int x, int y,int n) {
		
		visit[y][x]=true;
		if(map[y][x]=='1') {
			
			ans=Math.min(ans, n);
			return;
		}
		
		
		for(int d=0; d<4; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			
			if(nx>=M || nx<0 || ny>=N || ny<0)continue;//¸Ê¤·,¤© ¹þ¾î³ª¸é
			System.out.println("1111111");
			if(map[ny][nx]=='#') continue; //º®ÀÌ¸é
			if(visit[ny][nx])continue;
			System.out.println("2222222");
			if(map[ny][nx]>='a' && map[ny][nx]<='z') {//key
				System.out.println("dsfsf");
				key=key |(1<<map[ny][nx]);
				visit=new boolean[N][M];
				visit[ny][nx]=true;
				dfs(nx,ny,n+1);
				visit[ny][nx]=false;

				
			}
			if(map[ny][nx]>='A' && map[ny][nx]<='Z') {
				System.out.println("33333");
				if(((0x1 << (map[ny][nx]+32)) & key)==0){
					System.out.println("SDFSF");
					visit[ny][nx]=true;
					dfs(nx,ny,n+1);
					visit[ny][nx]=false;
				}
			}
			System.out.println(map[ny][nx]);
			if(map[ny][nx]=='.' ||map[ny][nx]=='0'||map[ny][nx]=='1') {
				System.out.println("55555");
				visit[ny][nx]=true;
				dfs(nx,ny,n+1);
				visit[ny][nx]=false;
			}
			System.out.println("99999s");
			
		}
		
		
		
		visit[y][x]=false;

		
		
		
	}
	static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}
