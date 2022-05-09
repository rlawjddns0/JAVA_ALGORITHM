package BAEK.month_202204.day_20220425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BAEK_20366 {
	static int N;
	static int[] H;
	static ArrayList<snow> list=new ArrayList<>();
	static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		H=new int[N];
		
		for(int i=0; i<N; i++) {
			H[i]=Integer.parseInt(st.nextToken());
		}
		
		
		combi(new boolean[N],0,0);
		
		Collections.sort(list);
		
		for(int i=0; i<list.size()-1; i++) {
			snow first=list.get(i);
			snow second=list.get(i+1);
			
			if(first.x1==second.x1 || first.x1==second.x2 || first.x2==second.x1 || first.x2==second.x2)continue;
			
			ans=Math.min(ans, Math.abs(first.sum-second.sum));
		}
		System.out.println(ans);
		
		
	}
	private static void combi( boolean[] visit, int k,int idx) {
		if(k==2) {
			int sum=0;
			int[] tmp=new int[2];
			int cnt=0;
			for(int i=0; i<visit.length; i++) {
				if(visit[i]) {
					sum+=H[i];
					tmp[cnt++]=i;
				}
			}
			list.add(new snow(tmp[0],tmp[1],sum));
			
			
			return;
		}
		if(idx>=N)return;
		
		
		visit[idx]=true;
		combi(visit,k+1,idx+1);
		visit[idx]=false;
		combi(visit,k,idx+1);
	
		
		
		
		
		
	}
	static class snow implements Comparable<snow>{
		int x1,x2,sum;

		public snow(int x1, int x2, int sum) {
			super();
			this.x1 = x1;
			this.x2 = x2;
			this.sum = sum;
		}

		@Override
		public int compareTo(snow o) {
			
			return this.sum-o.sum;
		}

		@Override
		public String toString() {
			return "snow [x1=" + x1 + ", x2=" + x2 + ", sum=" + sum + "]";
		}
		
		
		
	}

}
