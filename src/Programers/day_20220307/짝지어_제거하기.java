package Programers.day_20220307;

import java.util.Stack;

public class 짝지어_제거하기 {
	public static void main(String[] args) {
		
		System.out.println(solution("cdcd"));
		
		
		
	}
	
	
	
	
	public static int solution(String s)
    {

        Stack<Character> stack=new Stack<Character>();
       stack.add(s.charAt(0));
        
        for(int i=1; i<s.length(); i++) {
        	if(stack.isEmpty()) {
        		stack.add(s.charAt(i));
        		continue;
        	}
        	
        	
        	if(stack.peek()==s.charAt(i)) {
        		stack.pop();
        	}else {
        		stack.add(s.charAt(i));
        	}
        }
        
        
        if(stack.size()==0)return 1;
        
        
        

        return 0;
    }
}
