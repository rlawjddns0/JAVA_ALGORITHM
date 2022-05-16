package BAEK.month_202205.day_20220516;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_11659 {
	static int N,M;
	static int[] arr;
	static int[] sumArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new int[N+1];
		sumArr=new int[N+1];
		st=new StringTokenizer(br.readLine()," ");
		int tmp=0;
		for(int i=1; i<=N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			tmp+=arr[i];
			sumArr[i]=tmp;
		}
		
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			sb.append(sumArr[to]-sumArr[from-1]).append("\n");
		}
		System.out.println(sb);
		
		
		
		
	}
}
