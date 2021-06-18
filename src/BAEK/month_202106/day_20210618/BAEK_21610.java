package BAEK.month_202106.day_20210618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_21610 {
	static int N,M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx= {0,-1,-1,0,1,1,1,0,-1};
	static int[] dy= {0,0,-1,-1,-1,0,1,1,1};
	static ArrayList<cloud> cloud=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		visit=new boolean[N+1][N+1];
		map=new int[N+1][N+1];
		cloud.add(new cloud(N,1));
		cloud.add(new cloud(N,2));
		cloud.add(new cloud(N-1,1));
		cloud.add(new cloud(N-1,2));
		
		for(int i=1; i<N+1; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1; j<N+1; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
//		print();
//		System.out.println();

		for(int m=0; m<M; m++) {
//			System.out.println(m+1+"번째++++++++++++++++++++++++");
			st=new StringTokenizer(br.readLine()," ");
			int d=Integer.parseInt(st.nextToken());//이동 방향
			int s=Integer.parseInt(st.nextToken());//이동 거리
			int size=cloud.size();
//			System.out.println(cloud.toString());
			//이동
			for(int i=0; i<size; i++) {
				int y=cloud.get(0).y;
				int x=cloud.get(0).x;
				cloud.remove(0);
				for(int j=0; j<s; j++) {
					y=y+dy[d];
					x=x+dx[d];
					if(y<1)y+=N;
					if(x<1)x+=N;
					if(x>N)x=1;
					if(y>N)y=1;
				}
				cloud.add(new cloud(y,x));
			}
//			System.out.println("이동 후++++++++++++++++++++++");
//			print();
//			System.out.println(cloud.toString());
//			System.out.println();
//			
			//비가 1씩 내린다.
			for(int i=0; i<cloud.size(); i++) {
				map[cloud.get(i).y][cloud.get(i).x]+=1;
			}
			
			
			
//			print();
//			System.out.println(cloud.toString());
//			System.out.println();
//			System.out.println("비가 1씩 내린 후++++++++++++++++++++++");
//			//대각선
			for(int i=0; i<cloud.size(); i++) {
				int y=cloud.get(i).y;
				int x=cloud.get(i).x;
				int cnt=0;
				for(int d1=2; d1<9; d1+=2) {
					int ny=y+dy[d1];
					int nx=x+dx[d1];
					if(ny<=N && ny>0 && nx<=N && nx>0 && map[ny][nx]>0) {
//						System.out.println("y: "+ny+" x: "+nx);
						cnt++;
					}
					
				}
				map[y][x]+=cnt;
			}
//			System.out.println("대각선 하고 난후++++++++++++++++++++++");
//			print();
//			System.out.println(cloud.toString());
//			System.out.println();
			for(int i=0; i<cloud.size(); i++) {
				visit[cloud.get(i).y][cloud.get(i).x]=true;
			}
			cloud.clear();
			
			
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(visit[i][j])continue;
					if(map[i][j]>=2) {
						cloud.add(new cloud(i,j));
						map[i][j]-=2;
					}
				}
			}
//			System.out.println("구름 다시 생성 후++++++++++++++++++++++");
//			print();
//			System.out.println(cloud.toString());
//			System.out.println();
			visit=new boolean[N+1][N+1];
			
//			print();
//			System.out.println(cloud.toString());
//			System.out.println();
//	
//			
			
		}
		
		int result=0;
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				result+=map[i][j];
			}
		}
		
		System.out.println(result);
		
		
	}
	public static void print() {
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
class cloud{
	int y,x;

	public cloud(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		return "cloud [y=" + y + ", x=" + x + "]";
	}
	
}
