package SWE.month_202101.day_20210126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_1959 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<testCase; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int[] arr1;
			int[] arr2;
			int min=0;
			int max=0;
			if(N<M) {
				min=N;
				max=M;
				arr1=new int[N];
				arr2=new int[M];
				StringTokenizer st1=new StringTokenizer(br.readLine()," ");
				
				for(int i=0; i<arr1.length; i++) {
					arr1[i]=Integer.parseInt(st1.nextToken());
				}
				
				StringTokenizer st2=new StringTokenizer(br.readLine()," ");
				
				for(int i=0; i<arr2.length; i++) {
					arr2[i]=Integer.parseInt(st2.nextToken());
				}
			}
			else {
				min=M;
				max=N;
				arr1=new int[M];
				arr2=new int[N];
				StringTokenizer st1=new StringTokenizer(br.readLine()," ");
				
				for(int i=0; i<arr2.length; i++) {
					arr2[i]=Integer.parseInt(st1.nextToken());
				}
				
				StringTokenizer st2=new StringTokenizer(br.readLine()," ");
				
				for(int i=0; i<arr1.length; i++) {
					arr1[i]=Integer.parseInt(st2.nextToken());
				}
			}
			
			
			int MAX=0;

				for(int i=0; i<max-min+1; i++) {
					int sum=0;
					for(int j=0,k=i; j<arr1.length; j++,k++) {
						sum+=arr1[j]*arr2[k];
					}
					if(MAX<sum) {
						MAX=sum;
					}
					
				}
			
			System.out.println("#"+(t+1)+" "+MAX);
			
			
			
			
			
			
			
		}
		
	}

}
