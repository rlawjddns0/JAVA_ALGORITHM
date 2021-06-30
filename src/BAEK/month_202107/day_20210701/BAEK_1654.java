package BAEK.month_202107.day_20210701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1654 {
	static int N,M;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr=new long[N];
		long left=1;
		long right=Integer.MAX_VALUE;
		long middle=0;
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		
		
		
		long ans=0;
		while(left<=right) {
			middle=(left+right)/2;
			int cnt=0;
			
			
			for(int i=0; i<N; i++) {
				cnt+=arr[i]/middle;
			}
			
			
			if(cnt>=M) {
				ans=middle;
				left=middle+1;
			}else
			{
				right=middle-1;
			}
			
			
		}
		
		System.out.println(ans);
		
		
		
		

	}

}
