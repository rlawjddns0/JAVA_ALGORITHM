package SWE.day_20210118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;



public class SWE_1859 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase=Integer.parseInt(br.readLine());
		int result[]=new int [testCase];
		
		for(int i=0; i<testCase; i++) {
			int TESTCASE=Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine()," ");
			int arr[]=new int[TESTCASE];
			for(int j=0; j<TESTCASE; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			int max=0;
			int sum=0;
			for(int k=TESTCASE-1; k>=0; k--) {
				if(max<arr[k])//만약 오늘의 매매가가 max보다 크면 max를 오늘의 매매가로 바꾼다
				{
					max=arr[k];
				}
				else {//만약 오늘의 매매가가 max보다 작으면 팔아버리면서 ++해간다
					
					sum+=max-arr[k];
				}
				
			}
			
			result[i]=sum;
			
			
		}
		
		for(int i=0; i<testCase; i++) {
			System.out.println("#"+(i+1)+" "+result[i]);
		}
		
		
		
		
		
			

	}
}
		
		
		
			
			
			

