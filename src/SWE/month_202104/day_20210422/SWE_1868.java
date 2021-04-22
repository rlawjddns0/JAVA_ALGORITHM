package SWE.month_202104.day_20210422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class SWE_1868 {
	static int N;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						
						int count=0;
						for (int d = 0; d < 8; d++) {
							int nx = j + dx[d];
							int ny = i + dy[d];
							if (nx >= N || nx < 0 || ny >= N || ny < 0)
								continue;
							if (map[ny][nx] == '*')
								count++;
						}
						map[i][j]=Integer.toString(count).charAt(0);
					}
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='*')continue;
					if(map[i][j]=='0' && !visit[i][j]) {
						cnt++;
						bfs(i,j);
					}
					
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>='1' &&map[i][j]<='8'&&!visit[i][j]){
						cnt++;
					}
				}
			}
			

//			print();
//			System.out.println();
//			printV();
			System.out.println("#" + t + " " + cnt);

		}

	}

	private static void bfs(int y, int x) {
		Queue<point> q = new LinkedList<>();
		q.offer(new point(y, x));
		visit[y][x] = true;		
		
		while(!q.isEmpty()) {
			
			point tmp=q.poll();
			int cury=tmp.y;
			int curx=tmp.x;
			
			
			for(int d=0; d<8; d++) {
				int nx=curx+dx[d];
				int ny=cury+dy[d];
				if (nx >= N || nx < 0 || ny >= N || ny < 0|| visit[ny][nx])continue;
				if(map[cury][curx]=='0'&&(map[ny][nx]>='1' &&map[ny][nx]<='8')) {
					visit[ny][nx]=true;
				}
				if(map[ny][nx]=='0') {
					q.offer(new point(ny,nx));
					visit[ny][nx]=true;
				}
			}
			
		}
		
		
		
		
		
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	private static void printV() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
	}


}

class point {
	int y, x;

	public point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		return "point [y=" + y + ", x=" + x + "]";
	}

}