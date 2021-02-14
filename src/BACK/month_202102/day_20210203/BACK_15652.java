package BACK.month_202102.day_20210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_15652 {
	static int[] sel;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	

		// 중복 o 순서 x
		sb=new StringBuilder();
		sel=new int[N];
		permutation(N, M, 0, 0);
		System.out.println(sb);
	}

	private static void permutation(int N, int M, int k, int idx) {
	      if(idx == M) {
	         for (int i = 0; i < M; i++) {
	            sb.append(sel[i] + " ");
	         }
	         sb.append('\n');
	         return;
	      }
	      for (int i = k; i < N; i++) {
	         sel[idx] = i+1;
	         permutation(N,M,i,idx+1);
	      }
	   }
}
