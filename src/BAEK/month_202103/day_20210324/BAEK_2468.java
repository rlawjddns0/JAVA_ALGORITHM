package BAEK.month_202103.day_20210324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2468 {
	static int N;
	static int[][] map;
	static int[][] tmp;
	static int max;
	static int h;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static boolean[][] Bvisit;
	static boolean[][] Dvisit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		tmp=new int[N][N];
		max=Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				tmp[i][j]=map[i][j];
				max=Math.max(max, map[i][j]);//가장 높은 지역
			}
		}
		
		Bvisit=new boolean[N][N];
		Dvisit=new boolean[N][N];
		//bfs(0,0);
		//print();
		h=0;
		int ans=Integer.MIN_VALUE;
		while(max>h) {
			init();
			count=0;
			bfs(0,0);//물에 잠긴거 찾기
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c]>0 && !Dvisit[r][c]) {
						dfs(r,c);
						count++;
					}
				}
			}
			//print();
			ans=Math.max(ans, count);
			h++;
		}
		System.out.println(ans);
		
		
		
		
		
	}
	static int count;
	private static void dfs(int y, int x) {
		
		Dvisit[y][x]=true;
		map[y][x]=0;
		
		for(int d=0; d<4; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			if(nx>=0 && nx<N && ny>=0 && ny<N && !Dvisit[ny][nx] && map[ny][nx]>0) {
				dfs(ny,nx);
			}
		}
		
		
		
	}
	private static void bfs(int y, int x) {
		
		Queue<pos> q=new LinkedList<>();
		q.offer(new pos(y,x));
		Bvisit[y][x]=true;
		while(!q.isEmpty()) {
			pos tmp=q.poll();
			if(map[tmp.y][tmp.x]<=h) {
				map[tmp.y][tmp.x]=-2;
			}
			
			for(int d=0; d<4;d ++) {
				int nx=tmp.x+dx[d];
				int ny=tmp.y+dy[d];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && !Bvisit[ny][nx]) {
					q.offer(new pos(ny,nx));
					Bvisit[ny][nx]=true;
				}
			}
			
		}
		
		
		
	}
	public static void init() {
		for(int i=0; i<N; i++) {
			map[i]=tmp[i].clone();
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				Bvisit[i][j]=false;
				Dvisit[i][j]=false;
			}
		}
		
	}
	public static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
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