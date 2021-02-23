package Programers.day_20210220;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 프렌즈4블록 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("프렌즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		String[] str = new String[m];
		for (int i = 0; i < m; i++) {
			str[i] = br.readLine();
		}

		int ans = solution(m, n, str);
	
		System.out.println(ans);
	}

	static int m, n;
	static char[][] map = new char[m][n];
	static char[][] tmap = new char[m][n];// 복제

	public static int solution(int m, int n, String[] board) {

		map = new char[m][n];
		tmap = new char[m][n];
		for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
			tmap[i] = board[i].toCharArray();
		}
		
		//한번 돌린다.
		int temp=0;
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				solve(i, j);
			}
		}
		move();
		temp=count;
		for (int i = 0; i < m; i++) {
			tmap[i] = map[i].clone();
		}
		
		
		//반복
		while(true) {
			count=0;
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					solve(i, j);
				}
			}
			move();
			if(count==temp)break;//직전 깨진 블록의 수와 지금 깨진 블록의 수가 같으면 더이상 돌 필요 없다
			else temp=count;//다르면 블록 갱신
			for (int i = 0; i < m; i++) {
				tmap[i] = map[i].clone();//임시 맵에 복제
			}
		}
		
		
		

		return count;
	}

	static int count;

	public static void solve(int y, int x) {

		if (map[y][x] == '.') {
			char tmp = tmap[y][x];
			if (tmp == tmap[y][x + 1] && tmp == tmap[y + 1][x] && tmp == tmap[y + 1][x + 1]) {//.이 나와 있는 위치에서 검사
				map[y + 1][x] = '.';
				map[y][x + 1] = '.';
				map[y + 1][x + 1] = '.';
			}

		}
		if (map[y][x] == tmap[y][x + 1] && map[y][x] == tmap[y + 1][x] && map[y][x] == tmap[y + 1][x + 1]) {//2*2 블록이 같으면
			map[y][x] = '.';
			map[y + 1][x] = '.';
			map[y][x + 1] = '.';
			map[y + 1][x + 1] = '.';

		}
		
	}

	private static void move() {//중력
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
		for (int i = 0; i < m; i++) {//중력 후 블록 사라진 갯수 확인
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '.')
					count++;
			}
		}
	}
}
