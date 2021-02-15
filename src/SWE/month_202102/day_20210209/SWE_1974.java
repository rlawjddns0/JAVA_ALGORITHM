package SWE.month_202102.day_20210209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_1974 {
	static int[][] arr;
	static boolean check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= testCase; t++) {
			arr = new int[9][9];
			check = true;
			for (int i = 0; i < 9; i++) {

				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			check(arr);//3*3
			if (!check) {
				System.out.println("#" + t + " " + "0");
				continue;
			}
			check2(arr);//가로
			if (!check) {
				System.out.println("#" + t + " " + "0");
				continue;
			}
			check3(arr);//세로
			if (!check) {
				System.out.println("#" + t + " " + "0");
				continue;
			}

			System.out.println("#" + t + " " + "1");

		}

	}

	public static void check(int arr[][]) {

		L:for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				int sum = 0;
				for (int p = i; p < i + 3; p++) {
					for (int k = j; k < j + 3; k++) {
						sum += arr[p][k];

					}
				}
				if (sum != 45) {
					check = false;
					break L;
				}
			}
		}

	}

	public static void check2(int arr[][]) {


		L:for (int i = 0; i < 9; i++) {
			int sum = 0;
			for (int j = 0; j < 9; j++) {
				sum += arr[i][j];
			}
			if (sum != 45) {
				check = false;
				break L;
			}
		}

	}

	public static void check3(int arr[][]) {


		L:for (int i = 0; i < 9; i++) {
			int sum = 0;
			for (int j = 0; j < 9; j++) {
				sum += arr[j][i];
			}
			if (sum != 45) {
				check = false;
				break L;
			}
		}

	}

}
