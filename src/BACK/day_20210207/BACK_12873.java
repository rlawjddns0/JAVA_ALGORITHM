package BACK.day_20210207;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BACK_12873 {
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Deque<Integer> q = new LinkedList<Integer>();
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		if (N == 1) {
			System.out.println("1");
		} else {
			long t = 2;
			q.poll();
			while (q.size() != 1) {
				long n = (long) Math.pow(t, 3);
				n %= q.size();
				if (n == 0) {
					n = q.size();
				}
				for (int i = 0; i < n - 1; i++) {
					q.offer(q.poll());
				}
				q.poll();

				t++;
			}
		}
		System.out.println(q.poll());
	}

}
