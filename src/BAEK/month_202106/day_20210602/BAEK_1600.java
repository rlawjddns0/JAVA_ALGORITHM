package BAEK.month_202106.day_20210602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_1600 {
	static int K, W, H;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[] DY = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int[] DX = { -2, -2, -2, -1, 1, 2, 2, 1 };
	static boolean[][][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		visit = new boolean[H][W][K + 1];
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(0, 0);

	}

	private static void bfs(int i, int j) {
		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(i, j, 0, 0));
		while (!q.isEmpty()) {
			pos tmp = q.poll();
			int cy = tmp.y;
			int cx = tmp.x;
			int ccnt = tmp.cnt;
			int ck = tmp.k;
			if (cy == H - 1 && cx == W - 1) {
				System.out.println(ccnt);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];
				if (ny >= H || ny < 0 || nx >= W || nx < 0)
					continue;
				if (map[ny][nx] == 1 || visit[ny][nx][ck])
					continue;
				q.offer(new pos(ny, nx, ccnt + 1, ck));
				visit[ny][nx][ck] = true;
			}
			if (ck+1 <=K) {

				for (int d = 0; d < 8; d++) {
					int nx = cx + DX[d];
					int ny = cy + DY[d];
					if (ny >= H || ny < 0 || nx >= W || nx < 0)
						continue;
					if (map[ny][nx] == 1 || visit[ny][nx][ck +1])
						continue;
					q.offer(new pos(ny, nx, ccnt + 1, ck + 1));
					visit[ny][nx][ck + 1] = true;
				}
			}

		}

		System.out.println("-1");
	}

}

class pos {
	int y, x, cnt, k;

	public pos(int y, int x, int cnt, int k) {
		super();
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.k = k;
	}

	@Override
	public String toString() {
		return "pos [y=" + y + ", x=" + x + ", k=" + k + "]";
	}

}