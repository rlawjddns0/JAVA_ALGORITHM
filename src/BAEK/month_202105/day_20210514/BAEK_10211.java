package BAEK.month_202105.day_20210514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_10211 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<TC; t++) {
			
			int N=Integer.parseInt(br.readLine());
			int[] num=new int[N];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			
			
			int ans=Integer.MIN_VALUE;
			
			int sum=0;
			for(int i=0; i<N; i++) {
				sum+=num[i];
				ans=Math.max(ans,sum);
				if(sum<0) {
					sum=0;
				}
			}
			
			
			
			
			System.out.println(ans);
			
			
			
			
		}
		
		
	}

}
