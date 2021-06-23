package BAEK.month_202106.day_20210623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_20125 {
	static int N;
	static char[][] map;
	static int hearty,heartx;
	static int left_arm,right_arm,left_leg,right_leg, middle;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new char[N][N];
		int heady=0,headx=0;
		for(int i=0; i<N; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		
		L:for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='*') {
					heady=i;
					headx=j;
					break L;
				}
			}
		}
		
		//½ÉÀå 
		hearty=heady+1;
		heartx=headx;
		
		//¿ÞÂÊ ÆÈ
		int ny=hearty;
		int nx=heartx-1;
		while(check(ny,nx) &&map[ny][nx]=='*' ) {
			nx-=1;
			left_arm++;
		}
		//¿Ã´ÀÂÊ ÆÈ
		ny=hearty;
		nx=heartx+1;
		while(check(ny,nx) &&map[ny][nx]=='*' ) {
			nx+=1;
			right_arm++;
		}
		
		//Çã¸®
		ny=hearty+1;
		nx=heartx;
		while(check(ny,nx) &&map[ny][nx]=='*' ) {
			ny+=1;
			middle++;
		}
		int tmpy=ny;
		int tmpx=nx;
		
		//¿ÞÂÊ ´Ù¸®
		ny=tmpy;
		nx=tmpx-1;
		while(check(ny,nx) &&map[ny][nx]=='*' ) {
			ny+=1;
			left_leg++;
		}
		//¿À¸¥ÂÊ ´Ù¸®
		ny=tmpy;
		nx=tmpx+1;
		while(check(ny,nx) &&map[ny][nx]=='*' ) {
			ny+=1;
			right_leg++;
		}
		
		System.out.println((hearty+1)+" "+(heartx+1));
		System.out.println((left_arm)+" "+right_arm+" "+middle+" "+left_leg+" "+right_leg);
		
		
		
	}
	public static boolean check(int y, int x) {
		if(y>=N || y<0 || x>=N || x<0)return false;
		return true;
	}

}
