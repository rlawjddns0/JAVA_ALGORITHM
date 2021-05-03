package SWE.month_202105.day_20210502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_2115 {
	static int N,M,C;
	static int[][] map,tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			map=new int[N][N];
			tmp=new int[N][N-M+1];
			
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-M+1; j++) {
					solution(new int[M],i,j);
				}
			}
//			for(int i=0; i<N; i++) {
//				System.out.println(Arrays.toString(tmp[i]));
//			}
			int ans=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<tmp[i].length; j++) {

					
					for(int p=j+2; p<tmp[i].length; p++) {
						ans=Math.max(ans,tmp[i][j]+tmp[i][p]);
					}
					
					for(int k=i+1; k<N; k++) {
						for(int p=0; p<tmp[k].length; p++) {
							ans=Math.max(ans,tmp[i][j]+tmp[k][p]);
						}
					}
					
					
				}
			}
			
			
			System.out.println("#"+t+" "+ans);
			
			
		}
		
	}
	private static void solution(int[] sel, int y, int x) {
		
		
		
		
		for(int i=x, j=0; i<x+M;j++, i++) {
			sel[j]=map[y][i];
		}
		//System.out.println(Arrays.toString(sel));

		powerset(sel,0,new boolean[sel.length],y,x);
		
		
	}
	private static void powerset(int[] sel, int k, boolean[] visit,int y,int x) {
		
		if(k==sel.length) {
			int sum=0;
			//System.out.println(Arrays.toString(sel));
			for(int i=0; i<k; i++) {
				if(visit[i]) {
					sum+=sel[i];
				}
			}
			if(sum>C)return;
			if(sum<=C) {
				int max_sum=0;
				for(int i=0; i<k; i++) {
					if(visit[i]) {
						int n=(int)Math.pow(sel[i], 2);
						max_sum+=n;
					}
				}
				
				tmp[y][x]=Math.max(tmp[y][x], max_sum);
				
			}
			
			
			return;
		}
		
		
		visit[k]=true;
		powerset(sel,k+1,visit,y,x);
		visit[k]=false;
		powerset(sel,k+1,visit,y,x);
		
	}

}
