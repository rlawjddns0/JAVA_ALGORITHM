package SWE.month_202104.day_20210415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_1949 {
	static int N, K;
	static int[][] map;
	static boolean[][] visit;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			ans=Integer.MIN_VALUE;
			map = new int[N][N];
			visit = new boolean[N][N];
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						
						dfs(i, j, false, 1);
					}
				}
			}

			System.out.println("#" + t + " " + ans);

		}

	}

	private static void dfs(int y, int x, boolean flag, int cnt) {
		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		visit[y][x] = true;
		ans = Math.max(ans, cnt);
		// System.out.println(map[y][x]);
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx >= N || nx < 0 || ny >= N || ny < 0 || visit[ny][nx])
				continue;
			if (map[ny][nx] < map[y][x]) {
				visit[ny][nx]=true;
				dfs(ny, nx, flag, cnt + 1);
				visit[ny][nx]=false;


			} else if (map[ny][nx] >= map[y][x] &&map[ny][nx]-K<map[y][x] && !flag) {

				for (int minK = 1; minK <= K; minK++) {
					if (map[ny][nx] - minK < map[y][x]) {
						// break;
						map[ny][nx] -= minK;
						visit[ny][nx]=true;
						dfs(ny, nx, true, cnt + 1);
						map[ny][nx] += minK;
						visit[ny][nx]=false;
					}
				}

			}
		}
		visit[y][x] = false;
	}

}
