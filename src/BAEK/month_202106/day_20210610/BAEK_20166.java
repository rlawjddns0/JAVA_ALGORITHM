package BAEK.month_202106.day_20210610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_20166 {
	static int N,M;
	static boolean[] check;
	static party[] party;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		check=new boolean[N+1];
		graph=new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			graph[i]=new ArrayList<>();
		}
		
		st=new StringTokenizer(br.readLine()," ");
		party=new party[M+1];
		int TRUE=Integer.parseInt(st.nextToken());
		
		if(TRUE==0) {
			System.out.println(M);
			return;
		}
		
		for(int i=0; i<TRUE; i++) {
			check[Integer.parseInt(st.nextToken())]=true;//진실을 아는 사람들
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int party_member_num=Integer.parseInt(st.nextToken());
			party[i]=new party(party_member_num);
			for(int j=0; j<party_member_num; j++) {
				party[i].member[j]=Integer.parseInt(st.nextToken());
			}
			
			for(int j=0; j<party_member_num; j++) {
				int from=party[i].member[j];
				for(int k=0; k<party_member_num; k++) {
					if(from==party[i].member[k])continue;
					graph[from].add(party[i].member[k]);
					graph[party[i].member[k]].add(from);
				}
			}
			
		}
		
		for(int i=1; i<N+1; i++) {
			if(check[i]) {
				dfs(i, new boolean[N+1]);
			}
		}
		
		
		
		
		
		
		
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<party[i].n; j++) {
				if(check[party[i].member[j]]) {
					party[i].check=false;
				}
			}
			
		}
		
		
		
		
		int cnt=0;
		
		for(int i=0; i<M; i++) {
			if(party[i].check) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		
		
	}
	private static void dfs(int m, boolean[] visit) {
		visit[m]=true;
		check[m]=true;
		
		for(int i=0; i<graph[m].size(); i++) {
			if(visit[graph[m].get(i)])continue;
			dfs(graph[m].get(i),visit);
		}
		
		
		
	}

}
class party{
	int n;
	int[] member;
	boolean check=true;
	public party(int n) {
		super();
		this.n = n;
		member=new int[n];
	}
	
}