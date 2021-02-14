package BACK.month_202102.day_20210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BACK_15656 {
	static int[] sel;
	static StringBuilder sb;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr=new int[N];
		StringTokenizer st1=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st1.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		sb=new StringBuilder();
		sel=new int[N];
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

				permutation(arr, sel, k+1);
			
			
			
		}
	}

}
