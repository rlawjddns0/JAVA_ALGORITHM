package SWE.month_202104.day_20210415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWE_1953 {
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx1 = { 1, 0, -1, 0 };
	static int[] dy1 = { 0, 1, 0, -1 };
	static int[] dx2 = { 0, 0 };
	static int[] dy2 = { 1, -1 };
	static int[] dx3 = { 1, -1 };
	static int[] dy3 = { 0, 0 };
	static int[] dx4 = { 1, 0 };
	static int[] dy4 = { 0, -1 };
	static int[] dx5 = { 1, 0 };
	static int[] dy5 = { 0, 1 };
	static int[] dx6 = { -1, 0 };
	static int[] dy6 = { 0, 1 };
	static int[] dx7 = { -1, 0 };
	static int[] dy7 = { 0, -1 };
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());// ¸Ê Å©±â
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];
			R = Integer.parseInt(st.nextToken());// ¸ÇÈ¦ À§Ä¡
			C = Integer.parseInt(st.nextToken());
			ans = 0;
			L = Integer.parseInt(st.nextToken());// ½Ã°£

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs(R, C);

			for (int i = 0; i < N; i++) {
				//System.out.println(Arrays.toString(visit[i]));
				for (int j = 0; j < M; j++) {
					if (visit[i][j])
						ans++;
				}
			}
			System.out.println("#" + t + " " + ans);

		}

	}

	private static void bfs(int y, int x) {

		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(y, x, map[y][x]));
		visit[y][x] = true;

		for (int i = 1; i < L; i++) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				pos tmp = q.poll();
				int dir = tmp.dir;

				if (dir == 1) {
					for (int d = 0; d < dx1.length; d++) {
						int nx = tmp.x + dx1[d];
						int ny = tmp.y + dy1[d];
						if (nx >= M || nx < 0 || ny >= N || ny < 0)
							continue;
						if(visit[ny][nx])continue;
						int ndir = map[ny][nx];
						if (d == 0) {
							if (ndir == 3 || ndir == 6 || ndir == 7 || ndir == 1) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						} else if (d == 1) {
							if (ndir == 1 || ndir == 2 || ndir == 4 || ndir == 7) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						} else if (d == 2) {
							if (ndir == 1 || ndir == 3 || ndir == 4 || ndir == 5) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						} else if (d == 3) {
							if (ndir == 1 || ndir == 2 || ndir == 5 || ndir == 6) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						}
					}
				} else if (dir == 2) {
					for (int d = 0; d < dx2.length; d++) {
						int nx = tmp.x + dx2[d];
						int ny = tmp.y + dy2[d];
						if (nx >= M || nx < 0 || ny >= N || ny < 0)
							continue;
						if(visit[ny][nx])continue;

						int ndir = map[ny][nx];
						if (d == 0) {//ÇÏ
							if (ndir == 1 || ndir == 2 || ndir == 7 || ndir == 4) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						} else if (d == 1) {
							if (ndir == 1 || ndir == 2 || ndir == 5 || ndir == 6) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						}
					}
				}
				if (dir == 3) {
					for (int d = 0; d < dx3.length; d++) {
						int nx = tmp.x + dx3[d];
						int ny = tmp.y + dy3[d];
						if (nx >= M || nx < 0 || ny >= N || ny < 0)
							continue;
						int ndir = map[ny][nx];
						if (d == 0) {
							if (ndir == 3 || ndir == 1 || ndir == 7 || ndir == 6) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						} else if (d == 1) {
							if (ndir == 1 || ndir == 3 || ndir == 4 || ndir == 5) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						}
					}
				} else if (dir == 4) {
					for (int d = 0; d < dx4.length; d++) {
						int nx = tmp.x + dx4[d];
						int ny = tmp.y + dy4[d];
						if (nx >= M || nx < 0 || ny >= N || ny < 0)
							continue;
						if(visit[ny][nx])continue;

						int ndir = map[ny][nx];
						if (d == 0) {
							if (ndir == 3 || ndir == 1 || ndir == 7 || ndir == 6) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						} else if (d == 1) {
							if (ndir == 1 || ndir == 2 || ndir == 5 || ndir == 6) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						}
					}
				} else if (dir == 5) {
					for (int d = 0; d < dx5.length; d++) {
						int nx = tmp.x + dx5[d];
						int ny = tmp.y + dy5[d];
						if (nx >= M || nx < 0 || ny >= N || ny < 0)
							continue;
						if(visit[ny][nx])continue;

						int ndir = map[ny][nx];
						if (d == 0) {
							if (ndir == 3 || ndir == 1 || ndir == 7 || ndir == 6) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						} else if (d == 1) {
							if (ndir == 1 || ndir == 2 || ndir == 4 || ndir == 7) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						}
					}
				} else if (dir == 6) {
					for (int d = 0; d < dx6.length; d++) {
						int nx = tmp.x + dx6[d];
						int ny = tmp.y + dy6[d];
						if (nx >= M || nx < 0 || ny >= N || ny < 0)
							continue;
						if(visit[ny][nx])continue;

						int ndir = map[ny][nx];
						if (d == 0) {
							if (ndir == 1 || ndir == 3 || ndir == 4 || ndir == 5) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						} else if (d == 1) {
							if (ndir == 1 || ndir == 2 || ndir == 4 || ndir == 7) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						}
					}
				} else if (dir == 7) {
					for (int d = 0; d < dx7.length; d++) {
						int nx = tmp.x + dx7[d];
						int ny = tmp.y + dy7[d];
						if (nx >= M || nx < 0 || ny >= N || ny < 0)
							continue;
						if(visit[ny][nx])continue;

						int ndir = map[ny][nx];
						if (d == 0) {
							if (ndir == 1 || ndir == 3 || ndir == 4 || ndir == 5) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						} else if (d == 1) {
							if (ndir == 1 || ndir == 2 || ndir == 5 || ndir == 6) {
								q.offer(new pos(ny, nx, ndir));
								visit[ny][nx] = true;
							}
						}
					}
				}

			}
		}
	}

}

class pos {
	int y, x, dir;

	@Override
	public String toString() {
		return "pos [y=" + y + ", x=" + x + ", dir=" + dir + "]";
	}

	public pos(int y, int x, int dir) {
		super();
		this.y = y;
		this.x = x;
		this.dir = dir;
	}

}
