package BAEK.month_202103.day_20210322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_1753 {
	static int[] d;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		ArrayList<vertex>[] vertex = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			vertex[i] = new ArrayList<vertex>();
		}
		d = new int[V + 1];
		Arrays.fill(d, Integer.MAX_VALUE);
		boolean[] visited = new boolean[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			vertex[Integer.parseInt(st.nextToken())]
					.add(new vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		d[K] = 0;

		for (int i = 1; i <= V; i++) {
			int min = Integer.MAX_VALUE;
			int cur = 0;
			// step1. :처리하지 않은점중에 출발지에서 가장 가까운(최소비용) 정점 선택
			for (int j = 1; j <= V; j++) {
				if (!visited[j] && min > d[j]) {
					min = d[j];
					cur = j;
				}
			}
			
			visited[cur] = true;

			// step 선택된 cur를 경우지로 하여 아직 처리하지 않은 다른 정점으로의 최소비용 따져본다.
			
				for (int k = 0; k < vertex[cur].size(); k++) {
					if (!visited[vertex[cur].get(k).v] && d[vertex[cur].get(k).v] > min + vertex[cur].get(k).w) {
						d[vertex[cur].get(k).v] = min + vertex[cur].get(k).w;
					}
				}
			
			//System.out.println(Arrays.toString(d));
		}
		for(int i=1; i<d.length; i++) {
			if(d[i]==Integer.MAX_VALUE)System.out.println("INF");
			else {
				System.out.println(d[i]);
			}
		}
		

	}

	private static void dijkstra(int start, int end, ArrayList<vertex>[] vertex) {

	}

}

class vertex {
	int w;
	int v;

	public vertex(int v, int w) {
		super();
		this.w = w;
		this.v = v;
	}

}