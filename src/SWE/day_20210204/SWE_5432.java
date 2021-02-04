package SWE.day_20210204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class SWE_5432 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			Stack<Character> stack=new Stack<Character>();
			String str=br.readLine();
			char[] ch=new char[str.length()];
			ch=str.toCharArray();
			int result=0;
			for(int i=0; i<ch.length; i++) {
				
				if(ch[i]=='(') {
					stack.push(ch[i]);
				}else {//¶Ñ²±ÀÌ ˆ«È÷¸é
					stack.pop();//·¹ÀÌÀú´Ï²² »b
					if(ch[i-1]=='(') {//¶Ñ²±ÀÌ ´ÝÈ÷°í ¸¶Áö¸·¿¡ µé¾î°¬´ø°Ô '('ÀÌ¸é 
						result+=stack.size();//¸·´ë±â ºÎºÐ ´õÇÏ±â
					}
					else {//')'
						result++;
					}
					
					
				}
				
				
				
				
			}
			
			
			
			System.out.println("#"+(t)+" "+result);
		}
		
		
	}

}
