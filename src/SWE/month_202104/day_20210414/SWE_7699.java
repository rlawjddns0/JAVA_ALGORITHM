package SWE.month_202104.day_20210414;

import java.util.Arrays;
import java.util.Scanner;

public class SWE_7699 {
	static int R,C;
	static char[][] map;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {1,0,-1,0};
	static boolean[] alpha;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int tc=sc.nextInt();
		
		
		for(int t=1; t<=tc; t++) {
			R=sc.nextInt();
			C=sc.nextInt();
			map=new char[R][C];
			alpha=new boolean[26];
			ans=0;
			for(int i=0; i<R; i++) {
				map[i]=sc.next().toCharArray();
			}
			
			
			
			dfs(0,0,1);
			System.out.println("#"+t+" "+ans);
			
		}
		
		
		
	}
	static int ans=Integer.MIN_VALUE;
	private static void dfs(int y, int x,int cnt) {
		
		ans=Math.max(ans, cnt);
		if(cnt==26)return;
		alpha[map[y][x]-'A']=true;
		for(int d=0; d<4; d++) {
			int ny=y+dy[d];
			int nx=x+dx[d];
			if(ny<R && ny>=0 && nx<C && nx>=0 && !alpha[map[ny][nx]-'A']) {
				dfs(ny,nx,cnt+1);
			}
		}
		alpha[map[y][x]-'A']=false;
		
		
	}

}
