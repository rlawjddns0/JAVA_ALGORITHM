package SWE.month_202102.day_20210215;

import java.util.Scanner;

public class SWE_1493 {
	static int[][] map = new int[301][301];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;
		for (int i = 1; i <= 300; i++) {
			map[i][1] = n;
			for (int j = 2; j <= 300; j++) {
				map[i][j] = map[i][j - 1] + i + j - 1;
			}
			n += i;
		}

		Scanner sc = new Scanner(System.in);
		
		int TC=sc.nextInt();
		for(int t=1; t<=TC; t++) {
			int p=sc.nextInt();
			int q=sc.nextInt();
			int x=0; int y=0;
			
			for(int i=1; i<=300; i++) {
				for(int j=1; j<=300; j++) {
					if(map[i][j]==p ) {
						x+=i;
						y+=j;
					}
					if(map[i][j]==q ) {
						x+=i;
						y+=j;
					}
				}
			}
			
			System.out.println("#"+t+" "+map[x][y]);
			
			
			
			
			
		}

	}

}
