package BAEK.month_202107.day_20210731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_20058 {
	static int N,Q;
	static int[][] map;
	static int[] L;
	static int n;
	static int sum;
	static int max_space;
	static boolean[][] visit;
	static int space;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		n=(int)Math.pow(2, N);
		
		L=new int[Q];
		map=new int[n][n];
		visit=new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<Q; i++) {
			L[i]=Integer.parseInt(st.nextToken());
		}
		
		
		
		for(int i=0; i<Q; i++) {
			//나누고 돌리기
			divide(L[i]);
//			print();
//			System.out.println();
			//얼음 양 줄이기
			ice_breaking();
			
		}
		
//		print();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				space=0;
				if(!visit[i][j] && map[i][j]>0) {
					bfs(i,j);
				}
				max_space=Math.max(space, max_space);
			}
		}
//		print();
		System.out.println(sum);
		System.out.println(max_space);
		
		
		
		
		
	}
	
	private static void bfs(int i, int j) {
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		visit[i][j]=true;
		sum+=map[i][j];
		space++;
		Queue<pos> q=new LinkedList<pos>();
		q.offer(new pos(i,j));
		
		
		while(!q.isEmpty()) {
			
			pos cur=q.poll();
			
			for(int d=0; d<4; d++) {
				int ny=cur.y+dy[d];
				int nx=cur.x+dx[d];
				if(ny<0 || ny>=n || nx<0 || nx>=n ||visit[ny][nx])continue;
				if(map[ny][nx]<=0)continue;
				q.offer(new pos(ny,nx));
				visit[ny][nx]=true;
				space++;
				sum+=map[ny][nx];
			}
			
			
			
		}
		
	}

	private static void ice_breaking() {
		
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		int[][] tmp=new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int cnt=0;
				
				for(int d=0; d<4; d++) {
					int ny=i+dy[d];
					int nx=j+dx[d];
					if(ny<0 || ny>=n || nx<0 || nx>=n) {
						cnt++;
						continue;
					}
					if(map[ny][nx]<=0) {
						cnt++;
					}
					
					
				}
				if(cnt>=2) {
						tmp[i][j]=map[i][j]-1;
				}else {
					tmp[i][j]=map[i][j];
				}
			}
		}
		
//		print1(tmp);
		
		
		map=tmp.clone();
		
		
		
		
	}

	private static void divide(int length) {
		int l=(int)Math.pow(2, length);
		int[][] tmp=new int[n][n];
		
		
		for(int i=0; i<n; i+=l) {
			for(int j=0; j<n; j+=l) {
				rotation(i,j,l,tmp);//시작점과 길이를 준다
			}
		}
		
		map=tmp.clone();
		
		
		
	}

	private static void rotation(int y, int x, int l,int[][] tmp) {
//		System.out.println("시작정:" +y+" "+x);
		
		
		
		for(int i=y, k=x+l-1; i<y+l;k--, i++) {
			for(int j=x, q=y; j<x+l;q++, j++) {
				tmp[q][k]=map[i][j];
			}
		}
		
		
//		print1(tmp);
//		
		
		
	}

	static public void print() {
		for(int i=0; i<n; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
	static public void print1(int[][] tmp) {
		for(int i=0; i<n; i++) {
			System.out.println(Arrays.toString(tmp[i]));
		}
		System.out.println();
	}

}
class pos{
	int y,x;

	public pos(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
}
