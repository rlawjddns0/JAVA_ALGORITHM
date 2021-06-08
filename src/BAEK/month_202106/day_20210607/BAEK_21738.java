package BAEK.month_202106.day_20210607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_21738 {
	static int N,S,P;
	static ArrayList<p>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		P=Integer.parseInt(st.nextToken());
		
		boolean[] visit=new boolean[N+1];
		graph=new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			graph[i]=new ArrayList<p>();
		}
		for(int i=0; i<N-1; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			graph[from].add(new p(0,to));
			graph[to].add(new p(0,from));
		}
//		for(int i=1; i<N+1; i++) {
//			System.out.println((graph[i].toString()));
//		}
		Queue<p> q=new LinkedList<>();
		q.offer(new p(1,P));
		visit[P]=true;
		int cnt=0;
		int ice=0;
		while(!q.isEmpty()) {
			
			p tmp=q.poll();
//			System.out.println("현재 v: "+tmp.next);
//			System.out.println("현재 v의 길이: "+graph[tmp.next].size());
			if(tmp.next>=1 && tmp.next<=S) {
				
				cnt++;
				ice+=tmp.cnt;
			}
			
			
			if(cnt==2) {
				System.out.println(N-(ice-1));
				break;
			}
			
			for(int i=0; i<graph[tmp.next].size(); i++) {
				if(!visit[graph[tmp.next].get(i).next]) {
					q.offer(new p(tmp.cnt+1,graph[tmp.next].get(i).next));
					visit[graph[tmp.next].get(i).next]=true;
				}
			}
			
		}
		
		
		
		
	}

}
class p{
	int cnt;
	int next;
	public p(int cnt, int next) {
		super();
		this.cnt = cnt;
		this.next = next;
	}
	@Override
	public String toString() {
		return "p [cnt=" + cnt + ", next=" + next + "]";
	}
	
}
