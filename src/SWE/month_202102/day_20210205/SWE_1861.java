package SWE.month_202102.day_20210205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_1861 {
	static int ans;
	static int[][] map;
	static int N;
	static int count;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int t = 1; t <= testCase; t++) {
			int answer=Integer.MIN_VALUE;//count와 비교 할 값
			int firstR=Integer.MAX_VALUE;//최대값을 가진 경로가 겹치면 비교 할 값
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}

			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count=1;//일단 고를때 +1
					recursive(i, j);//1씩 증가하는 경로 찾음
					if(count==answer) {//
						firstR=Math.min(firstR, map[i][j]);
					}
					else if(count>answer) {
						answer=count;
						firstR=map[i][j];//가장 처음에 찾은 방
					}
					
				}

			}

			System.out.println("#" + t + " " + firstR + " " + answer);

		}
	}

	static void recursive(int x, int y) {

		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (map[x][y] + 1 == map[nx][ny]) {// 1차이면
					count++;
					recursive(nx, ny);
				}
			}
		}
		
	}
}
