package BAEK.month_2022023.day_20220306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2606 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		boolean[] computerNum = new boolean[N + 1];
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);

		}

		Queue<Integer> q = new LinkedList<>();

		q.offer(1);
		computerNum[1] = true;
		int ans = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 0; i < graph[cur].size(); i++) {
				if (computerNum[graph[cur].get(i)])
					continue;
				q.offer(graph[cur].get(i));
				computerNum[graph[cur].get(i)] = true;
				ans++;

			}

		}
		System.out.println(ans);

	}

	static class node {
		int from, to;

		@Override
		public String toString() {
			return "node [from=" + from + ", to=" + to + "]";
		}

		public node(int from) {
			super();
			this.from = from;
		}

	}
}
