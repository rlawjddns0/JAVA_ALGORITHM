package BAEK.month_202106.day_20210624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_21922 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<air> list;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		list=new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					list.add(new air(i,j));
					visit[i][j]=true;
				}
			}
		}

		
		for(int i=0; i<list.size(); i++) {
			for (int d = 0; d < 4; d++) {
				int nx = list.get(i).x + dx[d];
				int ny = list.get(i).y + dy[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)
					continue;
				dfs(d, ny, nx);
			}
		}
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visit[i][j])cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}

	private static void dfs(int d, int y, int x) {

		visit[y][x] = true;

		if (map[y][x] == 1) {//|
			if(d==0) {//오른쪽
				return;
			}else if(d==1) {//아래쪽
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}else if(d==2) {//왼쪽
				return;
			}else if(d==3) {//위쪽
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}
		} else if (map[y][x] == 2) {//-
			if(d==0) {//오른쪽
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}else if(d==1) {//아래쪽
				return;
			}else if(d==2) {//왼쪽
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}else if(d==3) {//위쪽
				return;
			}
		} else if (map[y][x] == 3) {// /
			if(d==0) {//오른쪽
				d=3;
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}else if(d==1) {//아래쪽
				d=2;
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}else if(d==2) {//왼쪽
				d=1;
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}else if(d==3) {//위쪽
				d=0;
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}
		} else if (map[y][x] == 4) {//\
			if(d==0) {//오른쪽
				d=1;
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}else if(d==1) {//아래쪽
				d=0;
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}else if(d==2) {//왼쪽
				d=3;
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}else if(d==3) {//위쪽
				d=2;
				int ny=y+dy[d];
				int nx=x+dx[d];
				if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
				dfs(d,ny,nx);
			}
		} else if(map[y][x]==0) {
			int ny=y+dy[d];
			int nx=x+dx[d];
			if (ny >= N || ny < 0 || nx >= M || nx < 0)return;
			dfs(d,ny,nx);
		}
		
		return;

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
	}

}
class air{
	int y,x;

	@Override
	public String toString() {
		return "air [y=" + y + ", x=" + x + "]";
	}

	public air(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
	
}
