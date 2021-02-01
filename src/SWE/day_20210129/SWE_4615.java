package SWE.day_20210129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SWE_4615 extends java.lang.Object{

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 0; t < testCase; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(map[0], 0);// 바둑판 0으로 초기화
			}

			map[(N / 2) - 1][(N / 2) - 1] = 2;
			map[(N / 2) - 1][(N / 2) - 1 + 1] = 1;
			map[(N / 2) - 1 + 1][(N / 2) - 1] = 1;
			map[(N / 2) - 1 + 1][(N / 2) - 1 + 1] = 2;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());// 1 흑돌 , 2 백돌

				
				int nx = (x - 1);
				int ny = (y - 1);
				map[nx][ny]=color;

				
				for (int k = 0; k < 8; k++) {
					
					int nx1 = nx;
					int ny1 = ny;
					int count = 0;
					while (true) {
						nx1 += dx[k];// 한칸 더
						ny1 += dy[k];// 한칸 더

						if (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= N || map[nx1][ny1]==0) {//경계밖이거나 빈 공간이 나오면

							break;
						}

						if (map[nx1][ny1] != color) {// map을 벗어나지 않고 지금 현재 내가 놓은 돌과 다른경우
							count++;
						} else if (map[nx1][ny1] == color) {//내가 둔 돌과 같은 색이 있으면
							
							for (int g = 0; g < count; g++) {// 왔던만큼 다시 거꾸로
								nx1 -= dx[k];
								ny1 -= dy[k];
								if (map[nx1][ny1] == 0)// 0 건너 뜀
									continue;
								map[nx1][ny1] = color;
							}
							break;
						}
					}

				}
//				for(int s=0; s<N; s++) {
//	                  for(int q=0; q<N; q++) {
//	                     System.out.print(map[s][q]+" ");
//	                  }
//	                  System.out.println();
//	               }
//	               System.out.println();
//	               System.out.println();

			}
			int Bcount = 0;
			int Wcount = 0;
			for (int o = 0; o < N; o++) {
				for (int j = 0; j < N; j++) {
					if (map[o][j] == 1)
						Bcount++;
					else if(map[o][j] == 2)
						Wcount++;
				}
			}
			System.out.println("#" + (t + 1) + " " + Bcount + " " + Wcount);

		}

	}

}