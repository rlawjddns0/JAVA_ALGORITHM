package BAEK.month_202104.day_20210418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_14938 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		
		int[] item=new int[n];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n;i++) {
			item[i]=Integer.parseInt(st.nextToken());
		}
		long[][] area=new long[n+1][n+1];
		long[][] dist=new long[n+1][n+1];
		for(int i=0; i<r; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			area[from][to]=w;
			area[to][from]=w;
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j)dist[i][j]=0;
				else if(area[i][j]>0)dist[i][j]=dist[j][i]=area[i][j];
				else dist[i][j]=Integer.MAX_VALUE;
			}
		}
		//print(dist,n);
		//System.out.println();
		
		
		for(int k = 1; k<= n; k++){
		    for(int i = 1; i <= n; i++){
		        for(int j = 1; j<=n; j++){
		            dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
		        }
		    }
		}
		//print(dist,n);
		
		int ans=0;
		for(int i=1; i<=n; i++) {
			int sum=0;
			for(int j=1; j<=n; j++) {
				if(dist[i][j]<=m) {
					sum+=item[j-1];
				}
			}
			ans=Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}
	public static void print(long[][] dist,int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(dist[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
