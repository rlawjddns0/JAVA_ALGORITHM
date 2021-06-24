package BAEK.month_202106.day_20210624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_2491 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println("1");
			return;
		}
		if(N==2) {
			System.out.println("2");
			return;
		}
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int upper = 1;
		int down = 1;
		int upper_max = 1;
		int down_max = 1;
		for (int i = 0; i < N - 2; i++) {
			if (arr[i] <= arr[i + 1]) {
				upper++;
			} else {
				upper_max = Math.max(upper_max, upper);
				upper = 1;
			}
			if (arr[i] >= arr[i + 1]) {
				down++;
			} else {
				down_max = Math.max(down_max, down);
				down = 1;
			}

		}
		if (arr[N - 2] <= arr[N - 1])
			upper++;
		if (arr[N - 2] >= arr[N - 1])
			down++;
		upper_max = Math.max(upper_max, upper);
		down_max = Math.max(down_max, down);
		System.out.println(upper_max < down_max ? down_max : upper_max);

	}

}
