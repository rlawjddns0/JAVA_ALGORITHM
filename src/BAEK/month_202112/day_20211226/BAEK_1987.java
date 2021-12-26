package BAEK.month_202112.day_20211226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1987 {
	static int R,C;
	static char[][] map;
	
	
	
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		boolean[][] visit=new boolean[R][C];
		boolean[] alpha=new boolean[26];
		for(int i=0; i<R; i++) {
			map[i]=br.readLine().toCharArray();
		}
		int cnt=1;
		alpha[map[0][0]-65]=true;
		visit[0][0]=true;
		solution(cnt,visit,alpha,map[0][0],0,0);
		System.out.println(answer);
				
	}
	static int answer=Integer.MIN_VALUE;
	private static void solution(int cnt, boolean[][] visit, boolean[] alpha, char k,int y, int x) {
		
		answer=Math.max(cnt, answer);
		
		
		
		for(int d=0; d<4; d++) {
			int ny=dy[d]+y;
			int nx=dx[d]+x;
			if(ny<0 || ny>=R || nx<0 || nx>=C)continue;
			if(visit[ny][nx])continue;
			if(alpha[map[ny][nx]-65])continue;
			visit[ny][nx]=true;
			alpha[map[ny][nx]-65]=true;
			solution(cnt+1,visit,alpha,map[ny][nx],ny,nx);
			visit[ny][nx]=false;
			alpha[map[ny][nx]-65]=false;
		}
		
		
		
		
		
	}
	
	
}
