package BACK.day_20210205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BACK_1966 {
	
	static int N;
	static int M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t=1; t<=testCase; t++) {
			int result=0;
			st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());//num of documents
			M=Integer.parseInt(st.nextToken());//몇번쨰로 인쇄 되었는지?
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());			
			Queue<printer> q=new LinkedList<printer>();
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				int n=Integer.parseInt(st.nextToken());
				q.add(new printer(i,n));
				pq.offer(n);
			}
			int count=0;
			while(true) {
				if((pq.peek())!=(q.peek().priority)) {//제일 큰 우선순위가 아니면
					q.offer(q.poll());//뒤로
				}
				else {//같으면
					if(q.peek().idx==M) {
						break;
					}
					q.poll();
					pq.poll();
					count++;
				}
			}
			System.out.println(count+1);
			
			
			
			
		}
	}
	


}
class printer {
		int idx;
		int priority;
		printer(int idx, int priority){
			this.idx=idx;
			this.priority=priority;
		}
	}