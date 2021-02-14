package BACK.month_202102.day_20210207;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BACK_11866 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		Queue<Integer> q=new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++)
			q.offer(i);
		int r=K-1;
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			for(int i=0; i<r; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()+", ");
		}
		
		sb.setLength(sb.length()-2);
		sb.append(">");
		System.out.println(sb);
		
		
		
	}

}
