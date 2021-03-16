package BAEK.month_202103.day_20210313;

import java.util.Scanner;

public class BAEK_2933 {
	static int R,C,N;
	static int[] spear;
	static char[][] map;
	static boolean[][] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		map=new char[R][C];
		int dir=1;//던지는 방향 1:-> -1:<-
		for(int i=0; i<R; i++) {
			char[] tmp=sc.next().toCharArray();
			for(int j=0; j<C; j++) {
				map[i][j]=tmp[j];
			}
		}
		
		N=sc.nextInt();
		spear=new int[N];
		for(int i=0; i<N; i++) {
			spear[i]=sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			throw_spear(R-spear[i],dir);
			dir*=-1;
		}
		
		print();
		
		
		

	}
	private static void print() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void print_visit() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(visit[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void throw_spear(int r, int dir) {
		int start=0;
		if(dir==1) {
			for(int i=0; i<C; i++) {
				if(map[r][i]=='x') {
					map[r][i]='.';
					check_cluster();
					//print_visit();
					//print();
					gravity();
					break;
				}
			}
		}else {
			for(int i=C-1; i>=0; i--) {
				if(map[r][i]=='x') {
					map[r][i]='.';
					check_cluster();	
					//print_visit();
					//print();
					gravity();
					break;
				}
			}
		}
		
	}
	private static void gravity() {
		int min=Integer.MAX_VALUE;
		int cnt=0;
		for(int i=0; i<C; i++) {
			cnt=0;
			for(int j=R-1; j>=0; j--) {
				if(map[j][i]=='x' && visit[j][i]==true) {
					int ti=i;
					int tj=j;
					boolean flag=false;
					while(true) {
						if(tj-1<0)break;
						char tmp=map[--tj][ti];
						boolean tp=visit[tj][ti];
						if(tmp=='x') {
							if(flag && tp==false) {
								min=Math.min(cnt, min);//떨어지는 최소 거리
							}
							else {
								flag=false;
							}
						}
						else if(tmp=='.') {
							cnt++;
							flag=true;
						}
					}
				//	min=Math.min(cnt, min);//떨어지는 최소 거리
				}
			}
		}
		System.out.println(min);
		if(min==0 || min>100)return;
//		else {
//			//System.out.println(min);
//		}
		//print();
		for(int i=R-1; i>=0; i--) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='x' && !visit[i][j]) {
					map[i+min][j]='x';
					map[i][j]='.';
				}
			}
		}
		
		
		
	}
	private static void check_cluster() {
		visit=new boolean[R][C];
			for(int j=0; j<C; j++) {
				if(map[R-1][j]=='x') {
					dfs(R-1,j);
				}
			}
		
	}
	private static void dfs(int i, int j) {
		int dj[]= {1,0,-1,0};
		int di[]= {0,1,0,-1};
		visit[i][j]=true;
		for(int d=0; d<4; d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(ni>=0 && ni<R && nj>=0 && nj<C && !visit[ni][nj] && map[ni][nj]=='x') {
				dfs(ni,nj);
			}
		}
		
	}
	

}
