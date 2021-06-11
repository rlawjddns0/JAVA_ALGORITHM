package BAEK.month_202106.day_20210610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_15591 {
	static int N,Q;
	static ArrayList<video>[] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		v=new ArrayList[N];
		for(int i=0; i<N; i++) {
			v[i]=new ArrayList<video>();
		}
		for(int i=0; i<N-1; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int usado=Integer.parseInt(st.nextToken());
			
			v[from-1].add(new video(to-1,usado));
			v[to-1].add(new video(from-1,usado));
		}
//		for(int i=0; i<N; i++) {
//			System.out.println(v[i].toString());
//		}
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<Q; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int k=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			System.out.println(bfs(v-1,k));
		}
		
		
		
		
		
		
	}
	private static int bfs(int ver, int k) {
		
		Queue<video> q=new LinkedList<>();
		q.offer(new video(ver,Integer.MAX_VALUE));
		boolean[] visit=new boolean[N];
		visit[ver]=true;
		int cnt=0;
		boolean check=false;
		
		while(!q.isEmpty()) {
			video tmp=q.poll();
//			System.out.println("usado: "+tmp.usado);
//			System.out.println("v: "+tmp.v);
			if(tmp.usado>=k && check) {
				cnt++;
			}
			for(int i=0; i<v[tmp.v].size(); i++) {
				check=true;
				if(visit[v[tmp.v].get(i).v])continue;
				video next=null;
				if(tmp.usado>=v[tmp.v].get(i).usado) {
					next=new video(v[tmp.v].get(i).v,v[tmp.v].get(i).usado);
				}else {
					next=new video(v[tmp.v].get(i).v,tmp.usado);
				}
				q.offer(next);
				visit[next.v]=true;
				
			}
			
		}
		return cnt;
	}
	

}
class video{
	int v;
	int usado;
	public video(int v, int usado) {
		super();
		this.v = v;
		this.usado = usado;
	}
	@Override
	public String toString() {
		return "video [v=" + v + ", usado=" + usado + "]";
	}
	
}