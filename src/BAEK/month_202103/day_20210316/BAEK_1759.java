package BAEK.month_202103.day_20210316;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_1759 {
	static int L, C;
	static int[] ch;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		ch = new int[C];

		for (int i = 0; i < C; i++) {
			ch[i] = sc.next().charAt(0) - 'a';
		}

		Arrays.sort(ch);
//		for (int i = 0; i < ch.length; i++) {
//			System.out.print(Character.toChars(ch[i] + 'a'));
//		}
//		System.out.println();

		dfs(new int[L], 0, 0);

	}

	private static void dfs(int[] sel, int k, int idx) {

		if (k == sel.length) {
			int V = 0;// 모음
			int C = 0;// 자음
			for (int i = 0; i < sel.length; i++) {
				if (sel[i] + 'a' == 'a' || sel[i] + 'a' == 'e' || sel[i] + 'a' == 'i' || sel[i] + 'a' == 'o'
						|| sel[i] + 'a' == 'u') {
					V++;
				} else {
					C++;
				}
			}
			if (V >= 1 && C >= 2) {

				for (int i = 0; i < sel.length; i++) {
					System.out.print(Character.toChars(sel[i] + 'a'));
				}
				System.out.println();
			} else {
				return;
			}

			return;
		}
		for (int i = idx; i < ch.length; i++) {
			sel[k] = ch[i];
			dfs(sel, k + 1, i + 1);
		}

	}

}
