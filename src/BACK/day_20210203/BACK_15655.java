package BACK.day_20210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BACK_15655 {
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
		permutation(arr, new int[M], 0, new boolean[arr.length], 0);
		System.out.println(sb);
	}

	private static void permutation(int[] arr, int[] sel,int k, boolean[] v, int idx) {
		if (k == sel.length) {
			for(int i=0; i<sel.length; i++)
			{	sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			if(v[i]==false) {
				sel[k]=arr[i];
				v[i]=true;
				permutation(arr, sel, k+1,v,i);
				v[i]=false;
			}
			
		}
	}

}
