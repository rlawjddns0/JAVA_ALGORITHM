package BACK.day_20210201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_16926 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int N, M, rotation, num;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		rotation = Integer.parseInt(st.nextToken());
		num = Math.min(N, M) / 2;

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < rotation; i++) {
			rotationMap();
		}

		resultPrint();

	}

	private static void rotationMap() {

		for (int i = 0; i < num; i++) {
			// 네모들의 왼쪽 맨위의 좌표는 1,1 || 2,2 || 3,3 || ...
			int x = i;
			int y = i;
			int temp = arr[x][y]; // 첫번째 값을 담아놓고 연산 후에 넣어준다.

			int index = 0;

			while (index < 4) {

				int nx = x + dx[index];
				int ny = y + dy[index];

				if (nx < i || ny < i || nx > M - i + 1 || ny > N - i + 1) {
					index++;
				} else {
					arr[x][y] = arr[nx][ny];

					x = nx;
					y = ny;
				}

			} // while
			arr[i + 1][i] = temp;
		} // for

	}// circulate()

	private static void resultPrint() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
