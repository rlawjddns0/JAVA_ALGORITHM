package BAEK.month_202202.day_2022024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_16234 {
	static int N,L,R;
	static int[][] map;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int lineChk;
	static int ddd=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		while(true) {
			lineChk=0;
			ddd=0;
			intt=new ArrayList<>();
			boolean[][] visit=new boolean[N][N];
//			System.out.println("s");
			share(visit); ///국경선 열기
			if(lineChk==0)break;
			cnt++;
//			bfs(visit);//연합 계산
//			print();
			
			
			
			
		}
		System.out.println(cnt);
		
		
		
		
		
				
	}
	private static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
//	private static void bfs(boolean[][] visit) {
//		boolean[][] tmpVisit=new boolean[N][N];
//		
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				int cnt=0;
//				if(visit[i][j] && !tmpVisit[i][j]) {
//					
//					tmpVisit[i][j]=true;
//					check(tmpVisit,i,j,cnt,visit);
//				}
//			}
//		}
//		
//		
//		
//		
//		
//	}
	
	static class pos{
		int i,j,p;

		public pos(int i, int j,int p) {
			super();
			this.i = i;
			this.j = j;
			this.p=p;
		}

		@Override
		public String toString() {
			return "pos [i=" + i + ", j=" + j + ", p=" + p + "]";
		}
		
	}
//	private static void check(boolean[][] tmpVisit, int i, int j,int cnt,boolean[][] visit) {
//		
//		Queue<pos> q=new LinkedList<>();
//		q.offer(new pos(i,j));
//		int sum=map[i][j];
//		cnt=1;
//		while(!q.isEmpty()) {
//			
//			pos cur=q.poll();
//			
//
//			for(int d=0; d<4; d++) {
//				int ny=cur.i+dy[d];
//				int nx=cur.j+dx[d];
//				if(ny<0 || ny>=N || nx<0 || nx>=N)continue;
//				if(!tmpVisit[ny][nx] && visit[ny][nx]) {
//					q.offer(new pos(ny,nx));
//					cnt++;
//					sum+=map[ny][nx];
//					tmpVisit[ny][nx]=true;
//				}
//			}
//			
//			
//			
//		}
//		printVisit(tmpVisit);
//		
//		for(int y=0; y<N; y++) {
//			for(int x=0; x<N; x++) {
//				if(tmpVisit[y][x]) {
//					map[y][x]=sum/cnt;
//				}
//			}
//		}
//		print();
//		
//		
//		
//		
//		
//		
//	}
	private static void printVisit(boolean[][] visit) {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
		System.out.println();
	}
	static int cnt;
	static int sum;
	private static void share(boolean[][] visit) {
		ArrayList<pos> list=new ArrayList<>();
		cnt=0;
		sum=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j])continue;
				
				for(int d=0; d<4; d++) {
					int nx=j+dx[d];
					int ny=i+dy[d];
					if(ny<0 || ny>=N || nx<0 || nx>=N)continue;
					if(visit[ny][nx])continue;
					if(Math.abs(map[i][j]-map[ny][nx])>=L &&Math.abs(map[i][j]-map[ny][nx])<=R) {
						lineChk++;
						cnt=1;
						sum=map[i][j];
						
						bfs2(i,j,visit,list);
					}
					
				}
				

			}
		}
		
		for(int t=0; t<list.size(); t++) {
//			System.out.println(list.get(t).toString());
//			System.out.println(intt.get(list.get(t).p));
			int ti=list.get(t).i;
			int tj=list.get(t).j;
			map[ti][tj]=intt.get(list.get(t).p);
		}
		
//		print();
//		printVisit(visit);
//		System.out.println(sum);
//		System.out.println(cnt);
		
	}
	static ArrayList<Integer> intt;
	private static void bfs2(int i, int j, boolean[][] visit, ArrayList<pos> list) {
		
		Queue<pos> q=new LinkedList<>();
		q.offer(new pos(i,j,0));
		visit[i][j]=true;
		list.add(new pos(i,j,ddd));
		while(!q.isEmpty()) {
			pos cur=q.poll();
			
			for(int d=0; d<4; d++) {
				int nx=cur.j+dx[d];
				int ny=cur.i+dy[d];
				if(ny<0 || ny>=N || nx<0 || nx>=N)continue;
				if(visit[ny][nx])continue;
				if(Math.abs(map[cur.i][cur.j]-map[ny][nx])>=L &&Math.abs(map[cur.i][cur.j]-map[ny][nx])<=R) {
					q.offer(new pos(ny,nx,0));
					visit[ny][nx]=true;
					cnt++;
					sum+=map[ny][nx];
					list.add(new pos(ny,nx,ddd));
				}
				
			}
			
		}
		intt.add(sum/cnt);
		ddd++;
		
		
	}
}
