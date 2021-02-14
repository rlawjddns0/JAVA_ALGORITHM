package BACK.day_20210210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_15686 {
	static int[][] map;
	static chicken[] ch;
	static int M, N;
	static int ans=Integer.MAX_VALUE;
	static int sum=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		int count = 0;
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				int tp = Integer.parseInt(st.nextToken());
				map[i][j] = tp;
				if (tp == 2) {
					count++;
				}
			}
		}

		ch = new chicken[count];
		int tp = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (map[i][j] == 2) {
					ch[tp++] = new chicken(i, j);
				}
			}
		}

		combo(new chicken[M], 0, 0);

		System.out.println(ans);

	}

	private static void combo(chicken[] sel, int k, int idx) {

		if (k == M) {
			int su = 0;
			

			for (int j = 1; j < N+1; j++) {
				for (int u = 1; u < N+1; u++) {
					if (map[j][u] == 1) {
						int min = Integer.MAX_VALUE;
						for (int i = 0; i < sel.length; i++) {
							int x=sel[i].x;
							int y=sel[i].y;
							//System.out.println("X:"+x+"Y:"+y);
							int m=Math.abs(x - j) + Math.abs(y - u);
							min = Math.min(min, m);
							// System.out.println(min);
						}
						su+=min;
					}
					

				}

				// System.out.println(min);
			}
			//System.out.println(su);
			ans = Math.min(ans, su);
			return;
		}

		for (int i = idx; i < ch.length; i++) {
			sel[k] = ch[i];
			combo(sel, k + 1, i + 1);
		}

	}

}

class chicken {
	int x;
	int y;

	public chicken(int i, int j) {
		this.x = i;
		this.y = j;
	}
}
