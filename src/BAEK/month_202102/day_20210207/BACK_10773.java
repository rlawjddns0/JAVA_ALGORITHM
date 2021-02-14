package BAEK.month_202102.day_20210207;

import java.util.Scanner;
import java.util.Stack;

public class BACK_10773 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int K=sc.nextInt();
		int[] arr=new int[K];
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0; i<K; i++)arr[i]=sc.nextInt();
		for(int i=0; i<K; i++) {
			if(arr[i]==0 && stack.peek()!=0) {
				stack.pop();
			}
			else {
				stack.push(arr[i]);
			}
		}
		int sum=0;
		while(!stack.isEmpty())sum+=stack.pop();
		System.out.println(sum);
	}

}
