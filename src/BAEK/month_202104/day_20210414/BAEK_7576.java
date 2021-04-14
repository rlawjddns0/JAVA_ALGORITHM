package BAEK.month_202104.day_20210414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_7576 {
	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		ArrayList<tomato> t=new ArrayList<>();
		map=new int[M][N];
		visit=new boolean[M][N];
		int ty,tx;
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					visit[i][j]=true;
					t.add(new tomato(i,j,0));
				}
				if(map[i][j]==-1) {
					visit[i][j]=true;
				}
			}
		}
		
		bfs(t);
		if(check()) {
			System.out.println(time);
		}
		else {
			System.out.println("-1");
		}
		
	}
	private static boolean check() {
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					return false;
				}
			}
		}
		
		
		return true;
	}
	static int time;
	private static void bfs(ArrayList<tomato> t) {
		
		Queue<tomato> q=new LinkedList<>();
		for (tomato tomato : t) {
			q.offer(tomato);
			visit[tomato.y][tomato.x]=true;
		}
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		
		while(!q.isEmpty()) {
			tomato tmp=q.poll();
			int x=tmp.x;
			int y=tmp.y;
			time=tmp.depth;
			
			for(int d=0; d<4;d ++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visit[ny][nx] && map[ny][nx]==0) {
					q.offer(new tomato(ny,nx,tmp.depth+1));
					visit[ny][nx]=true;
					
				}
				
			}
		}
		
	}

}
class tomato{
	int y,x,depth;

	public tomato(int y, int x, int depth) {
		super();
		this.y = y;
		this.x = x;
		this.depth=depth;
	}

	@Override
	public String toString() {
		return "tomato [y=" + y + ", x=" + x + "]";
	}
	
	
}