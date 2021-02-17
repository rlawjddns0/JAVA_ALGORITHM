package BAEK.month_202102.day_20210217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BAEK_1992 {
	static int[][] map;
	static StringBuffer sb = new StringBuffer();
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int countZ = 0;
		int countO = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == '0') {
					countZ++;
				} else {
					countO++;
				}
				map[i][j] = str.charAt(j) - '0';
			}
		}

		if (countZ == N * N) {
			System.out.println("0");
			
		} else if(countO==N*N){
			System.out.println("1");
			
		}else {
			solve(N,0,0);
		}
		
		
		System.out.println(sb);
		
		
		

	}
	public static void solve(int size, int y, int x) {
		
		if(size==1) {
			sb.append(map[y][x]);
			return;	
			
		}

		int countZ=0;
		int countO=0;
		
		for(int i=y; i<y+size; i++) {
			for(int j=x; j<x+size; j++) {
				if(map[i][j]==0)countZ++;
				else countO++;;
			}
		}
		
		if(countZ==size*size) {
			sb.append(0);
		}
		else if(countO==size*size) {
			sb.append(1);
		}
		else {
			sb.append("(");
			solve(size/2,y,x);//2
			solve(size/2,y,x+size/2);//1
			solve(size/2,y+size/2,x);//3
			solve(size/2,y+size/2,x+size/2);//4
			sb.append(")");
		}
		
		
		
		
	}

}
