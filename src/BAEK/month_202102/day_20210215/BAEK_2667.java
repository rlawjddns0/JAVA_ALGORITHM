package BAEK.month_202102.day_20210215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class BAEK_2667 {
	static int N;
	static int[][] arr;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static boolean[][] v;
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		v=new boolean[N][N];
		int num=0;
		ArrayList<Integer> result=new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			char[] tmp=new char[N];
			tmp=br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				arr[i][j]=tmp[j]-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==1 && v[i][j]==false) {
					count=0;
					num++;
					solve(i,j);
					result.add(count);
				}
				
			}
		}
		System.out.println(num);
		Collections.sort(result);
		for (Integer integer : result) {
			System.out.println(integer);
		}
	}
	
	public static void solve(int x, int y) {
		
		if(arr[x][y]==0 || v[x][y]==true) {
			return;
		}
		v[x][y]=true;
		count++;
		
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0 && nx<N &&ny>=0 && ny<N) {
				solve(nx,ny);
			}
		}
		
		return;
	}
}
