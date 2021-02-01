package SWE.day_20210201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class SWE_5658 {
	static char[] arr;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new char[N];
			String str = br.readLine();
			arr = str.toCharArray();
			// int[] num=new int[N];
			Set<Integer> num = new HashSet<Integer>();

			int count = N / 4;// 몇번 돌릴꺼냐?

			for (int i = 0; i < count; i++) {
				for (int j = 0; j <= 3; j++) {
					StringBuilder sb = new StringBuilder();
					for (int k = j * count; k < j * count + count; k++) {
						sb.append(arr[k]);
					}
					num.add(Integer.parseInt(sb.toString(), 16));
				}
				move(arr);
			}

			List result = new ArrayList<Integer>(num);

			Collections.sort(result, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			});
			for (int i = 0; i < result.size(); i++) {
				if (i == (K - 1)) {
					System.out.println("#" + (t + 1) + " " + result.get(K - 1));
					break;
				}
			}

		}
	}

	public static void move(char[] arr) {
		char temp = arr[arr.length - 1];

		for (int i = arr.length - 1; i >= 1; i--)
			arr[i] = arr[i - 1];
		arr[0] = temp;

	}

}
