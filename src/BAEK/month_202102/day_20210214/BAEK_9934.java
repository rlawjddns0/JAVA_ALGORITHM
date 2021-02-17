package BAEK.month_202102.day_20210214;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_9934 {
	static int[] arr;
	static int[] result;
	static int length;
	static int K;
	static int count = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();// 깊이
		length = (int) Math.pow(2, K) - 1;// 노드 수
		arr = new int[length + 1];// 1부터 노드 수까지
		result = new int[length + 1];// 결과 배열
		for (int i = 1; i <= length; i++) {
			arr[i] = sc.nextInt();
		}
		solve(1, 1);// 1번 깊이 1부터
		int tp = 1;
		int n = 1;
		for (int i = 0; i < K; i++) {
			for (int j = tp; j <= n; j++) {
				System.out.print(result[j] + " ");
			}
			System.out.println();
			tp *= 2;
			n = n * 2 + 1;
		}

	}

	static void solve(int idx, int d) {

		if (d == K) {// 더이상 자식이 없으면
			result[idx] = arr[count++]; 
			return;
		}
		solve(idx * 2, d + 1);// 왼쪽 자식
		result[idx] = arr[count++];// 부모
		solve(idx * 2 + 1, d + 1);// 오른쪽 자식

	}

}
