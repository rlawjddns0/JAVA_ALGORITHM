package BAEK.month_202102.day_20210218;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BAEK_2615 {
	static int T, ans, N;
	static int[][] board;
	static int [] dr = {1,1,0,-1};
	static int [] dc = {0,1,1 ,1};
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		ans = 0;
		// solve;
		board = new int[20][20];
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		//print(board);
		// solve
		boolean flag = false;
		for (int r = 1; r < 20; r++) {
			for (int c = 1; c < 20; c++) {
				// 오목알을 하나씩 탐색하여 오목인지 확인
				// 1 or 2 인경우
				if(board[r][c]==1||board[r][c]==2) {
					//4방 탐색한다
					for (int d = 0; d < 4; d++) {
						int nr = r+dr[d];
						int nc = c+dc[d];
						int cnt=1;
						// 오목인지 확인
						// 새로운 돌이 오목판안에 있고 같은 색이면
						while(check(nr,nc)&&board[nr][nc]==board[r][c]) {
							nr+=dr[d];
							nc+=dc[d];
							cnt++;
						}
						// 오목이다
						if(cnt==5) {
							int bCnt=0;
							nr+=(dr[d]*-1);
							nc+=(dc[d]*-1);
							while(check(nr,nc)&&board[nr][nc]==board[r][c]) {
								nr+=(dr[d]*-1);
								nc+=(dc[d]*-1);
								bCnt++;
							}
							if(bCnt>5) {
								continue;
							}
							System.out.println(board[r][c]);
							System.out.println(r+" "+c);
							flag = true;
						}
					}
				}
			}
		}
		if(!flag) System.out.println(0);
	}

	private static boolean check(int nr, int nc) {
		if(nr>=1&&nr<=19&&nc>=1&&nc<=19) return true;
		return false;
	}

	private static void print(int[][] board) {
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

}