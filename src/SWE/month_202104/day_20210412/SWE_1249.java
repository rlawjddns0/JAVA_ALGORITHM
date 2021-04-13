package SWE.month_202104.day_20210412;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SWE_1249 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int[][] temp;
	static boolean[][] visit;
	static int N, sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			sum = 0;
			min = 0;
			map = new int[N][N];
			temp=new int[N][N];
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			for(int i=0; i<N; i++)
                Arrays.fill(temp[i], Integer.MAX_VALUE);
            temp[0][0] = 0;
			bfs(0, 0);

			System.out.println("#" + t + " " +temp[N-1][N-1] );

		}

	}

	static int min;

	private static void bfs(int i, int j) {
		PriorityQueue<pos> pq = new PriorityQueue<>();
		visit[i][j] = true;
		pq.offer(new pos(i, j, 0));

		while (!pq.isEmpty()) {
			//System.out.println(pq.toString());
			pos tmp = pq.poll();
			int time=tmp.time;
			int y=tmp.y;
			int x=tmp.x;
			
			//System.out.println(tmp.w);
			if (y == N - 1 && x == N - 1) {
				if(temp[y][x]>time)
					temp[y][x]=time;
			}
			
			

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
					int dtime=time+map[ny][nx];
					if(!visit[ny][nx] || dtime<temp[ny][nx]) {
						visit[ny][nx]=true;
						temp[ny][nx]=dtime;
						pq.offer(new pos(ny,nx,dtime));
						
						
					}
					
				}

			}
		}

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

}

class pos implements Comparable<pos> {
	int y, x, time;

	@Override
	public String toString() {
		return "pos [y=" + y + ", x=" + x + ", time=" + time + "]";
	}

	public pos(int y, int x, int time) {
		super();
		this.y = y;
		this.x = x;
		this.time = time;
	}

	@Override
	public int compareTo(pos o) {
		if(this.time<=o.time) {
			return this.time-o.time;
		}
		return o.time;
	}

	
}
