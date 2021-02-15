package SWE.month_202101.day_20210115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BigSmallEqual {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		int testCase;//테스트 케이스
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		testCase=Integer.parseInt(br.readLine());//test case 받기
		
		String arr[]=new String[testCase];
        StringTokenizer st;
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<testCase; i++) {
            st=new StringTokenizer(br.readLine()," ");
            int num1=Integer.parseInt(st.nextToken());
            int num2=Integer.parseInt(st.nextToken());
            if(num1>num2)
            {
            	sb.append("#").append(i+1).append(" ").append(">").append("\n");
            }
            else if(num1<num2)
            {
            	sb.append("#").append(i+1).append(" ").append("<").append("\n");

            }
            else
            	sb.append("#").append(i+1).append(" ").append("=").append("\n");

            
             
        }
        
        System.out.println(sb);
       
		
	}

}
