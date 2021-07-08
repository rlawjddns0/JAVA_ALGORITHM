package BAEK.month_202107.day_20210707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_1939 {
	static int N,M;
	static int start,end;
	static ArrayList<v>[] g;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		visit=new boolean[N+1];
		
		g=new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			g[i]=new ArrayList<v>();
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			g[from].add(new v(to,w));
			g[to].add(new v(from,w));
		}
		
		st=new StringTokenizer(br.readLine()," ");
		start=Integer.parseInt(st.nextToken());
		end=Integer.parseInt(st.nextToken());
		
		
		solution(start);
		
		
	
	
	}
	
	private static void solution(int start) {
		
		if(start==end) {
			return;
		}
		
		for(int i=0; i<g[start].size(); i++) {
			if(![g[start].get(i).next])
		}
		
		
		
		
		
		
		
	}

}
class v{
	int next,w;

	public v(int next, int w) {
		super();
		this.next=next;
		this.w = w;
	}
	
}
