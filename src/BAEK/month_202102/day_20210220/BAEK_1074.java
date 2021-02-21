package BAEK.month_202102.day_20210220;

import java.util.Scanner;

public class BAEK_1074 {
	static int N, r, c;
	static int l;
	static int count;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		l = (int) Math.pow(2, N);
		solve(0, 0, l);
	}

	private static void solve(int i, int j, int n) {
		// TODO Auto-generated method stub

		if (i == r && j == c) {
			System.out.println(count);
			return;
		}

		if (r >= i && r < i + n && c >= j && c < j + n) {// 현재 크기 범주 내에 있으면
			solve(i, j, n / 2);
			solve(i, j + n / 2, n / 2);
			solve(i + n / 2, j, n / 2);
			solve(i + n / 2, j + n / 2, n / 2);
		} else {
			count += n * n;
		}
	}

}
