package BAEK.month_202102.day_20210218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BAEK_4963 {
	static int w,h,cnt;
	static int[][]map;
	static boolean[][] check;
	static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st=new StringTokenizer(br.readLine());
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			cnt=0;
			if(w==0 && h==0) break;
			map=new int[h+1][w+1];
			check=new boolean[h+1][w+1];
			for(int i=1; i<=h; i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=1; j<=w; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=1; i<=h; i++) {
				for(int j=1; j<=w; j++) {
					if(map[i][j]==1 && check[i][j]==false) {
						cnt++;
						bfs(i,j);
						//dfs(i,j);

					}
				}
			}
			
			System.out.println(cnt);
			
			
		}
		
		

	}
	public static void dfs(int y, int x) {
		
		
		check[y][x]=true;
		
		
		for(int i=0; i<8; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=1 && nx<w+1 && ny>=1 && ny<h+1 && check[ny][nx]==false&&map[ny][nx]!=0) {
				dfs(ny,nx);
			}
		}
	}
	public static void bfs(int y, int x) {
		Queue<irland> q=new LinkedList();
		check[y][x]=true;
		q.offer(new irland(x, y));
		
		
		while(!q.isEmpty()) {
			irland tmp=q.poll();
			for(int i=0; i<8; i++) {
				int nx=tmp.x+dx[i];
				int ny=tmp.y+dy[i];
				
				if(nx>=1 && nx<w+1 && ny>=1 && ny<h+1 && check[ny][nx]==false&&map[ny][nx]!=0) {
					q.offer(new irland(nx,ny));
					check[ny][nx]=true;
				}
			}

		}
		
		
	}
	static class irland{
		int x;
		int y;
		irland(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void print(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	public static void print(boolean[][] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
}
