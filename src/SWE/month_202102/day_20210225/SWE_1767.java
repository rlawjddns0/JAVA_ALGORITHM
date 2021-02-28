package SWE.month_202102.day_20210225;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 
 * 
 * 풀어보기 
 */
public class SWE_1767 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0, 0 };
	static int[] dy = { 0, 1, 0, -1, 0 };
	static int edgeCore;
	static core[] c;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("프로세서.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			int core = 0;
			max=0;
			min=Integer.MAX_VALUE;
			totalCnt=0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1)core++;
				}
			}

			edge();
			totalCnt=core-edgeCore;
			c=new core[core];//가장자리 코어 제외한 코어
			int count=0;
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
						if(map[i][j]==1)c[count++]= new core(j,i);
				}
			}
			
			solve(new boolean[count] , 0);
			
			
			
			

		}
	}

	private static int max,min,totalCnt;
	private static void solve(boolean[] sel, int k) {

		if(k==totalCnt) {
			for(int i=0; i<totalCnt; i++) {
				if(sel[i]) {
					int x=c[i].x;
					int y=c[i].y;
					for(int d=0; d<4; d++) {
						if(isAvailable(y, x, d)) {
							setStaus(y,x,d,2);
						}
					}
				}
			}
			
		}
		
		
		
		
		sel[k]=true;//선택
		solve(sel,k+1);
		sel[k]=false;//비선택
		solve(sel,k+1);

	}
	public static void setStaus(int y, int x, int d, int s) {
		int ny=y;
		int nx=x;
		while(true) {
			ny+=dy[d];
			nx+=dx[d];
			if(nx<0 || nx>=N || ny<0 || ny>=N)break;
			map[ny][nx]=s;
		}
	}
	public static boolean isAvailable(int y, int x, int d) {
		int ny=y;
		int nx=x;
		while(true) {
			ny+=dy[d];
			nx+=dx[d];
			if(nx<0 || nx>=N || ny<0 || ny>=N)break;//전원에 연결된 경우
			if(map[ny][nx]>=1) return false;
		}
		return true;
		
		
	}

	public static void edge() {
		for (int i = 0; i < N; i++) {
			if (map[0][i] == 1)
				edgeCore++;
		}
		for (int i = 1; i < N; i++) {
			if (map[i][N - 1] == 1)
				edgeCore++;
		}
		for (int i = 0; i < N - 1; i++) {
			if (map[N - 1][i] == 1)
				edgeCore++;
		}
		for (int i = 1; i < N - 1; i++) {
			if (map[i][0] == 1)
				edgeCore++;
		}

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}
class core{
	int x;
	int y;
	core(int x, int y){
		this.x=x;
		this.y=y;
	}
}
