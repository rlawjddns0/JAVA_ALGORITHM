package BACK.day_20210209;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_1260 {
	static int N,M,V;
	static boolean[] visit;
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		V=sc.nextInt();
		arr=new int[N+1][N+1];
		visit=new boolean[N+1];
		
		for(int i=0; i<M; i++)
		{
			int x=sc.nextInt();
			int y=sc.nextInt();
			arr[x][y]=arr[y][x]=1;
		}
//		for (int[] i : arr) {
//			System.out.println(Arrays.toString(i));
//		}
		dfs(V);
		System.out.println();
		bfs(V);
		
		
		
	}
	public static void dfs(int v) {
		
		visit[v]=true;
		System.out.print(v+" ");
		for(int i=1; i<=N; i++) {
			if(visit[i]==true || arr[v][i]==0)continue;
			dfs(i);
		}
		
		
	}
	public static void bfs(int v) {
		Queue<Integer> q=new LinkedList<Integer>();
		q.offer(v);
		visit[v]=false;
		while(!q.isEmpty()) {
			v=q.poll();
			System.out.print(v+" ");
			for(int i=1; i<=N; i++) {
				if(visit[i]==false || arr[v][i]==0)continue;
				
				q.offer(i);
				visit[i]=false;
				
			}
		}
		
		
		
	}

}
