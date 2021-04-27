package BAEK.month_202104.day_20210426;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BAEK_1756 {
	static int[] depth,pizza;
	static boolean[] visit;
	static int D,N;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		D=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		depth=new int[D+1];
		pizza=new int[N];
		visit=new boolean[D+1];
		st=new StringTokenizer(br.readLine()," ");
		int min=Integer.parseInt(st.nextToken());
		depth[1]=min;
		//핵심 아이디어
		for(int i=2; i<=D; i++) {
			int next=Integer.parseInt(st.nextToken());
			min=Math.min(min, next);
			depth[i]=min;
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			pizza[i]=Integer.parseInt(st.nextToken());
		}
//		System.out.println(Arrays.toString(depth));
		int end=0;
		int left=1;
		int right=D;
		for(int i=0; i<N; i++) {
			int p=pizza[i];
			right=search(left,right,p);
			
//			System.out.println(right);
			right--;
			if(right<0)break;
		}
		
		if(right<0) {
			System.out.println("0");
		}else {
			System.out.println(right+1);
		}
		
		
		
	}
	public static int search(int left, int right,int p) {
		int middle=0;
		while(left<=right) {
			middle=(left+right)/2;
			
			if(depth[middle]>=p) {
				left=middle+1;
			}
			if(depth[middle]<p) {
				
				right=middle-1;
			}
		}
		return right;
	}
	
}
