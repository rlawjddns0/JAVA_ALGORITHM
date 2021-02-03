package BACK.day_20210203;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_16935 {
	static int N, M, R;
	static int[][] arr;
	static int num;

	private static void print() {

		for (int[] is : arr) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private static void TtoB() {// 상하반전
		for(int c=0; c<arr[0].length; c++) {
			for(int r1=0, r2=arr.length-1; r1<r2; r1++,r2--) {
				int temp=arr[r1][c];
				arr[r1][c]=arr[r2][c];
				arr[r2][c]=temp;
			}
		}
	}

	private static void LtoR() {// 좌우
		for(int r=0; r<arr.length; r++) {
			for(int c1=0,c2=arr[0].length-1; c1<c2; c1++,c2--) {
				int temp=arr[r][c1];
				arr[r][c1]=arr[r][c2];
				arr[r][c2]=temp;
			}
		}
	}

	private static void rotation90() {// 90도 돌리기
		int[][] temp = new int[arr[0].length][arr.length];

		for (int r = 0; r < arr.length; ++r) {
			for (int c = 0; c < arr[0].length; ++c) {
				temp[c][arr.length - 1 - r] = arr[r][c];
			}
		}

		arr = temp;

	}

	private static void rotation_r_90() {// -90도 돌리기

		int[][] temp = new int[arr[0].length][arr.length];

		for (int r = 0; r < temp.length; ++r) {
			for (int c = 0; c < temp[0].length; ++c) {
				temp[r][c] = arr[c][temp.length - 1 - r];
			}
		}

		arr = temp;

	}

	private static void five() {
		int[][] temp = new int[arr.length][arr[0].length];
		// 1->2
		int N=arr.length;
		int M=arr[0].length;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j + M / 2] = arr[i][j];
			}
		} // 2->3
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i + N / 2][j] = arr[i][j];
			}
		}
		// 3->4
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i][j - M / 2] = arr[i][j];
			}
		}
		// 4->3
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i - N / 2][j] = arr[i][j];
			}
		}
		arr = temp;
	}

	private static void six() {
		int[][] temp = new int[arr.length][arr[0].length];
		int N=arr.length;
		int M=arr[0].length;
		// 1->4
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i + N / 2][j] = arr[i][j];
			}
		} // 4->3
		for (int i = N / 2; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				temp[i][j + M / 2] = arr[i][j];
			}
		}
		// 3->2
		for (int i = N / 2; i < N; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i - N / 2][j] = arr[i][j];
			}
		}
		// 2->1
		for (int i = 0; i < N / 2; i++) {
			for (int j = M / 2; j < M; j++) {
				temp[i][j - M / 2] = arr[i][j];
			}
		}
		arr = temp;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < R; i++) {
			int num = Integer.parseInt(st.nextToken());
			switch (num) {
			case 1:
				TtoB();
				break;
			case 2:
				LtoR();
				break;
			case 3:
				rotation90();
				break;
			case 4:
				rotation_r_90();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			}
		}
		print();

	}

}
