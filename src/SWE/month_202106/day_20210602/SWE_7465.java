package SWE.month_202106.day_20210602;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SWE_7465 {
	static ArrayList<Integer>[] g;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int TC=sc.nextInt();
		
		for(int t=1;t<=TC; t++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			g=new ArrayList[N+1];
			for(int i=1; i<N+1; i++) {
				g[i]=new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				int from=sc.nextInt();
				int to=sc.nextInt();
				g[from].add(to);
				g[to].add(from);
			}
			
			
			int cnt=0;
			visit=new boolean[N+1];
			for(int i=1; i<=N; i++) {
				if(g[i].size()>0 && !visit[i]) {
					cnt++;
					dfs(i);
				}
//				System.out.println(Arrays.toString(visit));
			}
			for(int i=1; i<=N; i++) {
				if(!visit[i]) {
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
			
			
		}
		
		
		
	}
	private static void dfs(int from) {
		if(visit[from])return;
		visit[from]=true;
		for(int i=0; i<g[from].size(); i++) {
			dfs(g[from].get(i));
		}
	}

}
