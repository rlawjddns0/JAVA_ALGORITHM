package SWE.month_202103.day_20210322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWE_1227 {
	static int[][] map;
	static boolean[][] visit;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int ans=0;
	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			map=new int[101][101];
			visit=new boolean[101][101];
			int y=0,x=0;
			for(int i=0; i<101; i++) {
				char[] ch=br.readLine().toCharArray();
				for(int j=0; j<ch.length; j++) {
					map[i][j]=ch[j]-'0';
					if(map[i][j]==2) {
						y=i;
						x=j;
					}
				}
			}
			//print();
			
			ans=0;
			dfs(y,x);
			//System.out.println();
			//System.out.println();
			//print();
			
			System.out.println("#"+t+" "+ans);
			
		}

	}
	private static void print() {
		for(int i=0; i<101; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	private static void dfs(int y, int x) {

		if(map[y][x]==3) {
			
			
			ans=1;
			return;
		}
		
		map[y][x]=5;
		visit[y][x]=true;
		for(int d=0; d<4; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			if(!visit[ny][nx]&&map[ny][nx]!=1 ) {
				dfs(ny,nx);
			}
			
		}
		
		//visit[y][x]=false;
		visit[y][x]=false;
		//map[y][x]=0;
		return;
		
		
	}

}
