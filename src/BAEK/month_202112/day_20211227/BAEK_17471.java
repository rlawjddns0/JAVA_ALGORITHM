package BAEK.month_202112.day_20211227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_17471 {
	static int N;
	static int[] population;
	static ArrayList<ArrayList<Node>> graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		graph=new ArrayList<ArrayList<Node>>();
		population=new int[N+1];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=1; i<N+1; i++) {
			population[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int cnt=Integer.parseInt(st.nextToken());
			for(int j=0; j<cnt; j++) {
				graph.get(cnt).add(new Node(Integer.parseInt(st.nextToken())));
			}
		}
		
		
		
		solution(new boolean[N+1],1,1);
		
	}
	
	public static void solution(boolean[] visit,int idx, int k) {
		if(k==(N+1)/2+1) {
			for(int i=1; i<=(N+1)/2; i++) {
				if(visit[i])System.out.print(i+" ");
			}
			System.out.println();
			
			return;
		}
		
		
		
		
			visit[idx]=true;
			solution(visit,idx+1,k+1);
			visit[idx]=false;
			solution(visit,idx+1,k+1);
		
		
		
		
		
		
	}
	
}

class Node{
	int idx;

	public Node(int idx) {
		super();
		this.idx = idx;
	}
	
}
