package BAEK.month_202112.day_20211222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_14940 {
	static int N,M;
	static int[][] map;
	static int[][] answer;
	static int endy,endx;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		answer=new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					endy=i;
					endx=j;
				}
			}
		}
		solution();
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(answer[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	
	}
	private static void solution() {
		
		int[] dy= {0,1,0,-1};
		int[] dx= {1,0,-1,0};
		
		boolean[][] visit=new boolean[N][M];
		answer[endy][endx]=0;
		visit[endy][endx]=true;
		Queue<pos> q=new LinkedList<>();
		q.add(new pos(endy,endx, 0));
		while(!q.isEmpty()) {
			pos tmp=q.poll();
			int curY=tmp.y;
			int curX=tmp.x;
			int curCnt=tmp.cnt;
			
			for(int d=0; d<4; d++) {
				int ny=dy[d]+curY;
				int nx=dx[d]+curX;
				if(ny>=N || ny<0 || nx>=M || nx<0)continue;
				if(visit[ny][nx])continue;
				if(map[ny][nx]==0)continue;
				q.add(new pos(ny,nx,curCnt+1));
				answer[ny][nx]=curCnt+1;
				visit[ny][nx]=true;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visit[i][j] && map[i][j]!=0) {
					answer[i][j]=-1;
				}
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
