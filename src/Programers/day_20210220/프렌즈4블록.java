package Programers.day_20210220;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class «¡∑ª¡Ó4∫Ì∑œ {
	static int m, n;
	static char[][] map = new char[m][n];
	static char[][] tmap = new char[m][n];// ∫π¡¶
	static boolean[][] visit = new boolean[m][n];
	static int[] dx = { 1, 0, 1 };
	static int[] dy = { 0, 1, 1 };
	static HashSet<loc> loc = new HashSet<loc>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("«¡∑ª¡Ó.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		String[] str = new String[m];
		for (int i = 0; i < m; i++) {
			str[i] = br.readLine();
		}

		int ans = solution(m, n, str);
		for (int i = 0; i < m; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(ans);
	}

	public static int solution(int m, int n, String[] board) {

		map = new char[m][n];
		tmap = new char[m][n];
		for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
			tmap[i] = board[i].toCharArray();
		}
		for (int i = 0; i < m; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		for(int p=0; p<m; p++) {
			flag = false;
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					solve(i, j);
				}
			}
			
			move();
			
		}
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]=='.')
					count++;
			}
		}
	
//		solve(1,0);
//		//move();
//		for (int i = 0; i < m; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();
//		solve(2,1);
//		move();
	return count;}

	static int count;
	static boolean flag;

	public static void solve(int y, int x) {

		if (map[y][x] == '.') {
			char tmp = tmap[y][x];
//			if (tmp == map[y][x + 1] && tmp == map[y + 1][x + 1]) {
//				flag = true;
//				map[y][x + 1] = '.';
//				map[y + 1][x + 1] = '.';
//				count += 2;
//			} else if (tmp == map[y][x + 1] && tmp == map[y + 1][x] && tmp == map[y + 1][x + 1]) {
//				flag = true;
//				map[y + 1][x] = '.';
//				map[y][x + 1] = '.';
//				map[y + 1][x + 1] = '.';
//				count += 3;
//			} else if (tmp == map[y + 1][x] && tmp == map[y + 1][x + 1]) {
//				flag = true;
//				map[y + 1][x] = '.';
//				map[y + 1][x + 1] = '.';
//				count += 2;
//			}
			if (tmp == tmap[y][x + 1] && tmp == tmap[y + 1][x] && tmp == tmap[y + 1][x + 1]) {
				flag = true;
				map[y + 1][x] = '.';
				map[y][x + 1] = '.';
				map[y + 1][x + 1] = '.';
				
				// count += 3;
			}

		}
		if (map[y][x] == map[y][x + 1] && map[y][x] == map[y + 1][x] && map[y][x] == map[y + 1][x + 1]) {
			flag = true;
			map[y][x] = '.';
			map[y + 1][x] = '.';
			map[y][x + 1] = '.';
			map[y + 1][x + 1] = '.';
			
			// count += 4;

		}
	}

	private static void move() {
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				int k = j;
				while (k < m - 1 && map[k + 1][i] == '.') {
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
