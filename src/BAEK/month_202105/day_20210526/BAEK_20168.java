package BAEK.month_202105.day_20210526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_20168 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Node> adj[];
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());// √‚πﬂ
		int B = Integer.parseInt(st.nextToken());// µµ≈π
		int C = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, c));
		}

		int[] dist = new int[N + 1];
		dist[A]=0;
		int ans = Integer.MAX_VALUE;
		Queue<tmp> q = new LinkedList<>();
		q.offer(new tmp(A, 0, 0));
		while (!q.isEmpty()) {
			tmp current = q.poll();
			int currentNode = current.n;
			int w = current.sum;
			int m = current.max;
			if (w > C)continue;
			if (currentNode == B) {
				if (w <= C) {
					ans = Math.min(ans, m);
				}
			}
			for (int i = 0; i < adj[currentNode].size(); i++) {
				
				
				int tmax = Math.max(m, adj[currentNode].get(i).g);
				if(ans<tmax)continue;
				q.offer(new tmp(adj[currentNode].get(i).vertex, w + adj[currentNode].get(i).g, tmax));
			}
		}
		if (ans != Integer.MAX_VALUE) {
			System.out.println(ans);
		} else {
			System.out.println("-1");
		}

	}

}

class Node {
	int vertex, g;

	public Node(int vertex, int g) {
		super();
		this.vertex = vertex;
		this.g = g;
	}

	@Override
	public String toString() {
		return "Node [vertex=" + vertex + ", g=" + g + "]";
	}

}

class tmp {
	int n;
	int sum;
	int max;

	public tmp(int n, int sum, int max) {
		super();
		this.n = n;
		this.sum = sum;
		this.max = max;
	}

}