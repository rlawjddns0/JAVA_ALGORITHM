package BACK.day_20210206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BACK_2503 {
	static Deque<Integer> q1;
	static Deque<Integer> q2;
	static Deque<Integer> q3;
	static Deque<Integer> q4;
	static int[] dx= {1,-1};
	static multiQ[] mq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		q1=new LinkedList();
		q2=new LinkedList();
		q3=new LinkedList();
		q4=new LinkedList();
		mq=new multiQ[4];
		String s1=br.readLine();
		char[] ch1=s1.toCharArray();
		for(int i=0; i<8; i++) {
			q1.offer(ch1[i]-48);
		}
		
		String s2=br.readLine();
		char[] ch2=s1.toCharArray();
		for(int i=0; i<8; i++) {
			q2.offer(ch1[i]-48);
		}
		
		String s3=br.readLine();
		char[] ch3=s1.toCharArray();
		for(int i=0; i<8; i++) {
			q3.offer(ch1[i]-48);
		}
		
		String s4=br.readLine();
		char[] ch4=s1.toCharArray();
		for(int i=0; i<8; i++) {
			q4.offer(ch1[i]-48);
		}
		//N극은 0 S극은 1
		mq[0]=new multiQ(q1);
		mq[1]=new multiQ(q2);
		mq[2]=new multiQ(q3);
		mq[3]=new multiQ(q4);
		
		int k=Integer.parseInt(br.readLine());//회전 수
		int[][] arr=new int[k][2];
		for(int i=0; i<k; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		
		//1 시계 방향 -1 반시계 
		//시계라는건 큐를 -> 쪽으로 반시계는 반대 
		for(int i=0; i<k; i++) {
			int num=arr[i][0];
			int dir=arr[i][1];
			
			if(num==1) {
				int first=(int) mq[i].q.peekFirst();
				int last=(int) mq[i].q.peekLast();
				
				
			}
			else if(num==2) {
				
			}
			else if(num==3) {
				
			}
			else {
				
			}
			
			
			
		}
	
		
		
		
		
		
		
	}
//	static private void rotation(Deque q,int n, int dir, int first, int last) {
//		
//		if(q.peekFirst()==mq[n].q.)
//		
//		
//		for(int i=0; i<2; i++) {
//			int nn=n+dx[i];
//			if(nn<4 && nn>=0) {
//				rotation(q,nn, dir, first, last);
//			}
//		}
//		
//		
//		
//	}
//
//}
}
class multiQ{
	Deque q;
	public multiQ(Deque q) {
		// TODO Auto-generated constructor stub
		this.q=q;
	}
}




