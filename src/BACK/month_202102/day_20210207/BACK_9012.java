package BACK.month_202102.day_20210207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BACK_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		int testCase=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			String str=br.readLine();
			char[] ch=str.toCharArray();
			Stack<Character> stack=new Stack<>();
			int i=0;
			for(i=0; i<ch.length; i++) {
				if(ch[i]=='(') {
					stack.push(ch[i]);
				}
				else if(ch[i]==')'){
					if(stack.isEmpty()) {
						//System.out.println("NO");
						break;
					}
					if(stack.peek()==')'  ) {
						//System.out.println("NO");
						break;
					}else{
						stack.pop();
					}
				}
			}
			
			if(i==ch.length && stack.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
			
		}
		
	}

}
