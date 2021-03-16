package BAEK.month_202103.day_20210313;

import java.util.Scanner;

public class BAEK_2933 {
	static int R, C, N;
	static int[] spear;
	static char[][] map;
	static boolean[][] visit;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		int dir = 1;// 던지는 방향 1:-> -1:<-
		for (int i = 0; i < R; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp[j];
			}
		}

		N = sc.nextInt();
		spear = new int[N];
		for (int i = 0; i < N; i++) {
			spear[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			throw_spear(R - spear[i], dir);// 창 던지기
			dir *= -1;// 던지고 나서 방향을 바꿔준다
		}

		print();

	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void print_visit() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void throw_spear(int r, int dir) {
		int start = 0;
		if (dir == 1) {// ->
			for (int i = 0; i < C; i++) {
				if (map[r][i] == 'x') {// 창이 미네랄과 만나면
					map[r][i] = '.';// 부숴버리고
					if (check_cluster()) {//따로 떨어져 있는 클러스터 확인
						gravity();//있으면 중력
					}
					break;
				}
			}
		} else {// <-
			for (int i = C - 1; i >= 0; i--) {
				if (map[r][i] == 'x') {
					map[r][i] = '.';
					if (check_cluster()) {
						gravity();
					}
					break;
				}
			}
		}

	}

	private static void gravity() {
		int min = Integer.MAX_VALUE;
		int cnt = 0;

		for (int i = 0; i < C; i++) {

			for (int j = R - 1; j >= 0; j--) {

				if (map[j][i] == 'x' && visit[j][i] == false) {// 미네랄인데 따로 떨어져 있으면
					cnt = 0;
					int tj = j;
					int ti = i;
					while (true) {
						tj++;
						if (tj >= R || map[tj][ti] == 'x' && visit[tj][ti] == true) {// 땅에 떨어질때나 땅에 붙어 있는 미네랄을 만나면 탈출
							break;
						}
						cnt++;

					}
					min = Math.min(cnt, min);// 내리는 최소거리
				}

			}

		}

		if (min < 101) {// 위에서 최소거리가 안나오면-> 즉 따로 떨어져 있는 클러스터가 없으면 Integer.MAX_VALUE값 나와서 그거 걸러줌
			for (int i = R - 1; i >= 0; i--) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'x' && !visit[i][j]) {
						map[i + min][j] = 'x';
						map[i][j] = '.';
					}
				}
			}
		}

	}

	private static boolean check_cluster() {
		visit = new boolean[R][C];
		for (int j = 0; j < C; j++) {
			if (map[R - 1][j] == 'x') {// 땅에 붙어있는거부터 시작
				dfs(R - 1, j);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'x' && visit[i][j] == false) {
					return true;
				}
			}
		}

		return false;
	}

	private static void dfs(int i, int j) {
		int dj[] = { 1, 0, -1, 0 };// 사방으로 탐색하면서 땅에 붙어 있는거 찾기
		int di[] = { 0, 1, 0, -1 };
		visit[i][j] = true;// 땅에 붙어 있는건 참으로 바꿔줌-> 결국 따로 떨어져 있는건 false값임
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni >= 0 && ni < R && nj >= 0 && nj < C && !visit[ni][nj] && map[ni][nj] == 'x') {
				dfs(ni, nj);
			}
		}

	}

}
