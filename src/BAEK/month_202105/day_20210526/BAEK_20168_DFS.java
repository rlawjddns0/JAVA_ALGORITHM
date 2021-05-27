package BAEK.month_202105.day_20210526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_20168_DFS {
	static ArrayList<Node> adj[];
	static boolean[] visit;
	static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());// √‚πﬂ
		int B = Integer.parseInt(st.nextToken());// µµ≈π
		C = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		visit=new boolean[N+1];
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
		
		
		dfs(A,B,0,0);
		if(ans==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(ans);
		}
	}
	static int ans=Integer.MAX_VALUE;
	private static void dfs(int start, int end,int w,int m) {
		
		if(start==end) {
			if(w<=C) {
				ans=Math.min(ans, m);
			}
			return;
		}
		
		
		for(int i=0; i<adj[start].size(); i++) {
			if(!visit[adj[start].get(i).vertex]) {
				visit[adj[start].get(i).vertex]=true;
				dfs(adj[start].get(i).vertex,end,adj[start].get(i).g+w,Math.max(adj[start].get(i).g, m));
				visit[adj[start].get(i).vertex]=false;
			}
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
