package BAEK.month_202102.day_20210204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BACK_2941 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len=str.length();
		int count=0;
		for(int i=0; i<len; i++) {
			
			
			if(str.charAt(i)=='c' &&i+1<len) {
				if(str.charAt(i+1)=='=') {
					i++;//비교했으니까 넘긴다.
				}
				else if(str.charAt(i+1)=='-') {
					i++;
				}
				
			}
			else if(str.charAt(i)=='d' && i+1<len) {
				if(str.charAt(i+1)=='z'&& i+2<len) {
					if(str.charAt(i+2)=='=') {
						i+=2;
						
					}
				}
				else if(str.charAt(i+1)=='-') {
					i++;
					
				}
			}else if(str.charAt(i)=='l' &&i+1<len) {
				if(str.charAt(i+1)=='j') {
					i++;
					
				}
			}
			else if(str.charAt(i)=='n' &&i+1<len) {
				if(str.charAt(i+1)=='j') {
					i++;
					
				}
			}
			else if(str.charAt(i)=='s' &&i+1<len) {
				if(str.charAt(i+1)=='=') {
					i++;
					
				}
			}
			else if(str.charAt(i)=='z' &&i+1<len) {
				if(str.charAt(i+1)=='=') {
					i++;
					
				}
			}
		
				count++;
			
			
		}
		System.out.println(count);

	}

}
