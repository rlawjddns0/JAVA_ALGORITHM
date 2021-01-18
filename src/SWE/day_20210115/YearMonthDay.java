package SWE.day_20210115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class YearMonthDay {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int daysOfMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31}; 
		int testCase;
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    testCase=Integer.parseInt(br.readLine());//test case ¹Þ±â
	        
        for(int tc=1; tc<=testCase; tc++) {
            String s = br.readLine();
            int month = Integer.valueOf(s.substring(4,6));
            int day = Integer.valueOf(s.substring(6,8));
            String res = "-1";
            if( 1<=month && month<=12 && 1<=day && day<=daysOfMonth[month-1] ) {
                res = String.format("%s/%s/%s", s.substring(0,4), s.substring(4,6), s.substring(6,8));
            }
            System.out.format("#%d %s\n", tc, res);
        }
        
       
        
        
        
        
        
        
        
	}

}
