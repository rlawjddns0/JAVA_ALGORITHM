package SWE.month_202106.day_20210603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_10505 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			int N=Integer.parseInt(br.readLine());
			
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int[] arr=new int[N];
			int sum=0;
			for(int i=0; i<N ; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
				sum+=arr[i];
			}
			
			int avg=sum/N;
			
			int cnt=0;
			
			for(int i=0; i<N; i++) {
				if(arr[i]<=avg)cnt++;
			}
			
			
			System.out.println("#"+t+" "+cnt);
			
		}
		
	}

}
