package SWE.month_202101.day_20210129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class SWE_2805 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		//int[] size= {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49};
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		for(int t=0; t<testCase; t++) {
			int N=Integer.parseInt(br.readLine());

			char[][] arr=new char [N][N];
			
			for(int i=0; i<N; i++) {
				String str=br.readLine();
				arr[i]=str.toCharArray();
			}
			int[] num=new int[N];
			int[] begin=new int[N];
			
			
			for(int i=0,j=1 ,k=N; i<N; i++,j+=2) {
				if(j>N)
				{	
					k-=2;
					num[i]=k;
				}
				else {
					num[i]=j;
				}
			}
			int p=N/2;
			for(int i=0, j=p, k=0; i<N;i++, j--) {
				if(j<=0) {
					begin[i]=k;
					k++;
				}
				else
				{
					begin[i]=j;
				}
				
			}
		
			
			int sum=0;
			for(int i=0; i<N; i++) {
				for(int j=begin[i]; j<begin[i]+num[i]; j++) {
					sum+=((int)arr[i][j])-48;
					
				}
				
			}
			
			
			
			
			System.out.println("#"+(t+1)+" "+sum);
			
			
			
		}
	}

}
