package BAEK.month_202103.day_20210322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BAEK_1197 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[] d = new int[V + 1];
		ArrayList<Edge>[] Edge = new ArrayList[V + 1];
		for (int i = 0; i < Edge.length; i++) {
			Edge[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[V + 1];
		int[] minEdge = new int[V + 1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Edge[from].add(new Edge(to, w));
			Edge[to].add(new Edge(from, w));
		}

		for (int i = 1; i < Edge.length; i++) {
			Collections.sort(Edge[i]);
		}

		int result = 0;
		minEdge[1] = 0;
		for (int i = 1; i < V + 1; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			for (int j = 1; j < V + 1; j++) {
				if (!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			//System.out.println(min);
			result += min;
			visited[minVertex] = true;

			for (int k = 0; k < Edge[minVertex].size(); k++) {
				if (!visited[Edge[minVertex].get(k).v] && minEdge[Edge[minVertex].get(k).v] > Edge[minVertex].get(k).w) {
					minEdge[Edge[minVertex].get(k).v] = Edge[minVertex].get(k).w;
				}

			}
			//System.out.println(Arrays.toString(minEdge));

		}

		System.out.println(result);

	}

}

class Edge implements Comparable<Edge> {
	int w, v;

	public Edge(int v, int w) {
		super();
		this.w = w;
		this.v = v;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.w < o.w) {
			return 1;
		}
		return 0;
	}

}