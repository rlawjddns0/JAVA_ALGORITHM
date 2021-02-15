package SWE.month_202101.day_20210125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase=Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<testCase; t++) {
			
			int N=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine()," ");
			int[] arr=new int[N];
			for(int i=0; i<N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			System.out.print("#"+(t+1)+" ");
			for(int i=0; i<N; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			
			
		}
		
	}

}
