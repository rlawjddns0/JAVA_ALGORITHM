package SWE.day_20210204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class SWE_1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			char[] arr = new char[T];
			String str = br.readLine();
			arr = str.toCharArray();
			Stack<Character> ch = new Stack<>();
			int i = 0;
			int cnt = 0;
			for (i = 0; i < arr.length; ) {
				if (arr[i] == ']' && ch.peek() == '[') {
					ch.pop();
					i++;
				} else if (arr[i] == '}' && ch.peek() == '{') {
					ch.pop();
					i++;
				} else if (arr[i] == ')' && ch.peek() == '(') {
					ch.pop();
					i++;
				}
				else if (arr[i] == '>' && ch.peek() == '<') {
					ch.pop();
					i++;
				}
				else {
					ch.push(arr[i]);
					i++;
				}
				//System.out.println(ch.toString());
			}
			
			if (ch.size()==0)
				System.out.println("#"+t+" "+"1");
			else
				System.out.println("#"+t+" "+"0");
		}
	}

}
