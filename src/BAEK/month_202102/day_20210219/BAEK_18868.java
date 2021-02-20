package BAEK.month_202102.day_20210219;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_18868 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		planet[][] universe = new planet[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				universe[i][j] = new planet(j, sc.nextInt());
			}
		}
		for (int i = 0; i < M; i++) {
			Arrays.sort(universe[i]);
		}

//		for (int i = 0; i < M; i++) {
//			System.out.println(Arrays.toString(universe[i]));
//		}
		boolean flag = true;
		int count = 0;
		for (int k = 0; k < M - 1; k++) {

			for (int i = k + 1; i < M; i++) {
				flag = true;
				for (int j = 0; j < N; j++) {
					if (universe[k][j].idx != universe[i][j].idx) {
						flag = false;
					}

				}
				if (flag) {
					count++;
				}
			}

		}

		System.out.println(count);
	}

}

class planet implements Comparable<planet> {
	int idx;
	int size;

	planet(int idx, int size) {
		this.idx = idx;
		this.size = size;
	}

	@Override
	public int compareTo(planet o) {
		// TODO Auto-generated method stub
		if(this.size-o.size==0) {
			return o.idx-this.idx;
		}
		return this.size - o.size;
	}

	@Override
	public String toString() {
		return "planet [idx=" + idx + ", size=" + size + "]";
	}

}
