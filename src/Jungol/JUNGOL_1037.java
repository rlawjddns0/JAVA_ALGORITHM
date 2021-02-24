package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class JUNGOL_1037 {
	static int N;
	static int[][] map;
	static int[] x;
	static int[] y;
	static int countx;
	static int county;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		x=new int[N];
		y=new int[N];
		map=new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int r=countX();
		int c=countY();
		if(r==-1 && c==-1) {
			System.out.println("OK");
		}else if(r==-2 || c==-2) {
			System.out.println("Corrupt");
		}else if(r>=0 && c>=0) {
			System.out.printf("Change bit (%d,%d)\n",(r+1),(c+1));
		}
		
		
	}
	public static int countX() {
		int count=0;
		int r=0;
		for(int i=0; i<N; i++) {
			count=0;
			for(int j=0; j<N; j++) {
				if(map[i][j]==1)count++;
			}
			x[i]=count;
		}
		System.out.println(Arrays.toString(x));

		int n=0;
		for(int i=0; i<N; i++) {
			if(x[i]%2!=0)n++;
		}
		
		if(n==0) {
			return -1;
		}
		else if(n>=2) {
			return -2;
		}
		else {
			for(int i=0; i<N; i++) {
				if(x[i]%2!=0) r=i;
			}
		}
		return r;
	}
	public static int countY() {
		int count=0;
		int c=0;
		for(int i=0; i<N; i++) {
			count=0;
			for(int j=0; j<N; j++) {
				if(map[j][i]==1)count++;
			}
			y[i]=count;
		}
		System.out.println(Arrays.toString(y));
		int n=0;
		for(int i=0; i<N; i++) {
			if(y[i]%2!=0)n++;
		}
		
		if(n==0) {
			return -1;
		}
		else if(n>=2) {
			return -2;
		}
		else {
			for(int i=0; i<N; i++) {
				if(y[i]%2!=0) c=i;
			}
		}
		return c;
	}
}
