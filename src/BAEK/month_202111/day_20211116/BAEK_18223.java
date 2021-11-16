package BAEK.month_202111.day_20211116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 전형적인 다익스트라 문제...
 * 너무 안풀어서 다 까먹었다...
 * 다익스트라로 최단경로를 구하면서 일단 민준이가 있다면 기억
 * 
 */
public class BAEK_18223 {
	static int V,E,P;
	static ArrayList<edge>[] node;
	static PriorityQueue<edge> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		pq=new PriorityQueue<>();		
		node=new ArrayList[V+1];
		for(int i=1; i<=V; i++) {
			node[i]=new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			node[from].add(new edge(to,w));
			node[to].add(new edge(from,w));
		}
		
		pq.add(new edge(1,0));
		
		dijkstra();
		
		
		
		
		
		
		
		
	}
	public static void dijkstra() {
		int distance[]=new int[V+1];//최단거리 저장
		boolean visit[]=new boolean[V+1];
		
		for(int i=1; i<=V; i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		
		distance[1]=0;//초기화
		visit[1]=true;
		
		while(!pq.isEmpty()) {
			
			int min=Integer.MAX_VALUE;
			int min_index=-1;
			
			
			
			edge e=pq.poll();
			min=e.W;
			min_index=e.V;
			
			for(int i=0; i<node[min_index].size(); i++) {
				if(!visit[node[min_index].get(i).V]) {
					if(distance[min_index]+node[min_index].get(i).W<distance[i]) {
						distance[i]=distance[min_index]+node[min_index].get(i).W;
						pq.add(new edge(i,distance[i]));
					}
				}
			}
			
			
			
			
		}
		System.out.println(Arrays.toString(distance));
		
	}
}
class edge implements Comparable<edge>{
	int V,W;

	public edge(int v, int w) {
		super();
		V = v;
		W = w;
	}

	@Override
	public int compareTo(edge o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.W, o.W);
	}

}