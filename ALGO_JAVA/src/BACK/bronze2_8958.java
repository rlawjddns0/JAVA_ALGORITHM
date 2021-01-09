package BACK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bronze2_8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		int testCase=Integer.parseInt(br.readLine());//text case number
//		int result[]=new int[testCase];
//		StringBuffer sb=new StringBuffer();
//		while(testCase!=0) {
//			sb.append(br.readLine());
//			sb.toString();
//			int count=0;//number of O
//			int num=0;
//			int i=0;
//			for(i=0;i<sb.length(); i++) {
//				char temp;
//				temp= sb.charAt(i);
//				if(temp=='O') {
//					count++;
//				}
//				else {
//					count=0;
//				}
//				num+=count;
//			}
//			result[testCase-1]=num;
//			sb.setLength(0);
//			testCase--;
//		}
//				
//		
//	
//		for(int i=result.length-1; i>=0; i--) {
//			System.out.println(result[i]);
//		}
//		
//	}

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());//text case number
		StringBuffer sb=new StringBuffer();
		String[] arr=new String[testCase];
		
		for(int i=0; i<testCase; i++) {
			arr[i]=br.readLine();
		}
		for(int i=0; i<testCase; i++) {
			int count=0;//num of O
			int num=0;//´©Àû
			
			for(int j=0; j<arr[i].length(); j++)
			{
				if(arr[i].charAt(j)=='O') {
					count++;
				}
				else {
					count=0;
				}
				num+=count;
			}
			
			sb.append(num).append('\n');
			
		}
				
		System.out.println(sb);
		
	}

}
