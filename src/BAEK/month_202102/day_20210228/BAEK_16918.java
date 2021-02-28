package BAEK.month_202102.day_20210228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BAEK_16918 {
	static int R, C, N;
	static bomb[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<bomb> b = new ArrayList<bomb>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		N = sc.nextInt();
		map = new bomb[R][C];
		for (int i = 0; i < R; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 0; j < C; j++) {
				if (tmp[j] == 'O') {
					map[i][j] = new bomb(j, i, 1, tmp[j]);
				} else {
					map[i][j] = new bomb(j, i, 0, tmp[j]);
				}
			}
		}

		for (int i = 1; i <= N - 1; i++) {
			time();
			setBomb();
			bom();

		}
		System.out.println();
		print();

	}

	public static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j].c);
			}
			System.out.println();
		}

	}

	public static void bom() {
		b=new ArrayList<bomb>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].c == 'O' && map[i][j].time >= 3) {
					b.add(map[i][j]);
				}
			}
		}
		for (int i = 0; i < b.size(); i++) {
			map[b.get(i).y][b.get(i).x].c='.';
			for (int d = 0; d < 4; d++) {
				int nx = b.get(i).x + dx[d];
				int ny = b.get(i).y + dy[d];
				if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
					map[ny][nx].c = '.';
				}
			}
		}
	}

	public static void time() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].c == 'O')
					map[i][j].time++;
			}
		}
	}

	public static void setBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].c == '.') {
					map[i][j].x = j;
					map[i][j].y = i;
					map[i][j].c = 'O';
					map[i][j].time = 0;
				}
			}
		}
	}

}

class bomb {
	int x;
	int y;
	char c;
	int time;

	bomb(int x, int y, int time, char c) {
		this.x = x;
		this.y = y;
		this.time = time;
		this.c = c;
	}

	@Override
	public String toString() {
		return "bomb [x=" + x + ", y=" + y + ", time=" + time + "]";
	}

}