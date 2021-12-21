package BAEK.month_202112.day_20211221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;
/**
 * 
 * 바로 찍는것보다 sb사용해ㅓ 뽑는게 시간절약 
 */
public class BAEK_15654 {
	static int N, M;
	static int[] arr;
	static StringBuffer sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		 
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		sb=new StringBuffer();
		solution(new int[M],0, new boolean[N]);
				
				System.out.println(sb);
		
		
	}
	private static void solution(int[] sel,int k, boolean[] visit) {
		if(k==M) {
			for (int i : sel) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visit[i])continue;
			sel[k]=arr[i];
			visit[i]=true;
			solution(sel,k+1,visit);
			visit[i]=false;
		}
		
		
		
	}

}
