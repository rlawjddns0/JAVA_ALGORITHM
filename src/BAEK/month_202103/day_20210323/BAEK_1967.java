package BAEK.month_202103.day_20210323;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BAEK_1967 {
	static ArrayList<vertex>[] adj;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		adj = new ArrayList[n + 1];
		boolean[] v = new boolean[n + 1];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int w = sc.nextInt();
			adj[from].add(new vertex(to, w));
			adj[to].add(new vertex(from, w));
		}

		dfs(adj,1,v,0);
		v=new boolean[n+1];
		int start=maxV;
		//System.out.println(start);
		maxV=0;
		max=0;
		dfs(adj,start,v,0);
		//System.out.println(maxV);
		System.out.println(max);

	}

	public static int ans = Integer.MIN_VALUE;
	public static ArrayList<Integer> result = new ArrayList<>();
	public static int maxV;
	public static int max;
	private static void dfs(ArrayList<vertex>[] adj, int n, boolean[] visit, int w) {
		visit[n] = true;

		int weight = w;
		int size = adj[n].size();
		for (int i = 0; i < size; i++) {
			vertex next = adj[n].get(i);
			if (!visit[next.v]) {
				dfs(adj, next.v, visit, w + next.w);
			}
		}
		if(max<w) {
			max=w;
			maxV=n;
		}
		//result.add(weight);

	}

}

class vertex {
	int v, w;

	public vertex(int v, int w) {
		super();
		this.v = v;
		this.w = w;
	}

}