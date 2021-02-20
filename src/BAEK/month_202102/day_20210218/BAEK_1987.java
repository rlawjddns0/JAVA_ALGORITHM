package BAEK.month_202102.day_20210218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_1987 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int R, C, cnt;
	static char[][] map;
	static int ans = Integer.MIN_VALUE;
	static boolean[] check = new boolean[26];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		check[map[0][0] - 'A'] = true;
		solve(0, 0,1);
//		for (int i = 0; i < R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		System.out.println(ans);

	}

	public static void solve(int x, int y,int cnt) {

		ans = Math.max(ans, cnt);
		
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < C && ny >= 0 && ny < R) {

				if(check[map[ny][nx]-'A']==false) {
					check[map[ny][nx]-'A']=true;
					solve(nx,ny,cnt+1);
					check[map[ny][nx]-'A']=false;

				}
				
			}
			
		}
		

	}

}
