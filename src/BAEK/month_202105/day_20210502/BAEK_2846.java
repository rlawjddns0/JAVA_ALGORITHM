package BAEK.month_202105.day_20210502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_2846 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] num=new int[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		int start=0;
		int end=0;
		int middle=start;
		int ans=0;
		for(int i=1; i<N; i++) {
			
			if(num[middle]<num[i]) {
				ans=Math.max(ans, num[i]-num[start]);
				middle=i;
			}
			else{
				start=i;
				middle=i;
			}
			
			
		}
		
		
		System.out.println(ans);
		
		
	}

}
