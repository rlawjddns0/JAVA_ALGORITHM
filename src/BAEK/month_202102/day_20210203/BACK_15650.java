package BAEK.month_202102.day_20210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_15650 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = i + 1;

		// 중복 x 순서 O
		permutation(arr, new int[M],0, 0);
	}

	private static void permutation(int[] arr, int[] sel,int idx ,int k) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			sel[k]=arr[i];
			permutation(arr,sel,i+1,k+1);
			
		}
	}
}
