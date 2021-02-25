package BAEK.month_202102.day_20210225;

import java.util.Scanner;
import java.util.Stack;

public class BAEK_17413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Stack<Character> stack=new Stack<Character>();
		String str=sc.nextLine();
		char[] ch=str.toCharArray();
		boolean flag=false;
		for(int i=0; i<ch.length; i++) {
			if(ch[i]=='<') {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				flag=true;
			}
			
			if(ch[i]=='>') {
				flag=false;
				System.out.print(ch[i]);
				continue;
			}
			
			
			if(!flag) {
				if(ch[i]!=' ') {
					stack.push(ch[i]);
				}
				else {
					while(!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(" ");
				}
			}
			else {
				System.out.print(ch[i]);
			}
			
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
	}

}
