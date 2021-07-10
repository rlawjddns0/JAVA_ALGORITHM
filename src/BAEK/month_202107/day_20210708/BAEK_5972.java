package BAEK.month_202107.day_20210708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 그냥 다익스트라로 할 시 시간초과
 * 우선순위 큐를 활용한 다익스트라로 해야됨
 */
public class BAEK_5972 {
	static int N,M;
	static boolean[] visit;
	static int[] dist;
	static ArrayList<v>[] g;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		visit=new boolean[N+1];
		dist=new int[N+1];
		
		g=new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			g[i]=new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			g[from].add(new v(to,w));
			g[to].add(new v(from,w));
			
		}
		
		
		
		dijkstra(1);
		
		
		System.out.println(dist[N]);
		
		
		
		
	}
	private static void dijkstra(int start) {
		for(int i=1; i<=N; i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		
		dist[start]=0;
		
			
		PriorityQueue<v> pq=new PriorityQueue<>();
		pq.offer(new v(start,0));
		
		while(!pq.isEmpty()) {
			int cur=pq.poll().next;
			
			if(visit[cur])continue;
			visit[cur]=true;
			
			for(v next:g[cur]) {
				if(dist[next.next]>dist[cur]+next.w) {
					dist[next.next]=dist[cur]+next.w;
					pq.offer(new v(next.next,dist[next.next]));
				}
			}
			
			
			
			
			
		}
		
		
		
		
	}

}
class v implements Comparable<v>{
	int next,w;

	public v(int next, int w) {
		super();
		this.next = next;
		this.w = w;
	}

	@Override
	public int compareTo(v o) {
		return this.w-o.w;
	}
	
}