package BAEK.month_202104.day_20210413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_17951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N,K;
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		int[] test=new int[N];
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N ;i++) {
			test[i]=Integer.parseInt(st.nextToken());
		}
		
		int left=0;
		int right=(int)Math.pow(N,20);
		int ans=Integer.MIN_VALUE;
		while(left<=right) {
			int middle=(left+right)/2;
			
			int tmp=K;
			int sum=0;
			for(int i=0; i<N; i++) {
				sum+=test[i];
				if(sum>=middle) {
					tmp--;
					sum=0;
				}
			}
			
			int nn=0;
			if(tmp<=0) {
				nn=middle;
				ans=Math.max(nn, ans);
				left=middle+1;
			}
			if(tmp>0) {
				
				right=middle-1;
			}
			
		}
		
		System.out.println(ans);
		
		
		
		
		
		
	}

}
