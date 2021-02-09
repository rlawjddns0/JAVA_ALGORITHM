package BACK.day_20210209;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++)
			q.offer(i);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		while (!q.isEmpty()) {
			int r = K - 1;// r¹ø È¸Àü
			if (r % q.size() == 0) {
				r = q.size();
			} else {
				r = r % q.size();
			}
			for (int i = 0; i < r; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll() + ", ");
		}

		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb);
	}

}
