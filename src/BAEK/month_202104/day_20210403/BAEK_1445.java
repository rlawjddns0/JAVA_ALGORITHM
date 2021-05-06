package BAEK.month_202104.day_20210403;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BAEK_1445 {
	static int N,M;
	static char[][] map;
	static int[][] wmap;
	static check[][] check;
	static boolean[][] visit;
	static int fx,fy;//꽃 위치
	static int sx,sy;//시작 위치
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map=new char[N][M];
		wmap=new int[N][M];
		check=new check[N][M];
		visit=new boolean[N][M];
		for(int i=0; i<N; i++) {
			map[i]=sc.next().toCharArray();
			for(int j=0;j<M; j++) {
				if(map[i][j]=='F') {
					fx=j;
					fy=i;
				}
				if(map[i][j]=='S') {
					sx=j;
					sy=i;
				}
				check[i][j]=new check(0,0);
			}
			
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]=='g') {
					wmap[i][j]=2;
					for(int d=0; d<4; d++) {
						int ni=i+dy[d];
						int nj=j+dx[d];
						if(ni<N && ni>=0 && nj<M && nj>=0 && map[ni][nj]=='.') {
							wmap[ni][nj]=1;
						}
					}
				}
				
			}
		}
		
		bfs(sx,sy);
		System.out.println(check[fy][fx].w+" "+check[fy][fx].side);
		
		
		
	}
	public static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(wmap[i]));
		}
	}
	static int G=0;
	static int side=0;
	private static void bfs(int startx, int starty) {
		PriorityQueue<Pos> pq=new PriorityQueue<Pos>();
		visit[starty][startx]=true;
		Pos pos=new Pos(startx,starty,wmap[starty][startx],0);
		pq.offer(pos);
		while(!pq.isEmpty()) {
			Pos tmp=pq.poll();
			
			if(tmp.y==fy && tmp.x==fx) {
				check[tmp.y][tmp.x].w=tmp.w;
				check[tmp.y][tmp.x].side=tmp.side;
				return;
			}
			for(int d=0; d<4; d++) {
				int nx=tmp.x+dx[d];
				int ny=tmp.y+dy[d];
				if(ny<N && ny>=0 && nx<M &&nx>=0 && !visit[ny][nx]) {
					if(wmap[ny][nx]==2) {
						pq.offer(new Pos(nx,ny,tmp.w+1,tmp.side));
					}else if(wmap[ny][nx]==1) {
						pq.offer(new Pos(nx,ny,tmp.w,tmp.side+1));

					}
					else {
						pq.offer(new Pos(nx,ny,tmp.w,tmp.side));
					}
					
					visit[ny][nx]=true;
				}
				
			}
		}
	}

}
class Pos implements Comparable<Pos>{
	int x,y,w,side;

	
	

	public Pos(int x, int y, int w, int side) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.side=side;
	}



	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + ", w=" + w + ", side=" + side + "]";
	}



	@Override
	public int compareTo(Pos o) {
		if(this.w==o.w) {
			return this.side-o.side;
		}
		return this.w-o.w;
	}
	
}
class check{
	int w,side;

	public check(int w, int side) {
		super();
		this.w = w;
		this.side = side;
	}

	@Override
	public String toString() {
		return "check [w=" + w + ", side=" + side + "]";
	}
	
}