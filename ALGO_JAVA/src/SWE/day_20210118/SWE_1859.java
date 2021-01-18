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
				if(max<arr[k])//���� ������ �ŸŰ��� max���� ũ�� max�� ������ �ŸŰ��� �ٲ۴�
				{
					max=arr[k];
				}
				else {//���� ������ �ŸŰ��� max���� ������ �Ⱦƹ����鼭 ++�ذ���
					
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
		
		
		
			
			
			

