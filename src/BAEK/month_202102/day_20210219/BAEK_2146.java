package BAEK.month_202102.day_20210219;

/*
 * 다시풀기~~~
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2146 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("섬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					dfs(j, i, count++);
				}
			}
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					int d = bfs(i, j);
					if (d != -1) {
						ans = Math.min(ans, d);
					}
				}
			}
		}

		System.out.println(ans);

	}

	static class Point {
		int x;
		int y;
		int d;// 이 지점에서 갈 수 있는 거리

		Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	private static int bfs(int i, int j) {
		// TODO Auto-generated method stub
		Queue<Point> q = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		q.offer(new Point(j, i, 0));
		v[i][j] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !v[ny][nx] && map[ny][nx] == 0) {
					v[ny][nx] = true;
					q.offer(new Point(nx, ny, p.d + 1));

				}

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !v[ny][nx] && map[ny][nx] != 0
						&& map[ny][nx] != map[i][j]) {
					return p.d;
				}

			}
		}

		return -1;
	}

	public static void dfs(int x, int y, int count) {

		map[y][x] = count;
		visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visit[ny][nx] && map[ny][nx] == 1) {
				dfs(nx, ny, count);
			}
		}

	}
}