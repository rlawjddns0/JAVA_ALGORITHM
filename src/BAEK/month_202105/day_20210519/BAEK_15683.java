package BAEK.month_202105.day_20210519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_15683 {
	static String[] dir = { "", "0", "02", "03", "023", "0123" };
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int N, M;
	static ArrayList<cctv> c = new ArrayList<cctv>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int tp = Integer.parseInt(st.nextToken());
				if (tp >= 1 && tp <= 5)
					c.add(new cctv(i, j, tp));
				map[i][j] = tp;
			}
		}

		dfs(0, -1);
		System.out.println(ans);
	}

	static int ans = Integer.MAX_VALUE;

	private static void dfs(int cnt, int check) {

		if (cnt == c.size()) {
			ans = Math.min(ans, check());

			return;
		}

		int x = c.get(cnt).x;
		int y = c.get(cnt).y;

		for (int d = 0; d < 4; d++) {
			for (int s = 0; s < dir[c.get(cnt).n].length(); s++) {
				int nx = x + dx[((dir[c.get(cnt).n].charAt(s) - '0') + d) % 4];
				int ny = y + dy[((dir[c.get(cnt).n].charAt(s) - '0') + d) % 4];

				while (true) {
					if (nx < 0 || nx >= M || ny < 0 || ny >= N)
						break;
					if (map[ny][nx] == 6)
						break;
					if (map[ny][nx] == 0) {
						map[ny][nx] = check;
					} else {
						nx = nx + dx[((dir[c.get(cnt).n].charAt(s) - '0') + d) % 4];
						ny = ny + dy[((dir[c.get(cnt).n].charAt(s) - '0') + d) % 4];
					}
				}
			}
			dfs(cnt + 1, check - 1);
			for (int s = 0; s < dir[c.get(cnt).n].length(); s++) {
				int nx = x + dx[((dir[c.get(cnt).n].charAt(s) - '0') + d) % 4];
				int ny = y + dy[((dir[c.get(cnt).n].charAt(s) - '0') + d) % 4];

				while (true) {
					if (nx < 0 || nx >= M || ny < 0 || ny >= N)
						break;
					if (map[ny][nx] == 6)
						break;

					if (map[ny][nx] == check) {
						map[ny][nx] = 0;
					} else {
						nx = nx + dx[((dir[c.get(cnt).n].charAt(s) - '0') + d) % 4];
						ny = ny + dy[((dir[c.get(cnt).n].charAt(s) - '0') + d) % 4];

					}
				}
			}

		}

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int check() {

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}

		return cnt;
	}
}

class cctv {
	int y, x, n;

	public cctv(int y, int x, int n) {
		super();
		this.y = y;
		this.x = x;
		this.n = n;
	}

}