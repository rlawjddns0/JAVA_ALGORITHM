package BACK.month_202102.day_20210214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;


public class BAEK_14889 {
	static int N;
	static int[][] arr;
	static int[] index;
	static int sum;
	static ArrayList<Integer> result=new ArrayList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1][N+1];
		index=new int[N+1];
		for(int i=1; i<N+1; i++)
			index[i]=i;
		for (int i = 1; i < arr.length; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 1; j < arr[i].length; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		solve1(new int[N/2],0, new boolean[N+1],1);
		int ans=Integer.MAX_VALUE;
		for(int i=0,j=result.size()-1; i<result.size()/2;i++,j--) {
			ans=Math.min(Math.abs(result.get(i)-result.get(j)), ans);
		}
		

		System.out.println(ans);
	}
	public static void solve1(int[] sel, int k, boolean[] v,int idx) {
		if(k==sel.length) {
			sum=0;
			solve2(new int[2],sel,0,new boolean[N/2]);
			//System.out.println(sum);
			result.add(sum);
			return;
		}
		
		for(int i=idx; i<N+1; i++) {
			if(v[i]==false) {
				sel[k]=index[i];
				v[i]=true;
				solve1(sel,k+1,v,i+1);
				v[i]=false;
			}
		}
	}
	public static void solve2(int[] sel1,int[] arr1, int k, boolean[] v1) {
		if(k==sel1.length) {
			sum+=arr[sel1[0]][sel1[1]];
			return;
		}
		
		for(int i=0; i<arr1.length; i++) {
			if(v1[i]==false) {
				sel1[k]=arr1[i];
				v1[i]=true;
				solve2(sel1,arr1,k+1,v1);
				v1[i]=false;
			}
		}
	}

}
