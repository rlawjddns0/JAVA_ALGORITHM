package BAEK.month_202104.day_20210406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_13460 {
	static int N,M;
	static char[][] map;
	static boolean[][] visit_red;
	static boolean[][] visit_blue;
	static boolean[][][][] visit;
	static pos ball;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		visit_red=new boolean[N][M];
		visit_blue=new boolean[N][M];
		visit=new boolean[N][M][N][M];
		ball=new pos();
		for(int i=0; i<N; i++) {	
			map[i]=br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(map[i][j]=='R') {
					ball.rx=j;
					ball.ry=i;
				}
				if(map[i][j]=='B')
				{
					ball.by=i;
					ball.bx=j;
				}
			}
		}
		
		
		
		bfs();
		//print();
		
	}
	public static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	public static void print1() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(visit_red[i]));
		}
	}
	public static void print2() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(visit_blue[i]));
		}
	}
	static int ans;
	private static void bfs() {
		
		int[] dx={1,0,-1,0};
		int[] dy= {0,1,0,-1};
		Queue<pos> q=new LinkedList<>();
		
		q.offer(ball);

		while(!q.isEmpty()) {
			pos tmp=q.poll();
			visit[tmp.ry][tmp.rx][tmp.by][tmp.bx]=true;
			
			
			if(tmp.count>=10) {
				System.out.println(-1);
				return;
			}
			
			for(int d=0; d<4; d++) {
				//System.out.println(d);

				int nxB=tmp.bx;
				int nyB=tmp.by;
				while(true) {
					nxB+=dx[d];
					nyB+=dy[d];
					if(map[nyB][nxB]=='#') {
						nyB-=dy[d];
						nxB-=dx[d];
						break;
					}
					if(map[nyB][nxB]=='O')break;
				}
				
				
				int nxR=tmp.rx;
				int nyR=tmp.ry;
				while(true) {
					nxR+=dx[d];
					nyR+=dy[d];
					if(map[nyR][nxR]=='#') {
						nyR-=dy[d];
						nxR-=dx[d];
						break;
					}
					if(map[nyR][nxR]=='O')break;
				}
				
				if(map[nyB][nxB]=='O')continue;
				
				if(map[nyR][nxR]=='O') {
					System.out.println(tmp.count+1);
					return;
				}
				
				//파란색 공을 먼저 굴렸다
				if(nyR==nyB && nxR==nxB) {//공이 같은 위치에 있으면
					//System.out.println("same location");
					switch(d) {
					
					case 0://동
						if(tmp.rx>tmp.bx) {//원래 굴리기 전에 빨간색이 더 오른쪽에 있었다-> 그럼 파란공이 하나 더 간것
							nxB--;
						}
						else {
							nxR--;
						}
						break;					
					case 1://남
						if(tmp.ry>tmp.by) {
							nyB--;
						}else {
							nyR--;
						}
						break;
					case 2://서
						if(tmp.rx>tmp.bx) {
							nxR++;
						}else {
							nxB++;
						}
						break;
					case 3://북
						if(tmp.ry>tmp.by) {
							nyR++;
						}
						else {
							nyB++;
						}
						break;
					}
					
					
			
				}
//				if(d==1) {
//					System.out.println(nyR+" "+nxR);
//					System.out.println(nyB+" "+nxB);
//					print1();
//					System.out.println();
//					print2();
//
//				}
				
				if(!visit[nyR][nxR][nyB][nxB]) {
					q.offer(new pos(nxR,nyR,nxB,nyB,tmp.count+1));
					
					//print();
				}
				
				
			}
		}
		System.out.println(-1);
		
	}

}
class pos{
	int rx,ry,bx,by,count;

	public pos(int rx, int ry, int bx, int by, int count) {
		super();
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.count = count;
	}

	@Override
	public String toString() {
		return "pos [rx=" + rx + ", ry=" + ry + ", bx=" + bx + ", by=" + by + ", count=" + count + "]";
	}

	public pos() {
		super();
	}

	
}