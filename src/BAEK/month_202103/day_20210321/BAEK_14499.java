package BAEK.month_202103.day_20210321;

import java.util.Scanner;

public class BAEK_14499 {
	static int N,M;
	static int[][] map;
	static int[] order;
	static int x,y;
	static int K;
	static int[] dx= {1,-1,0,0};//동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
	static int[] dy= {0,0,1,-1};
	static int[][] dice= {	{0,2,0},
							{4,1,3},
							{0,5,0},
							{0,6,0}
						};
	static int dicex=1;
	static int dicey=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		x=sc.nextInt();
		y=sc.nextInt();
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
			x+=dy[o];
			y+=dx[o];
			
			if(x<0 || x>=N || y<0 || y>=M) {
				x-=dy[o];
				y-=dx[o];
				
				continue;
			}
			dicex+=dx[o];
			dicey+=dy[o];
			diceCheck(o);
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
	}
	private static void diceCheck(int o) {
		if(o==0) {//동
			if(dicex==2 && dicey==0) {dicex=1; dicey=0;}
			if(dicex==2 && dicey==1) {dicex=0; dicey=1;}
			if(dicex==2 && dicey==2) {dicex=1; dicey=1;}
			if(dicex==2 && dicey==3) {dicex=0; dicey=1;}
		}else if(o==1) {//서
			
		}else if(o==2) {//남
			
		}else {//북
			
		}
		
	}

}
