package BACK.day_20210122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class BACK_10988 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		char[] arr=new char[100];
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		arr=br.readLine().toCharArray();
		char[] tmp=new char[arr.length];
		
		for(int i=tmp.length-1,j=0; i>=0; i--,j++)
			tmp[j]=arr[i];
		
//		for(int i=0; i<tmp.length; i++)
//			System.out.println(tmp[i]);
			
		int count=0;
		for(count=0; count<tmp.length; count++)
		{
			if(tmp[count]==arr[count]) {
				continue;
			}
			else
				break;
		}
		
		if(count==tmp.length)
			System.out.println("1");
		else
			System.out.println("0");
		
	}

}
