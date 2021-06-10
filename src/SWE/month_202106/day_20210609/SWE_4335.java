package SWE.month_202106.day_20210609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_4335 {
	static int N;
	static rec[] R;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		
		int TC=Integer.parseInt(br.readLine());
		
		
		for(int t=1; t<=TC; t++) {
			
			N=Integer.parseInt(br.readLine());
			R=new rec[N];
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine()," ");
				R[i]=new rec(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			
			dfs(0,new rec[N],new boolean[N]);
			
			
			
			
			
		
			
			
			
		}
		
		
	}
	private static void dfs(int k, rec[] sel, boolean[] visit) {
		if(k==N) {
			
			
			
			
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			if(visit[i])continue;
			
			sel[k]=R[i];
			visit[i]=true;
			dfs(k+1,sel,visit);
			visit[i]=false;
		}
	}

}
class rec{
	int G;//가로
	int S;//세로
	int N;//높이
	public rec(int g, int s, int n) {
		super();
		G = g;
		S = s;
		N = n;
	}
	@Override
	public String toString() {
		return "rec [G=" + G + ", S=" + S + ", N=" + N + "]";
	}

	
}