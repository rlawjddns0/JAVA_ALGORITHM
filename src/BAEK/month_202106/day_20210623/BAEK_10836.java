package BAEK.month_202106.day_20210623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_10836 {
	static int M, N;
	static int[][] map;
	static int[] dx = { -1, -1, 0 };
	static int[] dy = { 0, -1, -1 };
	static int[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		num=new int[2*M-1];
		Arrays.fill(num, 1);
//		print(0);
//		System.out.println();
		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			int zero=Integer.parseInt(st.nextToken());
			int one=Integer.parseInt(st.nextToken());
			int two=Integer.parseInt(st.nextToken());
			input(zero,one,two);
			
//			print(n);
//			System.out.println();
			

		}
//		System.out.println(Arrays.toString(num));
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				if(j==0) {
					System.out.print(num[M-i-1]+" ");
				}else
					System.out.print(num[M+j-1]+" ");
			}
			System.out.println();
		}

	}
	private static void print(int n) {
		for(int i=0; i<M; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	private static void input( int zero, int one, int two) {
		
		
		for(int i=0; i<2*M-1; i++) {
			if(zero!=0) {
				num[i]+=0;
				zero--;
				continue;
			}else if(one!=0) {
				num[i]+=1;
				one--;
				continue;
			}else if(two!=0) {
				num[i]+=2;
				two--;
				continue;
			}
				
		}
//		System.out.println(Arrays.toString(num));
		
		
		
		
	}
		
		
	
}
