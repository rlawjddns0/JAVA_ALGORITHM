package BAEK.month_202102.day_20210215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_2072 {
	static int N;
	static int map[][];
	static int check[][];// 1:Èæ, 2:¹é
	static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int count1;
	static int count2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		map = new int[20][20];
		check = new int[20][20];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int x = 0, y = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			if (i % 2 == 0) {// Â¦= ¹é
				map[x][y] = 2;
				for (int dir = 0; dir < 4; dir++) {
					count1 = 0;
					solve1(x, y, dir);
					solve1(x,y,dir+4);
					if (count1 == 6) {
						result.add(i);
					}
				}
			} else {
				map[x][y] = 1;
				for (int dir = 0; dir < 4; dir++) {
					count2 = 0;
					solve2(x, y, dir);
					solve2(x,y,dir+4);
					if (count2 == 6) {
						result.add(i);
					}
				}
			}

		}

		if(result.size()==0) {
			System.out.println("-1");
		}
		else
		{
			System.out.println(result.get(0));
		}

	}

	public static void solve1(int x, int y, int dir) {// Â¦¼ö °Ë»ç

		if (map[x][y] == 1 || map[x][y] == 0) {
			return;
		}
		count1++;
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (nx >= 1 && nx < 20 && ny >= 1 && ny < 20) {
			solve1(nx, ny, dir);
		}

	}

	public static void solve2(int x, int y, int dir) {// È¦¼ö °Ë»ç

		if (map[x][y] == 2 || map[x][y] == 0) {
			return;
		}
		count2++;
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (nx >= 1 && nx < 20 && ny >= 1 && ny < 20) {
			solve2(nx, ny, dir);
		}

	}

}
