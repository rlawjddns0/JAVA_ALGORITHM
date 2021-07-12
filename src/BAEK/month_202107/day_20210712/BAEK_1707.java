package BAEK.month_202107.day_20210712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_1707 {
	static int T;
	static int V,E;
	static ArrayList<Integer>[] g;
	static boolean[] visit;
	static int[] color;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			//입력
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			visit=new boolean[V+1];
			color=new int[V+1];
			//어레이 리스트 초기화
			g=new ArrayList[V+1];
			for(int i=1; i<=V; i++) {
				g[i]=new ArrayList<>();
			}
			
			
			//연결된 정점 입력
			for(int i=0; i<E; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				//양 방향
				g[from].add(to);
				g[to].add(from);
			}
			
			//같은 층에서의 정점의 관계를 알기 위해서 bfs
			if(bfs()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
			
		}
		
		
	}
	
	
	private static boolean bfs() {
		
		Queue<Integer> q=new LinkedList<>();
		q.offer(1);
		color[1]=1;//빨강
		visit[1]=true;
		int before=1;
		int cnt=0;
		while(!q.isEmpty() &&cnt<V) {
			
			int tmp=q.poll();
			int tmp_color=-color[tmp];
			
			for(int i=0; i<g[tmp].size(); i++) {
				if(visit[g[tmp].get(i)]) {
					if(color[tmp]==tmp_color) {
						return false;
					}else {
						q.offer(g[tmp].get(i));
						
						
					}
				}else {
					q.offer(g[tmp].get(i));
					visit[g[tmp].get(i)]=true;
					color[g[tmp].get(i)]=tmp_color;
				}
			}System.out.println(Arrays.toString(color));
			System.out.println(q.toString());
			cnt++;
			
		}
		
		return true;
		
		
	}

}
