package BAEK.month_202102.day_20210207;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BACK_2164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=1; i<=N; i++)
			q.offer(i);
		
		
		while(q.size()!=1) {
			q.poll();//카드를 버린다
			q.offer(q.poll());
		}
		
		System.out.println(q.poll());
		
	}

}
