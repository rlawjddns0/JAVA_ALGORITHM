package BAEK.month_202112.day_20211228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2178 {
	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		visit=new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			char[] input=br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j]=input[j]-'0';
			}
		}
		
		solution();
		System.out.println(result);
		
	}
	static int result=0;
	private static void solution() {
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		
		visit[0][0]=true;
		Queue<pos> q=new LinkedList<>();
		q.offer(new pos(0,0,1));
		
		
		while(!q.isEmpty()) {
			pos cur=q.poll();
			int curX=cur.x;
			int curY=cur.y;
			int cnt=cur.cnt;
			if(curX==M-1 && curY==N-1) {
				result=cnt;
			}
			for(int d=0; d<4; d++) {
				int ny=dy[d]+curY;
				int nx=dx[d]+curX;
				if(ny>=N || ny<0 || nx>=M|| nx<0)continue;
				if(visit[ny][nx])continue;
				if(map[ny][nx]==0)continue;
				q.offer(new pos(ny,nx,cnt+1));
				visit[ny][nx]=true;
			}
			
		}
		
	}
}
class pos{
	int y,x,cnt;

	public pos(int y, int x, int cnt) {
		super();
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}
	
}
