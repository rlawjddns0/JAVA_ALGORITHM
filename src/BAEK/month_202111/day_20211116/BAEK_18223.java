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
 * �������� ���ͽ�Ʈ�� ����...
 * �ʹ� ��Ǯ� �� ��Ծ���...
 * ���ͽ�Ʈ��� �ִܰ�θ� ���ϸ鼭 �ϴ� �����̰� �ִٸ� ���
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
		
		int len1=dijkstra(1,P)+dijkstra(P,V);
		System.out.println(len1);
		
		
		
		
		
		
		
	}
	public static int dijkstra(int start, int end) {
		int distance[]=new int[V+1];//�ִܰŸ� ����
		boolean visit[]=new boolean[V+1];
		
		for(int i=1; i<=V; i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		
		distance[start]=0;//�ʱ�ȭ
		visit[start]=true;
		
		while(!pq.isEmpty()) {
			
			edge cur=pq.poll();
			int curNode=cur.V;
			if(visit[curNode])continue;
			visit[curNode]=true;
			if(curNode==end) {
				return distance[end];
			}
			
			for(int i=0; i<node[cur.V].size(); i++) {
				int nextW=node[cur.V].get(i).W;
				int nextNode=node[cur.V].get(i).V;
				if(!visit[nextNode] && distance[nextNode]>distance[curNode]+nextW) {
					distance[nextNode]=distance[curNode]+nextW;
					pq.add(new edge(nextNode,nextW));
				}
			}
			
			
			
			
		}
		return distance[end];
		
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