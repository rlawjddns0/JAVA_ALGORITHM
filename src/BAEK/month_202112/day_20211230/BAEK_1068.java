package BAEK.month_202112.day_20211230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BAEK_1068 {
	static int N;
	static int deleteN;
	static int[] arr;
	static int headNode;
	static ArrayList<ArrayList<Integer>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N];  
		boolean[] visit=new boolean[N];
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		graph=new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<N; i++) {
			int node=Integer.parseInt(st.nextToken());
			if(node==-1)headNode=i;
			else {
				graph.get(node).add(i);
			}
		}
		
//		for(int i=0; i<N; i++) {
//			System.out.println(graph.get(i).toString());
//		}
		
		deleteN=Integer.parseInt(br.readLine());
		
		visit[deleteN]=true;
		
		if(deleteN==headNode) {
			System.out.println("0");
			return;
		}
		
		if(graph.get(headNode).size()==1 && visit[graph.get(headNode).get(0)]) {
			
			System.out.println("1");
			return;
		}
		for(int i=0; i<graph.get(headNode).size(); i++) {
			if(visit[graph.get(headNode).get(i)])continue;
			visit[graph.get(headNode).get(i)]=true;
			dfs(graph.get(headNode).get(i),visit);
		}
		
		
		
		System.out.println(cnt);
		
	}
	static int cnt=0;
	private static void dfs(Integer integer, boolean[] visit) {
		System.out.println(integer);
		if(graph.get(integer).size()==0 || graph.get(integer).size()==1) {
			cnt++;
			return;
		}
		
		for(int i=0; i<graph.get(integer).size(); i++) {
			if(visit[graph.get(integer).get(i)])continue;
			visit[graph.get(integer).get(i)]=true;
			dfs(graph.get(integer).get(i),visit);
		}
		
		
		
		
		
		
		
	}
	
}
