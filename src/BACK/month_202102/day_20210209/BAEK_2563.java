package BACK.month_202102.day_20210209;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_2563 {
	static int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		map = new int[101][101];
		for (int t = 0; t < N; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int i = y; i < y + 10; i++) {
				for (int j = x; j < x + 10; j++) {
					if (map[i][j] != 1) {
						map[i][j] = 1;
					}
				}
			}
//			for (int[] tp : map) {
//				System.out.println(Arrays.toString(tp));
//			}

		}
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (map[i][j] == 1) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}

}
