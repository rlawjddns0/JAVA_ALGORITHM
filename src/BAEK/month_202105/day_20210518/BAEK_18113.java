package BAEK.month_202105.day_20210518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_18113 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());// ±Ëπ‰¿« ∞≥ºˆ
		int K = Integer.parseInt(st.nextToken());// ≤ø¥Ÿ∏Æ¿« ±Ê¿Ã
		int M = Integer.parseInt(st.nextToken());// ±Ëπ‰¡∂∞¢¿« √÷º“∞≥ºˆ

		ArrayList<Integer> kim = new ArrayList<>();
		int left = 1;
		int right = 0;
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			right=Math.max(tmp, right);
			if (tmp <= K)
				continue;
			else if (tmp < 2 * K) {
				kim.add(tmp - K);
			} else {
				kim.add(tmp - 2 * K);
			}
		}

		int middle = 0;
		int ans = 0;
		int max=right;
		while (left <= right) {
			middle = (left + right) / 2;
			int tmpm = 0;
			for (int i = 0; i < kim.size(); i++) {
				tmpm += kim.get(i) / middle;
			}

			if (tmpm < M) {
				right = middle - 1;

			} else if (tmpm >= M) {
				
				left = middle + 1;
				ans = Math.max(ans, middle);
			}

		}
		if (ans==0) {
			System.out.println("-1");
		} else {
			System.out.println(ans);
		}

	}

}
