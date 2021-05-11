package BAEK.month_202105.day_20210509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BAEK_4889 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		L: while (true) {
			char[] ch = br.readLine().toCharArray();
			for (int i = 0; i < ch.length; i++) {
				if (ch[i] == '-')
					break L;
			}
			Stack<Character> stack = new Stack<>();
			int cnt=0;
			for (int i = 0; i < ch.length; i++) {
				if (stack.isEmpty() && ch[i]=='}') {
					cnt++;//바꿨으니까 카운트
					ch[i]='{';
					stack.push(ch[i]);
				}else if(!stack.isEmpty() && stack.peek()=='{' && ch[i]=='}') {
					stack.pop();
				}else {
					stack.push(ch[i]);
				}
			}
			
			cnt=cnt+stack.size()/2;//남은거는 '{'이것만 있고 이 수를 반으로 나눈게 바꾸는 횟수
			System.out.println(t+"."+" "+cnt);
		}
	}

}
