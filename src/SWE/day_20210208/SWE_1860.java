package SWE.day_20210208;

import java.util.Arrays;
import java.util.Scanner;

public class SWE_1860 {
	static int food, N, M, K;
	static int time;
	static int idx;
	static int[] arr;
	static boolean flag;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for (int t = 1; t <= testCase; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			arr = new int[N + 1];
			for (int i = 1; i < N + 1; i++) {
				arr[i] = sc.nextInt();
			}
			// System.out.println(Arrays.toString(tmp));
			Arrays.sort(arr);// 1,2,3,4
			food = 0;
			time = 1;
			flag = false;

			check(1);
			if (flag) {
				System.out.println("#" + t + " " + "Possible");
			} else {
				System.out.println("#" + t + " " + "Impossible");

			}

		}
	}

	static void check(int i) {

		if (i == N + 1) {
			return;
		}

		while (arr[i] > time) {
			time++;
			if (time % M == 0) {
				food += K;
			}
		}
		

		if (food > 0) {
			flag = true;
			food--;
			check(i + 1);
		} else {
			flag = false;
			return;
		}

	}

}
