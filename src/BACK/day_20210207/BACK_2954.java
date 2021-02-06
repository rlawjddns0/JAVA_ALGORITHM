package BACK.day_20210207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BACK_2954 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char[] ch=br.readLine().toCharArray();
		StringBuilder sb=new StringBuilder();
		
		
		for(int i=0; i<ch.length; i++) {
			if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u') {
				sb.append(ch[i]);
				i+=2;
			}
			else {
				sb.append(ch[i]);
			}
			
		}
		System.out.println(sb);
		
		
		

	}

}
