package BAEK.month_202104.day_20210428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_18233 {
	static int N, P, E;
	static person[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ans = new int[N];
		p = new person[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p[i] = new person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
		}

		permutation(new int[P], 0, 0);
		System.out.println("-1");

	}

	static int[] ans;

	private static void permutation(int[] sel, int k, int idx) {

		if (k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			int min = 0;
			int max = 0;
			int[] mmin = new int[N];
			int[] mmax = new int[N];
			for (int i = 0; i < sel.length; i++) {
				min += p[sel[i]].min;
				mmin[p[sel[i]].idx] = p[sel[i]].min;
				mmax[p[sel[i]].idx] = p[sel[i]].max;
				max += p[sel[i]].max;

			}
			if (!(min <= E && E <= max))
				return;
			System.out.println(min);
			if (min <= E && E <= max) {
				if (min == E) {
					for (int j = 0; j < mmin.length; j++) {
						System.out.print(mmin[j] + " ");
					}
					System.exit(0);
				}
				if (max == E) {
					for (int j = 0; j < mmin.length; j++) {
						System.out.print(mmax[j] + " ");
					}
					System.exit(0);
				}
				for (int i = 0; i < sel.length; i++) {
					int left = p[sel[i]].min + 1;
					int right = p[sel[i]].max;
					while (left <= right) {
						mmin[p[sel[i]].idx]++;
						min++;
						left++;

						if (min == E) {
							for (int j = 0; j < mmin.length; j++) {
								System.out.print(mmin[j] + " ");
							}
							System.exit(0);
						}

					}
				}
			}
			return;
		}

		for (int i = idx; i < N; i++) {
			if (p[i].min < E) {
				sel[k] = i;
				permutation(sel, k + 1, i + 1);
			}
		}

	}

}

class person {
	int min, max, idx;

	@Override
	public String toString() {
		return "person [min=" + min + ", max=" + max + "]";
	}

	public person(int min, int max, int idx) {
		super();
		this.min = min;
		this.max = max;
		this.idx = idx;
	}

}