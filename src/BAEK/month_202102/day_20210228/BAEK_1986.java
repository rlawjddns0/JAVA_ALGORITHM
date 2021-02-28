package BAEK.month_202102.day_20210228;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_1986 {
	static int n, m;
	static int[][] map;
	static int[] Kdx= {2,1,-1,-2,-2,-1,1,2};
	static int[] Kdy= {-1,-2,-2,-1,1,2,2,1};
	static int[] Qdx={ 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[] Qdy= { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][m+1];
		// 1:queen, 2:knight, 3:pawn
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				map[y][x] = i + 1;
			}
		}
		//print();
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < m+1; j++) {
				if (map[i][j] == 1) {//queen
					for(int d=0; d<8; d++) {
						int nx=j+Qdx[d];
						int ny=i+Qdy[d];
						//System.out.println(ny +" "+ nx);
						while(nx<=m && nx>=1 && ny<=n && ny>=1 && map[ny][nx]!=1 &&map[ny][nx]!=2 &&map[ny][nx]!=3 ) {
							map[ny][nx]=-1;
							nx+=Qdx[d];
							ny+=Qdy[d];
						}
					}
				} else if (map[i][j] == 2) {//knight
					for(int d=0; d<8; d++) {
						int nx=j+Kdx[d];
						int ny=i+Kdy[d];
						if(nx<=m && nx>=1 && ny<=n && ny>=1&& map[ny][nx]==0) {
							map[ny][nx]=-1;
						}
					}
				}
				

			}
		}
//		System.out.println();
//		print();
		int ans=0;
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++)
			{
				if(map[i][j]==0)ans++;
			}
		}
		System.out.println(ans);

	}
	public static void print() {
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				System.out.print(map[i][j]+"	");
			}
			System.out.println();
		}
	}

}
