package BAEK.month_202102.day_20210225;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_2804 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		int N = str1.length();
		int M = str2.length();
		char[][] map = new char[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				map[i][j] = '.';
		}
		int y = 0, x = 0;
		L:for (int i = 0; i < str1.length() ; i++) {
			for (int j = 0; j < str2.length() ; j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					x = j;
					y = i;
					break L;
				}
			}
		}
		//System.out.println(x + " " + y);
		for (int i = 0; i < M; i++) {
			map[i][y] = str2.charAt(i);
		}
		for (int j = 0; j < N; j++) {
			map[x][j] = str1.charAt(j);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

}
