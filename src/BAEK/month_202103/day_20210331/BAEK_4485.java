package BAEK.month_202103.day_20210331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
//다시 풀어보기
public class BAEK_4485 {
	static int N;
	static int[][] map;
	static int[][] dij;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		int p=1;
		while(true) {
			N=Integer.parseInt(br.readLine());
			if(N==0)break;
			ans=0;
			map=new int[N][N];
			dij=new int[N][N];
			
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					dij[i][j]=Integer.MAX_VALUE;
				}
			}
			dij[0][0]=map[0][0];
			dij();
			System.out.println("Problem"+" "+p+": "+dij[N-1][N-1]);
			p++;
			
		}
		
	}
	private static void dij() {
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		int x=0,y=0;
		PriorityQueue <loc> q=new PriorityQueue();
		q.offer(new loc(0,0,map[0][0]));
		
		
		while(!q.isEmpty()) {
			loc tmp=q.poll();
			
			
			for(int d=0; d<4; d++) {
				int nx=tmp.x+dx[d];
				int ny=tmp.y+dy[d];
				if(nx<0 || nx>=N || ny<0 || ny>=N)continue;
				
				if(dij[ny][nx]>map[ny][nx]+dij[tmp.y][tmp.x]) {
					dij[ny][nx]=map[ny][nx]+dij[tmp.y][tmp.x];
					q.offer(new loc(nx,ny,dij[ny][nx]));
				}
				
			}
		}
		
	}

}
class loc implements Comparable<loc>{
	int x,y,w;

	public loc(int x, int y, int w) {
		this.x = x;
		this.y = y;
		this.w=w;
	}

	@Override
	public int compareTo(loc o) {
		// TODO Auto-generated method stub
		return this.w-o.w;
	}
	
}
