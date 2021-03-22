package BAEK.month_202103.day_20210321;


import java.util.Arrays;
import java.util.Scanner;

public class BAEK_14499 {
	static int N,M;
	static int[][] map;
	static int[] order;
	static int x,y;
	static int K;
	static int[] dx= {1,-1,0,0};//동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
	static int[] dy= {0,0,-1,1};
	static int[] dice = new int[7];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		y=sc.nextInt();
		x=sc.nextInt();
		K=sc.nextInt();
		order=new int[K];
		map=new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for(int i=0; i<K; i++) {
			order[i]=sc.nextInt();
		}
		for(int i=0; i<K; i++) {
			int o=order[i]-1;
			int nx=x+dx[o];
			int ny=y+dy[o];
			
			if(ny<0 || ny>=N || nx<0 || nx>=M) {
				continue;
			}
			
			
			diceCheck(o);
			
			if(map[ny][nx]==0) {
				map[ny][nx]=dice[6];
			}
			else {
				dice[6]=map[ny][nx];
				map[ny][nx]=0;
			}
			
			x=nx;
			y=ny;
			System.out.println(dice[1]);
		}
		
		
		
		
		
	}
	private static void diceCheck(int d) {
		
		int[] temp = dice.clone();
	    // 동쪽은 0, 서쪽은 1, 북쪽은 2, 남쪽은 3
	    if (d == 0) {
	        dice[1] = temp[4];
	        dice[3] = temp[1];
	        dice[4] = temp[6];
	        dice[6] = temp[3];
	    } else if (d == 1) {
	        dice[1] = temp[3];
	        dice[3] = temp[6];
	        dice[4] = temp[1];
	        dice[6] = temp[4];
	    } else if (d == 2) {
	        dice[1] = temp[5];
	        dice[2] = temp[1];
	        dice[5] = temp[6];
	        dice[6] = temp[2];
	    } else {
	        dice[1] = temp[2];
	        dice[2] = temp[6];
	        dice[5] = temp[1];
	        dice[6] = temp[5];
	    }


		
	}

}