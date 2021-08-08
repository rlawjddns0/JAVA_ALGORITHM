package BAEK.month_202108.day_20210808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_22114 {
	static int N,K;
	static int[] dist;
	static int[] dp1;
	static int[] dp2;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		dist=new int[N-1];
		dp1=new int[N];
		dp2=new int[N];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N-1; i++) {
			dist[i]=Integer.parseInt(st.nextToken());
		}
		
		dp1[0]=1;
		int cnt=1;
		int max1=0;
		int check1=0;
		boolean flag1=false;
		for(int i=0; i<N-1; i++) {
			if(dist[i]<=K) {
				cnt++;
				max1=Math.max(max1, cnt);
			}else if(dist[i]>K &&!flag1) {
				flag1=true;
				cnt++;
				check1=i;
				max1=Math.max(max1, cnt);
			}else {
				flag1=false;
				max1=Math.max(max1, cnt);
				i=check1;
				cnt=1;
			}
			
		}
		max1=Math.max(max1, cnt);
		int max2=0;
		int cnt2=1;
		int check2=0;
		boolean flag2=false;
		dp2[N-1]=1;
		for(int i=N-2; i>=0; i--) {
			if(dist[i]<=K) {
				cnt2++;
				max2=Math.max(max2, cnt2);
			}else if(dist[i]>K && !flag2){
				cnt2++;
				flag2=true;
				check2=i;//점프를 쓴 인덱스 기억-> 나중에 점프를 멈췄을때 이 구간부터 다시 시작 
				max2=Math.max(max2, cnt2);
			}else {
				flag2=false;
				max2=Math.max(max2, cnt2);
				i=check2;
				cnt2=1;
			}
		}
		max2=Math.max(max2, cnt2);
		
		System.out.println(Math.max(max2, max1));
		
		
	}

}