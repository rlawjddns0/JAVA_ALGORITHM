package Programers.day_20210220;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ������4��� {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("������.txt"));
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
	static char[][] tmap = new char[m][n];// ����

	public static int solution(int m, int n, String[] board) {

		map = new char[m][n];
		tmap = new char[m][n];
		for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
			tmap[i] = board[i].toCharArray();
		}
		
		//�ѹ� ������.
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
		
		
		//�ݺ�
		while(true) {
			count=0;
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					solve(i, j);
				}
			}
			move();
			if(count==temp)break;//���� ���� ����� ���� ���� ���� ����� ���� ������ ���̻� �� �ʿ� ����
			else temp=count;//�ٸ��� ��� ����
			for (int i = 0; i < m; i++) {
				tmap[i] = map[i].clone();//�ӽ� �ʿ� ����
			}
		}
		
		
		

		return count;
	}

	static int count;

	public static void solve(int y, int x) {

		if (map[y][x] == '.') {
			char tmp = tmap[y][x];
			if (tmp == tmap[y][x + 1] && tmp == tmap[y + 1][x] && tmp == tmap[y + 1][x + 1]) {//.�� ���� �ִ� ��ġ���� �˻�
				map[y + 1][x] = '.';
				map[y][x + 1] = '.';
				map[y + 1][x + 1] = '.';
			}

		}
		if (map[y][x] == tmap[y][x + 1] && map[y][x] == tmap[y + 1][x] && map[y][x] == tmap[y + 1][x + 1]) {//2*2 ����� ������
			map[y][x] = '.';
			map[y + 1][x] = '.';
			map[y][x + 1] = '.';
			map[y + 1][x + 1] = '.';

		}
		
	}

	private static void move() {//�߷�
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
		for (int i = 0; i < m; i++) {//�߷� �� ��� ����� ���� Ȯ��
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '.')
					count++;
			}
		}
	}
}
