package BACK.month_202102.day_20210214;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_9934 {
	static int[] arr;
	static int[] result;
	static int length;
	static int K;
	static int count=1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		K=sc.nextInt();
		length=(int)Math.pow(2, K)-1;
		arr=new int[length+1];
		result=new int[length+1];
		for(int i=1; i<=length; i++) {
			arr[i]=sc.nextInt();
		}
		solve(1,1);
		int tp=1;
		int n=1;
		for(int i=0; i<K; i++) {
			for(int j=tp; j<=n;j++) {
				System.out.print(result[j]+" ");
			}
			System.out.println();
			tp*=2;
			n=n*2+1;
		}
		
		
		
		
	}

	static void solve(int idx, int d) {

		if (d == K) {
			result[idx] = arr[count++];
			return;
		} 
			solve(idx * 2, d + 1);
			result[idx] = arr[count++];
			solve(idx * 2 + 1, d + 1);
		
	}

}
