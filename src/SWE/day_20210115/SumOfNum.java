package SWE.day_20210115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());//숫자받기
		
		int sum=0;
		while(N!=0) {
			sum+=N%10;
			N=N/10;
		}
		
		System.out.println(sum);
		
		

	}

}
