package BAEK.month_202104.day_20210413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_20165 {
	static int N,M,R;
	static int[][] map;
	static boolean[][] visit;
	static boolean[][] check;
	static int[] dx= {1,0,-1,0};//우 하 좌 상
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		check=new boolean[N][M];
		visit=new boolean[N][M];

		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		while(R!=0) {
			
			StringTokenizer st1=new StringTokenizer(br.readLine()," ");
			int attackY=Integer.parseInt(st1.nextToken())-1;
			int attackX=Integer.parseInt(st1.nextToken())-1;
			String D=st1.nextToken();
			
			StringTokenizer st2=new StringTokenizer(br.readLine()," ");
			int defendY=Integer.parseInt(st2.nextToken())-1;
			int defendX=Integer.parseInt(st2.nextToken())-1;
			
			
			if(!check[attackY][attackX])//넘어져 있지 않으면
			{
				down(attackY,attackX,map[attackY][attackX],D);
				
			}
			
			
			if(check[defendY][defendX])//쓰러져 있으면
			{
				check[defendY][defendX]=false;//다시 세우고
			}
			R--;
		}
		
		
		
		
		
		
		
		
		
		System.out.println(count);
		print();
	}
	private static void print() {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(check[i][j]) {
					System.out.print("F ");
				}
				else {
					System.out.print("S ");
				}
			}
			System.out.println();
		}
		
		
		
	}
	static int count;
	private static void down(int attackY,int attackX,int size, String d) {
		int dir=0;
		if(d.equals("E"))dir=0;
		else if(d.equals("W"))dir=2;
		else if(d.equals("S"))dir=1;
		else dir=3;
		int nx=attackX;
		int ny=attackY;
		check[attackY][attackX]=true;//쓰러뜨리고
		count++;
		for(int i=size-1; i>=1; i--) {
			nx+=dx[dir];
			ny+=dy[dir];
			if(ny>=N || ny<0 || nx>=M || nx<0)break;
			if(check[ny][nx]) {
				
				continue;
			}
			
			if(i<map[ny][nx]) {
				i=map[ny][nx];
			}
			
			check[ny][nx]=true;
			count++;
		}
		

		
	}

}
