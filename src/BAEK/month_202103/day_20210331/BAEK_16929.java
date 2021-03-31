package BAEK.month_202103.day_20210331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_16929 {
	static int N, M;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int starty, startx;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		flag = false;
		L: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit = new boolean[N][M];
				//aSystem.out.println("Y: "+i+"X: "+j);
				startx = j;
				starty = i;
				dfs(i, j,1);
					if(flag == true)
						break L;
				

			}
		}
		if (flag) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	private static void dfs(int y, int x, int count) {

		if(flag)return;
		visit[y][x]=true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx<0 || nx>=M || ny<0 || ny>=N)continue;
			if(map[ny][nx]!=map[y][x])continue;
			
			if(!visit[ny][nx]) {
				visit[ny][nx]=true;
				dfs(ny,nx,count+1);
			}
			else {
				if(nx==startx && ny==starty &&count>3) {
					flag=true;
					return;
				}
			}
		}
		
	}

}

class pos {
	int y, x;

	public pos(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

}