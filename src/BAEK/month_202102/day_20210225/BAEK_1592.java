package BAEK.month_202102.day_20210225;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_1592 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int L=sc.nextInt();
		int[] arr=new int[N+1];
		Deque<Integer> q=new LinkedList<Integer>();
		for(int i=1; i<=N; i++)q.offer(i);
		System.out.println(q.toString());
		arr[q.peek()]++;//1�� �� ����
		int i=1;
		int count=0;
		while(true) {
			if(arr[i]%2==0) {//¦�����̸� �ڱ� ���� ��ġ���� �ݽð� �������� L��° �ִ� ������� ������
				for(int j=0; j<L; j++)q.addFirst(q.pollLast());
				i=q.peek();
				arr[q.peek()]++;
			}else {
				for(int j=0; j<L; j++)q.offer(q.pollFirst());
				i=q.peek();
				arr[q.peek()]++;
			}
			
			
			count++;
			if(arr[i]==M)
			{
				break;
			}
			
			
		}
		System.out.println(count);
		
		
	}

}
