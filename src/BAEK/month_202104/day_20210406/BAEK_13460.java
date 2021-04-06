package BAEK.month_202104.day_20210406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_13460 {
	static int N,M;
	static char[][] map;
	static boolean[][] visit_red;
	static boolean[][] visit_blue;
	static pos red;
	static pos blue;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		visit_red=new boolean[N][M];
		visit_blue=new boolean[N][M];
		for(int i=0; i<N; i++) {	
			map[i]=br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(map[i][j]=='R') {
					red=new pos(i,j,0);
				}
				if(map[i][j]=='B')
				{
					blue=new pos(i,j,0);
				}
			}
		}
		
		
		
		bfs(red,blue);
		
	}
	static int ans;
	private static void bfs(pos red, pos blue) {
		
		int[] dx={1,0,-1,0};
		int[] dy= {0,1,0,-1};
		Queue<pos> R=new LinkedList<>();
		Queue<pos> B=new LinkedList<>();
		visit_red[red.y][red.x]=true;
		visit_blue[blue.y][blue.x]=true;
		
		for(int d=0; d<4; d++) {
			int nx=red.x+dx[d];
			int ny=red.y+dy[d];
			if(map[ny][nx]=='O') {
				ans=1;
				return;
			}
			if(map[ny][nx]=='.' && !visit_red[ny][nx]) {
				R.offer(new pos(ny,nx,d));
				B.offer(new pos(ny,nx,d));
			}
		}
		
		
		
		while(true) {
			
			while(!R.isEmpty()) {
				pos tmpR=R.poll();
				int nx=tmpR.x;
				int ny=tmpR.y;
				while(true) {
					nx+=dx[tmpR.d];
					ny+=dy[tmpR.d];
					if(visit_red[ny][nx])break;
					if(map[ny][nx]=='O')return;
					if(map[ny][nx]=='#') {
						
					}
				}
				
			}
			
			
			
			
			
			
			
			
			
			int d;
			for(d=0; d<4; d++) {
				int nx=tmpR.x;
				int ny=tmpR.y;
				if(map[ny][nx]=='.' && !visit_red[ny][nx]) {
					R.offer(new pos(ny,nx,d));
					B.offer(new pos(ny,nx,d));
				}
			}
			
			while(d)
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
class pos{
	int y,x,d;

	public pos(int y, int x,int d) {
		super();
		this.y = y;
		this.x = x;
		this.d=d;
	}

	@Override
	public String toString() {
		return "ball [y=" + y + ", x=" + x + "]";
	}
	
}