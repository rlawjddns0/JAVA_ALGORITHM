package BAEK.month_202102.day_20210219;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BAEK_11559 {
	static char[][] map;
	static int cnt;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static boolean[][] visit;
	static int size;
	static ArrayList<loc> l = new ArrayList<loc>();
	static HashSet<loc> tt = new HashSet<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		visit = new boolean[12][6];
		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int x = 0, y = 0;
		while (true) {
			flag = false;
			visit = new boolean[12][6];
			for (int j = 11; j >= 0; j--) {
				for (int i = 0; i < 6; i++) {
					if (map[j][i] != '.') {
						visit[j][i] = true;
						size = 0;
						tt.clear();
						tt.add(new loc(i, j));// Ã³À½ ÁÂÇ¥
						size = 1;
						solve(i, j, visit);
						if (tt.size() >= 4) {
							flag = true;
							remove(tt);

						}
					}
				}
			}

			if (!flag) {
				break;
			} else {
				move();
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static boolean flag;

	private static void solve(int x, int y, boolean[][] visit) {
		// TODO Auto-generated method stub

		int nx = 0;
		int ny = 0;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if (nx >= 0 && nx < 6 && ny >= 0 && ny < 12 && map[y][x] == map[ny][nx] && !visit[ny][nx]) {
				visit[ny][nx] = true;
				tt.add(new loc(nx, ny));
				solve(nx, ny, visit);
			}
		}
	}

	private static void remove(HashSet<loc> tmp) {
		for (loc loc : tmp) {
			map[loc.y][loc.x] = '.';
		}
	}

	private static void move() {
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j >= 0; j--) {
				int k = j;
				while (k < 11 && map[k + 1][i] == '.') {
					char tmp = map[k][i];
					map[k][i] = '.';
					map[k + 1][i] = tmp;
					k++;
				}
			}

		}
	}

}

class loc {
	int x;
	int y;
	loc(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(x, y);

	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof loc))
			return false;
		loc p = (loc) obj;
		return this.x == (p.x) && this.y == p.y;

	};

}