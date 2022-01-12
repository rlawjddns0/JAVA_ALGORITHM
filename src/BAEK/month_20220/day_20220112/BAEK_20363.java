package BAEK.month_2022201.day_20220111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEK_20364 {
	static int N,Q;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		StringBuffer sb=new StringBuffer();
		visit=new boolean[N+1];
		
		for(int i=0; i<Q; i++) {
			int duck=Integer.parseInt(br.readLine());
			int tmp=duck;
			int tp=0;
			boolean flag=false;
			Stack<Integer> stack=new Stack<>();
			while(tmp!=0) {
				stack.push(tmp);
				tmp/=2;
			}
			
			while(!stack.isEmpty()) {
				int g=stack.pop();
				if(visit[g]) {
					sb.append(g).append("\n");
					flag=true;
					break;
				}
			}
			if(!flag) {
				sb.append(0).append("\n");
				visit[duck]=true;
			}
			
		}
		
		System.out.println(sb);
		
		
		
		
	}
	
}
