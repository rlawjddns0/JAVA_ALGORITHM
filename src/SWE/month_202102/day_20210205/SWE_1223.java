package SWE.month_202102.day_20210205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SWE_1223 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			
			int N = Integer.parseInt(br.readLine());// 문자열 길이
			N+=1;
			char[] ch = new char[N];// 길이만큼 +1캐릭터형 배열 생성
			String str = br.readLine();// 한번에 다 읽기
			ch = str.toCharArray();// 스트링을 한번에 문자열에 집어넣기
			Stack<Character> stack = new Stack<Character>();// 후위 표사을 위한 스택 선언
						/////////////////////////////// 알고리즘
			char[] tmp = new char[N];// 후위 표기식을 담을 배열
			int i = 0;
			StringBuffer sb=new StringBuffer();
			while (i<N-1) {
				if (ch[i] >= 49 && ch[i] <= 57) {// 슛자가 오면
					sb.append(ch[i]);
				} else {//연산자가 오면
					if (stack.empty()) {
						stack.push(ch[i]);
					} else {
						if (ch[i] == '*') {
							if(stack.peek()=='+') {
								stack.push(ch[i]);
							}else {
								sb.append(stack.pop());
								stack.push(ch[i]);
							}
						} else {//더하기가 오면
							if(stack.peek()=='+' ||stack.peek()=='*') {
								sb.append(stack.pop());
								stack.push(ch[i]);
							}
							
						}

					}
				}
				i++;
			}//while end
			while(!stack.isEmpty())sb.append(stack.pop());
			/////////////////////////////////////////후위 연산 ///////////////////////////////////
			System.out.println(sb);
			String tps=sb.toString();
			char[] tp=new char[N-1];//1늘려준거 다시 뺴준다
			tp=tps.toCharArray();
			
			Stack<Integer> stack1=new Stack<Integer>();
			

			for(int j=0; j<tp.length; j++) {
				if(tp[j]>=48 && tp[j]<=57) {
					stack1.push(tp[j]-48);
				}
				else {
					int n=stack1.pop();
					int m=stack1.pop();
					if(tp[j]=='*') {
						int num=n*m;
						stack1.push(num);
					}
					else {
						int num=n+m;

						stack1.push(num);
					}
				}
				
			}
			
			
			System.out.println("#"+t+" "+(stack1.pop()));
			
			
			
			
			
			

		}//testCase end

	}

}
