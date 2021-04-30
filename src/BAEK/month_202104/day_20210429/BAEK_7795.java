package BAEK.month_202104.day_20210429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_7795 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		StringTokenizer st=null;
		for(int t=0; t<TC; t++) {
			st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int[] A=new int[N];
			int[] B=new int[M];
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				A[i]=Integer.parseInt(st.nextToken());
			}
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0; i<M; i++) {
				B[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			int cnt=0;
			for(int i=0; i<N; i++) {
				int left=0;
				int right=M-1;
				
				while(left<=right) {
					int middle=(left+right)/2;
					
					if(B[middle]>=A[i]) {
						right=middle-1;	
					}else {
						left=middle+1;
					}
				}
				
				cnt+=left;
				
			}
			System.out.println(cnt);
			
			
			
			
			
			
		}
		
		
	}

}
