package Programers.day_20210220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class 프렌즈4블록 {
	static int m, n;
	static char[][] map = new char[m][n];
	static char[][] tmap=new char[m][n];//복제 
	static boolean[][] visit = new boolean[m][n];
	static int[] dx = { 1, 0, 1 };
	static int[] dy = { 0, 1, 1 };
	static HashSet<loc> loc = new HashSet<loc>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		String[] str = new String[m];
		for (int i = 0; i < m; i++) {
			str[i] = br.readLine();
		}
		int ans = solution(m, n, str);

	}

	public static int solution(int m, int n, String[] board) {

		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
			tmap[i]=board[i].toCharArray();
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				count = 0;
				loc.add(new loc(j, i));
				solve(i, j, 0);
				if (loc.size() == 4) {
				}
			}
		}

		int answer = 0;
		return answer;
	}

	static int count;

	public static void solve(int y, int x, int idx) {

		if(map[y][x]=='.') {
			map[y][x]=tmap[y][x];
			if(map[y][x]==map[y][x+1] && map[y][x]==map[y+1][x+1]) {
				map[y][x+1]='.';
				map[y+1][x+1]='.';
				count+=2;
			}
			else if(map[y][x]==map[y][x+1] && map[y][x]==map[y+1][x] &&map[y][x]== map[y+1][x+1]) {
				map[y+1][x]='.';
				map[y][x+1]='.';
				map[y+1][x+1]='.';
				count+=3;
			}
			else if(map[y][x]==map[y+1][x] &&map[y][x]== map[y+1][x+1]) {
				map[y+1][x]='.';
				map[y+1][x+1]='.';
				count+=2;
			}
			
		
		}
		if(map[y][x]==map[y][x+1] && map[y][x]==map[y+1][x] &&map[y][x]== map[y+1][x+1]) {
			map[y][x]='.';
			map[y+1][x]='.';
			map[y][x+1]='.';
			map[y+1][x+1]='.';
			count+=4;
		}
	}

	private static void move() {
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				int k = j;
				while (k < m-1 && map[k + 1][i] == '.') {
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
