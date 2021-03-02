package BAEK.month_202103.day_20210302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_17070 {
	static int N;
	static int[][] map;
	static int[] dx= {1,1,0};//우, 우하, 하
	static int[] dy= {0,1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		
		
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		if(map[N-1][N-1]==1)
		{
			System.out.println("0");
		}else {
		map[0][0]=2;
		map[0][1]=2;
		solve(0,1,0);
		System.out.println(count);
		
		}
		
	}
	static int state;//0=가로, 1=대각선, 2=세로
	static int count;
	private static void solve(int y, int x, int state) {
		
		if(y==N-1 && x==N-1) {
			count++;
			return;
			
			
		}
		
		
		if(state==0) {
			
			L:for(int d=0; d<2; d++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				if(d==0&&nx>=0 && nx<N && ny>=0 && ny<N && map[ny][nx]==1)continue;
				if(d==1) {
					for(int d1=0; d1<3; d1++) {
						int nx1=x+dx[d1];
						int ny1=y+dy[d1];
						if(nx1>=0 && nx1<N && ny1>=0 && ny1<N && map[ny1][nx1]==1)break L;
					}
				}
				if(nx>=0 && nx<N && ny>=0 && ny<N && map[ny][nx]!=1) {
					map[ny][nx]=2;
					solve(ny,nx,d);
					map[ny][nx]=0;
				}
			}
		}
		else if(state==1) {
			L:for(int d=0; d<3; d++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				if(d==0 &&nx>=0 && nx<N && ny>=0 && ny<N && map[ny][nx]==1)continue;
				else if(d==2&&nx>=0 && nx<N && ny>=0 && ny<N && map[ny][nx]==1)continue;
				else if(d==1) {
					for(int d1=0; d1<3; d1++) {
						int nx1=x+dx[d1];
						int ny1=y+dy[d1];
						if(nx1>=0 && nx1<N && ny1>=0 && ny1<N && map[ny1][nx1]==1)continue L;
					}
				}
				if(nx>=0 && nx<N && ny>=0 && ny<N && map[ny][nx]!=1) {
					map[ny][nx]=2;
					solve(ny,nx,d);
					map[ny][nx]=0;
				}
			}
		}
		else {//세로
			L:for(int d=1; d<3; d++) {
				int nx=x+dx[d];
				int ny=y+dy[d];
				if(d==2&&nx>=0 && nx<N && ny>=0 && ny<N && map[ny][nx]==1)continue;
				else if(d==1) {
					for(int d1=0; d1<3; d1++) {
						int nx1=x+dx[d1];
						int ny1=y+dy[d1];
						if(nx1>=0 && nx1<N && ny1>=0 && ny1<N && map[ny1][nx1]==1)continue L;
					}
				}
				if(nx>=0 && nx<N && ny>=0 && ny<N && map[ny][nx]!=1) {
					map[ny][nx]=2;
					solve(ny,nx,d);
					map[ny][nx]=0;

				}
			}
			
		}
		return;
		
	}

}
