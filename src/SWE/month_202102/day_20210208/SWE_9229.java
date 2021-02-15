package SWE.month_202102.day_20210208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_9229 {
	static int sum,M;
	static int max=0;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=testCase; t++) {
			max=0;
			st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine()," ");
			arr=new int[N];
			for(int i=0; i<N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			
			check(new int[2],0,0);//2개를 무조건 고르니께 
			
			if(max==0) {
				System.out.println("#"+t+" -1");
			}
			else {
				System.out.println("#"+t+" "+max);
			}
			
			
		}
	}

	static void check(int[] sel, int k, int idx){
		if(k==sel.length) {
			int num1=sel[0];
			int num2=sel[1];
			//System.out.println(Arrays.toString(sel));
			if(num1+num2>M) {
				return;
			}else {
				max=Math.max(max, num1+num2);
			}
			return;
		}
	
	
		for(int i=idx; i<arr.length; i++) {
			sel[k]=arr[i];
			check(sel,k+1,i+1);
		}
	
	
	
	}
	
	
	
	
	
}
