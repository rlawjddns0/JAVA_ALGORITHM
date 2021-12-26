package BAEK.month_202112.day_20211226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BAEK_1927 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq=new  PriorityQueue<Integer>();
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<N; i++) {
			int num=Integer.parseInt(br.readLine());
			if(num==0) {
				if(pq.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(pq.poll()).append("\n");				}
			}else {
				pq.add(num);
			}
		}
		
		System.out.println(sb);
	}
}
