package BAEK.month_202112.day_20211224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_1504 {
	static int N,E;
	static int v1,v2;
	static ArrayList<ArrayList<Node>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		list=new ArrayList<ArrayList<Node>>();
		for(int i=0; i<N+1; i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int cost=Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to,cost));
			list.get(to).add(new Node(from,cost));
		}
		st=new StringTokenizer(br.readLine()," ");
		
		v1=Integer.parseInt(st.nextToken());
		v2=Integer.parseInt(st.nextToken());
		
		int a=dijkstra(1,v1);
		int b=dijkstra(v1,v2);
		int c=dijkstra(v2, N);
		
		int d=dijkstra(1,v2);
		int e=dijkstra(v2,v1);
		int f=dijkstra(v1, N);
		
		if((a==-1 || b==-1 || c==-1) && (d==-1||e==-1||f==-1)) {
			System.out.println("-1");
		}else {
			System.out.println(Math.min(a+b+c, d+e+f));
		}		
		
		
		
		
	}
	public static int dijkstra(int start, int end) {
		int[] dist=new int[N+1];
		
		for(int i=0; i<N+1; i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		
		dist[start]=0;
		PriorityQueue<Node> q=new PriorityQueue<Node>((o1,o2)->Integer.compare(o1.cost, o2.cost));
		q.offer(new Node(start,0));
		while(!q.isEmpty()) {
			Node curNode=q.poll();
			
			if(curNode.idx==end) {
				return dist[curNode.idx];
			}
			
			if(dist[curNode.idx]<curNode.cost)continue;
			
			
			for(int i=0; i<list.get(curNode.idx).size(); i++) {
				Node nextNode=list.get(curNode.idx).get(i);
				
				
				if(dist[nextNode.idx]>curNode.cost+nextNode.cost) {
					dist[nextNode.idx]=curNode.cost+nextNode.cost;
					q.offer(new Node(nextNode.idx,dist[nextNode.idx]));
				}
				
				
				
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		return -1;
	}
}
class Node{
	int idx,cost;

	Node(int idx, int cost) {
		super();
		this.idx = idx;
		this.cost = cost;
	}
	
	
}