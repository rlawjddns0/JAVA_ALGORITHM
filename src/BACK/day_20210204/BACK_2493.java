package BACK.day_20210204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BACK_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Integer> stack=new Stack<Integer>();
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		Stack<Integer> idx=new Stack<Integer>();
		StringBuffer sb=new StringBuffer();
		
		stack.push(Integer.parseInt(st.nextToken()));
		idx.push(1);//처음꺼 집어넣어주고 시작
		sb.append("0 ");
		for(int i=2; i<=N; i++) {
			int value=Integer.parseInt(st.nextToken());
			
			
			while(!stack.isEmpty()) {
				if(value<stack.peek()) {
					sb.append(idx.peek()+" ");
					break;
				}
				stack.pop();
				idx.pop();
				
			}
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			stack.push(value);
			idx.push(i);
		}
		System.out.println(sb);
			
		
		
		
		
	}

}
