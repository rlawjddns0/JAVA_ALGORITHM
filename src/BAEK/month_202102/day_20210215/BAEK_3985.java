package BAEK.month_202102.day_20210215;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_3985 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		cake[] c = new cake[N];
		int[] arr = new int[L + 1];
		for (int i = 0; i < N; i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			c[i] = new cake(p, k, i + 1);
		}

		for (int i = 0; i < N; i++) {
			for (int j = c[i].first; j <= c[i].second; j++) {
				if (arr[j] == 0) {
					arr[j] = i + 1;
				}
			}

		}

		Arrays.sort(c);
		System.out.println(c[0].idx);
		int max = Integer.MIN_VALUE;
		int index=0;
		for (int j = 1; j <= N; j++) {
			int count=0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]==j) {
					count++;
				}
			}
			if(max<count) {
				max=count;
				index=j;
			}
			
		}
		System.out.println(index);
		

	}

}

class cake implements Comparable<cake> {
	int first;
	int second;
	int idx;

	cake(int p, int k, int idx) {
		this.first = p;
		this.second = k;
		this.idx = idx;
	}

	@Override
	public int compareTo(cake o) {
		// TODO Auto-generated method stub
		if (Math.abs(o.second - o.first) - Math.abs(this.second - this.first) == 0) {
			return this.idx - o.idx;
		}
		return Math.abs(o.second - o.first) - Math.abs(this.second - this.first);
	}

	@Override
	public String toString() {
		return "cake [first=" + first + ", second=" + second + "]";
	}

}