package BACK.day_20210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BACK_15649 {
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

		// 중복 순열(증복 가능, 순서 있다)->완 탐
		permutation(arr, new int[M], 0, new boolean[N]);
	}

	private static void permutation(int[] arr, int[] sel, int k, boolean[] v) {
		if (k == sel.length) {
			for(int i=0; i<sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(v[i]==true) {
				continue;
			}
			sel[k] = arr[i];
			v[i]=true;
			permutation(arr, sel, k + 1, v);
			v[i]=false;
		}
	}

}
