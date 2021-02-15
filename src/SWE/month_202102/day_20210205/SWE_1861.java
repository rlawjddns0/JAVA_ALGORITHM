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
			int answer=Integer.MIN_VALUE;//count�� �� �� ��
			int firstR=Integer.MAX_VALUE;//�ִ밪�� ���� ��ΰ� ��ġ�� �� �� ��
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
					count=1;//�ϴ� ���� +1
					recursive(i, j);//1�� �����ϴ� ��� ã��
					if(count==answer) {//
						firstR=Math.min(firstR, map[i][j]);
					}
					else if(count>answer) {
						answer=count;
						firstR=map[i][j];//���� ó���� ã�� ��
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
				if (map[x][y] + 1 == map[nx][ny]) {// 1���̸�
					count++;
					recursive(nx, ny);
				}
			}
		}
		
	}
}
