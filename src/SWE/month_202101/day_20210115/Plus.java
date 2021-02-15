package SWE.month_202101.day_20210115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Plus {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int NUM=Integer.parseInt(br.readLine());
		StringBuffer sb=new StringBuffer();
		for(int i=1; i<=NUM; i++) {
			if(NUM%i==0) {
				if(i==NUM)
				{	sb.append(i);
					break;}
				else {
					sb.append(i).append(" ");
				}
			}
			
		}
		System.out.println(sb);
	}

}
