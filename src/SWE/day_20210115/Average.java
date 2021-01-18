package SWE.day_20210115;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Average {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int testCase;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		testCase=Integer.parseInt(br.readLine());//test case 받기
		String arr[]=new String[testCase];
		StringTokenizer st;
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<testCase; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int sum=0;
			for(int j=0; j<10; j++) {
				int num=Integer.parseInt(st.nextToken());
				sum+=num;
			}
			double SUM=(double)sum/10;
			sb.append("#").append(i+1).append(" ").append(String.format("%.0f", SUM)).append("\n");//string format 사용하여 소수점 표현
			
		}
		
		System.out.println(sb);
		
		
		
		

	}

}
