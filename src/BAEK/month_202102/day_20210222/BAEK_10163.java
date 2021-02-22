package BAEK.month_202102.day_20210222;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_10163 {
	static int[][] map=new int[101][101];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		paper[] p=new paper[N];
		int[] count=new int[N+1];
		for(int i=0; i<N; i++) {
			p[i]=new paper(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		
		for(int n=1; n<=N; n++) {
			for(int i=p[n-1].y; i<p[n-1].y+p[n-1].col; i++) {
				for(int j=p[n-1].x; j<p[n-1].x+p[n-1].row; j++)
				{
					map[i][j]=n;
				}
			}
		}
		for(int i=0; i<101; i++) {
			for(int j=0; j<101; j++) {
				if(map[i][j]!=0) {
					count[map[i][j]]++;
				}
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.out.println(count[i]);
		}
		

	}

}
class paper{
	int x;
	int y;
	int row;
	int col;
	paper(int x, int y, int row, int col){
		this.x=x;
		this.y=y;
		this.row=row;
		this.col=col;
	}
}