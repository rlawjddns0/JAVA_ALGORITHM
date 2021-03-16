package SWE.month_202103.day_20210316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWE_1238 {
	static int N, start;
	static int[][] map;
	static boolean[][] adj;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int TC = 1; TC <= 10; TC++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			map = new int[101][101];
			adj = new boolean[101][101];
			N = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = true;

			}
			System.out.println("#"+TC+" "+bfs(start));
		}

	}

	public static void print() {
		for (int i = 0; i < 101; i++) {
			System.out.println(Arrays.toString(adj[i]));
		}
	}

	private static int bfs(int start) {

		visit = new boolean[101];
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			ArrayList<Integer> tp = new ArrayList<Integer>();
			int size = q.size();
			for (int t = 0; t < size; t++) {

				int tmp = q.poll();
				for (int i = 0; i < 100; i++) {
					if (adj[tmp][i] && !visit[i]) {
						q.offer(i);
						tp.add(i);
						visit[i] = true;
					}
				}
				visit[tmp] = true;
				// System.out.println(tp.toString());
			}
			if (tp.size() != 0) {
				result = (ArrayList<Integer>) tp.clone();
			}

		}
		Collections.sort(result, Collections.reverseOrder());
		return result.get(0);

	}

}
