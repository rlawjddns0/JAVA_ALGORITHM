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
				if(map[i][j]=='F') {//꽃의 위치
					fx=j;
					fy=i;
				}
				if(map[i][j]=='S') {//시작 위치
					sx=j;
					sy=i;
				}
				if(map[i][j]=='g') {
					wmap[i][j]=2;//쓰레기와 쓰레기 옆길의 가중치를 계산하여 값 넣기
					for(int d=0; d<4; d++) {
						int ni=i+dy[d];
						int nj=j+dx[d];
						if(ni<N && ni>=0 && nj<M && nj>=0 && (map[ni][nj]=='.' || map[ni][nj]=='\0')) {
							wmap[ni][nj]=1;
						}
					}
				}
				check[i][j]=new check(0,0);//쓰레기를 밟았는지 쓰레기 옆을 지나왔는지에 대한 값을 저장하는 배열
			}
			
		}
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				if(map[i][j]=='g') {
//					wmap[i][j]=2;//쓰레기와 쓰레기 옆길의 가중치를 계산하여 값 넣기
//					for(int d=0; d<4; d++) {
//						int ni=i+dy[d];
//						int nj=j+dx[d];
//						if(ni<N && ni>=0 && nj<M && nj>=0 && map[ni][nj]=='.' && map[ni][nj]==' ') {
//							wmap[ni][nj]=1;
//						}
//					}
//				}
//				
//			}
//		}
		
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
		//우선순위큐에 우선순위는 쓰레기를 밟은 횟수가 가장 적은거, 쓰레기 옆길늘 지나온 횟수 순
		PriorityQueue<Pos> pq=new PriorityQueue<Pos>();
		visit[starty][startx]=true;
		Pos pos=new Pos(startx,starty,wmap[starty][startx],0);//시작 
		pq.offer(pos);
		while(!pq.isEmpty()) {
			Pos tmp=pq.poll();
			
			if(tmp.y==fy && tmp.x==fx) {//도착 했으면
				check[tmp.y][tmp.x].w=tmp.w;//지금까지 가져온 쓰레기를 밟은 횟수와 지나온 횟수를 저장
				check[tmp.y][tmp.x].side=tmp.side;
				return;
			}
			for(int d=0; d<4; d++) {
				int nx=tmp.x+dx[d];
				int ny=tmp.y+dy[d];
				if(ny<N && ny>=0 && nx<M &&nx>=0 && !visit[ny][nx]) {
					if(wmap[ny][nx]==2) {//내가 다음에 갈 곳이 쓰레기가 있다
						pq.offer(new Pos(nx,ny,tmp.w+1,tmp.side));//쓰레기를 한 번 밟은거니까 쓰레기 밟은 횟수 +1
					}else if(wmap[ny][nx]==1) {
						pq.offer(new Pos(nx,ny,tmp.w,tmp.side+1));//쓰레기 옆 길이니까 쓰레기 옆길 밟은 횟수 +1

					}
					else {
						pq.offer(new Pos(nx,ny,tmp.w,tmp.side));//아무것도 없다-> 그냥 밟음
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