package SWE.day_20210118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SWE_1989 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        String arr[]=new String[testCase];
        int result[]=new int[testCase];
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < testCase; i++) {
			arr[i]=br.readLine();
			sb.append(arr[i]);			
			
			if(arr[i].equals((sb.reverse()).toString())) {
				result[i]=1;
			}
			else
				result[i]=0;
			
			sb.setLength(0);
			
		}
        
        
        for(int i=0; i<testCase; i++)
        {
        	System.out.printf("#%d %d",i+1,result[i]);
        	System.out.println();
        }
       
        
        
	}

}
