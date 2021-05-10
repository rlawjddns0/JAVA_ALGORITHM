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
			for (int i = 0; i < ch.length; i++) {
				if (stack.isEmpty()) {
					stack.push(ch[i]);
				} else {
					char tmp = stack.peek();
					if (ch[i] == '}' && tmp == '{') {
						stack.pop();
					} else {
						stack.push(ch[i]);
					}
				}
			}
			int[] check = new int[2];
			while (!stack.isEmpty()) {
				char tmp = stack.pop();
				if (tmp == '{')
					check[0]++;
				else
					check[1]++;
			}

			int ans = 0;
			if (check[0] > 0 && check[1] == 0) {
				ans = check[0] / 2;
			} else if (check[0] == 0 && check[1] > 0) {
				ans = check[1] / 2;
			} else {
				if (check[0] % 2 == 0 && check[1] % 2 == 0) {
					ans += check[0] / 2;
					ans += check[1] / 2;
				}
				else {
					int min = Math.min(check[0], check[1]);
					int max = Math.max(check[0], check[1]);
					if(min==max && min>1) {
						ans+=(max-1)*2;
						System.out.println(t + "." + " " + ans);
						continue;
					}
					ans += min * 2;
					ans += (max - min) / 2;
				}
			}

			System.out.println(t + "." + " " + ans);
			t++;
		}

	}

}
