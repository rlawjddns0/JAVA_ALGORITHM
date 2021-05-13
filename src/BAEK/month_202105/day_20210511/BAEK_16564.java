package BAEK.month_202105.day_20210511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_16564 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(num);
		int left = 0;
		int right = Integer.MAX_VALUE;
		int middle = 0;
		int ans = 0;
		while (left <= right) {

			middle = (left + right) / 2;
//			System.out.println("middle "+middle);
			long k = 0;
			for (int i = 0; i < N; i++) {
				if (num[i] < middle) {
					k += (middle - num[i]);
				} else {
					break;
				}
			}
//			System.out.println("k "+k);
			if (k > K) {

				right = middle - 1;

			} else {
				ans = Math.max(ans, middle);
				left = middle + 1;

			}

		}
		System.out.println(ans);
	}

}
