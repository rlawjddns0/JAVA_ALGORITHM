package BAEK.month_202107.day_20210731;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2251 {
	static boolean[][] visit;
	static int A,B,C;
	static ArrayList<Integer> ans=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		visit=new boolean[201][201];
		
		
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		
		bfs();
		
		
		Collections.sort(ans);
		for(int a: ans) {
			System.out.print(a+"");
		}
		
		
		

	}
	private static void bfs() {
		
		
		Queue<bocket> q=new LinkedList<bocket>();
		
		q.offer(new bocket(0,0,C));
		
		while(!q.isEmpty()) {
			bocket cur=q.poll();
			
			int a=cur.a;
			int b=cur.b;
			int c=cur.c;
//			System.out.println(a+" "+b+" "+c);
			if(visit[a][b])continue;//이미 검사했으면 넘어가~
			visit[a][b]=true;
			if(a==0) {
				ans.add(c);
			}
			
			//a->b
			//a에서 b로 물을 옮기는데 a+b의 물 총량이 B를 넘어서면
			//a에는 a+b-B읨 물만 남고 B에는 B용량만큼 찬다.
			if(a+b>B) {
				q.offer(new bocket((a+b)-B,B,c));
			}else {
				q.offer(new bocket(0,a+b,c));
			}
			
			//a->c
			if(a+c>C) {
				q.offer(new bocket((a+c)-C,b,C));
			}
			else {
				q.offer(new bocket(0,b,a+c));
			}
			
			//b->a
			if(b+a>A) {
				q.offer(new bocket(A,(b+a)-A,c));
			}else {
				q.offer(new bocket(a+b,0,c));
			}
			
			
			//b->c
			if(b+c>C) {
				q.offer(new bocket(A,(b+c)-C,C));
			}else {
				q.offer(new bocket(a,0,b+c));
			}
			
			
			//c->a
			if(a+c>A) {
				q.offer(new bocket(A,b,(a+c)-A));
			}else {
				q.offer(new bocket(a+c,b,0));
			}
			
			//c->b
			if(b+c>B) {
				q.offer(new bocket(a,B,(b+c)-B));
			}else {
				q.offer(new bocket(a,b+c,0));
			}
			
			
			
		}
		
		
		
		
		
		
	}

}

class bocket {
	int a, b, c;

	public bocket(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

}