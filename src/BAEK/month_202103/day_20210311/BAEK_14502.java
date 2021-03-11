package BAEK.month_202103.day_20210311;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_14502 {
	static int N,M;
	static int[][] map;
	static int[][] tmap;
	static empty[] E;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int ans=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("./src/input/¿¬±¸¼Ò.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		E=new empty[M*N];
		map=new int[N][M];
		tmap=new int[N][M];
		int cnt=0;
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				tmap[i][j]=map[i][j];
				if(map[i][j]==0)E[cnt++]=new empty(i,j);
			}
		}
		
		wall(new empty[3], 0,0);
		
		
		System.out.println(ans);
		
		
		
	}
	
	private static void wall(empty[] sel, int k, int idx) {
		
		if(k==3) {
			init();
			for(int i=0; i<sel.length; i++) {
				map[sel[i].y][sel[i].x]=1;
			}
			spread();
			int count=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0)count++;
				}
			}
			print();
			ans=Math.max(ans, count);
			
			
			return;
		}
		
		
		
		
		
		for(int i=idx; i<E.length; i++) {
			if(E[i]==null)break;
			sel[k]=E[i];
			wall(sel,k+1,i+1);
		}
		
		
	}
	public static void spread() {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==2) {
					virus(i,j);
				}
			}
		}
		
		
		
	}
	
	
	private static void virus(int y, int x) {

		for(int d=0; d<4; d++) {
			int nx=x+dx[d];
			int ny=y+dy[d];
			if(nx>=0 && nx<M && ny>=0 && ny<N && map[ny][nx]==0) {
				map[ny][nx]=2;
				virus(ny,nx);
			}
		}
	}

	public static void init() {
		
		for(int i=0; i<N; i++) {
			map[i]=tmap[i].clone();
		}
	}
	public static void print() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		
	}

}
class empty{
	int x,y;
	empty(int y, int x){
		this.x=x;
		this.y=y;
	}
	@Override
	public String toString() {
		return "empty [x=" + x + ", y=" + y + "]";
	}
	
}