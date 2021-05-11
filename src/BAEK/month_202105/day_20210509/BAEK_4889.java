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
					cnt++;//�ٲ����ϱ� ī��Ʈ
					ch[i]='{';
					stack.push(ch[i]);
				}else if(!stack.isEmpty() && stack.peek()=='{' && ch[i]=='}') {
					stack.pop();
				}else {
					stack.push(ch[i]);
				}
			}
			
			cnt=cnt+stack.size()/2;//�����Ŵ� '{'�̰͸� �ְ� �� ���� ������ ������ �ٲٴ� Ƚ��
			System.out.println(t+"."+" "+cnt);
		}
	}

}
