package BAEK.month_202106.day_20210607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_17245 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		
		int[][] map=new int[N][N];
		long right=Integer.MIN_VALUE;
		long cnt=0;
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				right=Math.max(right, map[i][j]);
				cnt+=map[i][j];
			}
		}
//		System.out.println(cnt);
		long left =0;
		long middle=0;
		long ans=0;
		while(left<=right) {
			
			middle=(left+right)/2;
			long t_cnt=0;
//			System.out.println(middle);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]<=middle) {
						t_cnt+=map[i][j];
					}else {
						t_cnt+=middle;
					}
				}
			}
			double result=(double)t_cnt/(double)cnt;
//			System.out.println(result);
			if(result>=0.5) {
				ans=middle;
				right=middle-1;
				
			}else {
				left=middle+1;
				
			}
		}
		
		
		
		System.out.println(ans);
		
		
		
	}

}
