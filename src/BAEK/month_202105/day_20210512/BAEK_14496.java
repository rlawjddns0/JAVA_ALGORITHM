package BAEK.month_202105.day_20210512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class BAEK_14496 {
	static int N,M;
	static int a,b;
	static int[][] adj;
	static int ans=Integer.MAX_VALUE;
	static ArrayList<v> g[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine()," ");
		if(a==b) {
			System.out.println("0");
			System.exit(0);
		}
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		adj=new int[N][N];
		g=new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			g[i]=new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			g[x].add(new v(y,0));
			g[y].add(new v(x,0));
		}
		
		solutionA(a);
		
		if(ans==Integer.MAX_VALUE)System.out.println("-1");
		else System.out.println(ans);
		
		
		
	}

	private static void solutionA(int start) {
		Queue<v> q=new LinkedList<>();
		int cnt=0;
		
		boolean[] visit=new boolean[N+1];
		for(int i=0; i<g[start].size(); i++) {
			q.offer(new v(g[start].get(i).to,1));
			visit[g[start].get(i).to]=true;
		}
		while(!q.isEmpty()) {
			v tmp=q.poll();
			if(tmp.to==b) {
				ans=Math.min(ans, tmp.cnt);
			}
			for(int i=0; i<g[tmp.to].size(); i++) {
				if(!visit[g[tmp.to].get(i).to]) {
					q.offer(new v(g[tmp.to].get(i).to,tmp.cnt+1));
					visit[g[tmp.to].get(i).to]=true;
				}
			}
		}
		
		
		
		
		
	}

}
class v{
	int to, cnt;

	public v(int to, int cnt) {
		super();
		this.to = to;
		this.cnt=cnt;
	}
	
	
}
