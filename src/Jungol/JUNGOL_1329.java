package Jungol;

import java.util.Scanner;

public class JUNGOL_1329 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int space = N / 2;
		int p = 0;
		int k = 1;
		if (N <= 0 || N > 99) {
			System.out.println("INPUT ERROR!");
		} else {
			for (int i = 0; i < N / 2; i++) {

				for (int j = 0; j < p; j++) {
					System.out.print(" ");
				}

				for (int j = 0; j < k; j++) {
					System.out.print("*");
				}
				System.out.println();
				p++;
				k += 2;

			}

			for (int i = 0; i < space; i++)
				System.out.print(" ");
			for (int i = 0; i < N; i++)
				System.out.print("*");
			System.out.println();

			p--;
			k -= 2;

			for (int i = N / 2 + 1; i < N; i++) {

				for (int j = p; j > 0; j--) {
					System.out.print(" ");
				}

				for (int j = k; j > 0; j--) {
					System.out.print("*");
				}
				System.out.println();
				p--;
				k -= 2;

			}

		}
	}

}
