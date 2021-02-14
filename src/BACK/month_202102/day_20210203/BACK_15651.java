package BACK.month_202102.day_20210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_15651 {
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = i + 1;

		// �ߺ� o ���� x
		sb=new StringBuilder();
		permutation(arr, new int[M], 0);
		System.out.println(sb);
	}

	private static void permutation(int[] arr, int[] sel,int k) {
		if (k == sel.length) {
			for(int i=0; i<sel.length; i++)
			{	sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			sel[k]=arr[i];
			permutation(arr,sel,k+1);
			
		}
	}
}
