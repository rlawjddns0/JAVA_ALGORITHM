package SWE.month_202104.day_20210422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_5643 {
	static int N,M,adj[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			N=Integer.parseInt(br.readLine());
			M=Integer.parseInt(br.readLine());
			adj=new int[N+1][N+1];
			for(int i=0; i<=N; i++)adj[i][0]=-1;
			
			StringTokenizer st=null;
			for(int k=0; k<M; k++) {
				st=new StringTokenizer(br.readLine()," ");
				int i=Integer.parseInt(st.nextToken());
				int j=Integer.parseInt(st.nextToken());
				adj[i][j]=1;
			}
			int ans=0;
//			gtCnt=new int[N+1];
//			ltCnt=new int[N+1];
			for(int i=1; i<=N; i++) {
				if(adj[i][0]==-1)dfs(i);
			}
			
			
			for (int i = 1; i <= N; i++) {
				for(int j=1; j<=N; j++) {
					adj[0][j]+=adj[i][j];
				}
			}
			
			for(int i=1; i<=N; i++) {
				if(adj[i][0]+adj[0][i]==N-1)ans++;
			}
			System.out.println("#"+t+" "+ans);
			
		}
		
		
		
	}
	
	private static void dfs(int cur) {
		
		for(int i=1; i<=N; i++) {
			if(adj[cur][i]==1) {
				if(adj[i][0]==-1) {
					dfs(i);
				}
				if(adj[i][0]>0) {
					for(int j=1; j<=N; j++) {
						if(adj[i][j]==1)adj[cur][j]=1;
					}
				}
			}
		}
		
		
		int cnt=0;
		for(int i=1; i<=N; i++) {
			cnt+=adj[cur][i];
		}
		adj[cur][0]=cnt;
		
	}
	
}
