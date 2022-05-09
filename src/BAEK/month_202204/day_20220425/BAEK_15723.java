package BAEK.month_202204.day_20220425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_15723 {
	static int N,M;
	static int[][] graph = new int[26][26];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		for(int i=0; i<26; i++) {
			for(int j=0; j<26;j++) {
				if(i==j) {
					graph[i][j]=0;
					continue;
				}
				graph[i][j]=100000;
			}
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int from=st.nextToken().charAt(0)-'a';
			st.nextElement();
			int to=st.nextToken().charAt(0)-'a';
			
			graph[from][to]=1;
		}
		
		int[][] result=new int[26][26];
		
		for(int k=0; k<26; k++) {
			for(int i=0; i<26; i++) {
				for(int j=0; j<26; j++) {
					graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
//		for(int i=0; i<5; i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}
//		
		
		StringBuffer sb=new StringBuffer();
		M=Integer.parseInt(br.readLine());
		
		
		L:for(int i=0; i<M; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int from=st.nextToken().charAt(0)-'a';
			st.nextElement();
			int to=st.nextToken().charAt(0)-'a';
			
				if(graph[from][to]!=100000) {
					sb.append("T").append("\n");
					continue L;
				}
			
			sb.append("F").append("\n");
			
		}
		
		System.out.println(sb.toString());
	}
}
