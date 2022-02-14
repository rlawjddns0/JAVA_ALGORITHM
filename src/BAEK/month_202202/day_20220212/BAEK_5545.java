package BAEK.month_202202.day_20220212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_5545 {
	static int N;
	static int A,B;
	static int C;
	static int[] cal;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int sumCal;
		int sumCost;
		N=Integer.parseInt(br.readLine());
		cal=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		
		C=Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			int n=Integer.parseInt(br.readLine());
			cal[i]=n;
		}
		
		sumCal=C;
		sumCost=A;
		
		
		Arrays.sort(cal);
		int ans=(int)sumCal/sumCost;
		for(int i=cal.length-1; i>=0; i--) {
			sumCal+=cal[i];
			sumCost+=B;
			
			ans=Math.max(ans, (int)sumCal/sumCost);
			
			
		}
		System.out.println(ans);
		
	}
}
