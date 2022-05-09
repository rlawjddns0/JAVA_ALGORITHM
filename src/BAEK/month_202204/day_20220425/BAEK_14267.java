package BAEK.month_202204.day_20220425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_14267 {
	static int N,M;
	static int[] emp;
	static int[] result;
	static tmp[] getter;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		emp=new int[N+1];
		result=new int[N+1];
		getter=new tmp[M];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=1; i<=N; i++) {
			emp[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			getter[i]=new tmp(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	static class tmp{
		int i,w;

		public tmp(int i, int w) {
			super();
			this.i = i;
			this.w = w;
		}
		
	}
}
