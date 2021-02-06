package BACK.day_20210207;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BACK_12873 {
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Scanner sc=new Scanner(System.in);
				Deque<Integer> q=new LinkedList<Integer>();
				int N=sc.nextInt();
				
				for(int i=1; i<=N; i++) {
					q.offer(i);
				}
				int t=2;
				q.poll();
				while(q.size()!=1) {
					int n=(int) Math.pow(t, 3);
					
					for(int i=0; i<n%q.size(); i++) {
						q.offer(q.poll());
					}
					q.pollLast();
					t++;
				}
				
				System.out.println(q.poll());

	}
	
	public static void move() {
		int temp = arr[7];
		for (int i = 7; i >= 1; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = temp;
	}

}
