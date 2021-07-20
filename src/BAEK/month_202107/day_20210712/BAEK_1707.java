package BAEK.month_202107.day_20210712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 이분그래프인지 아닌지를 확인하는 문제였다
 * 이분그래프는 현재 탐색 정점과 이어지는 모든 정점이 다른 색으로 구분이 되어야 한다.
 * 즉 1번 정점을 빨간색으로 탐색을 시작하면 1번 정점과 이어지는 다른 정점들은 파란색이어야 한다.
 * 이렇게 1번부터 방문하지 않은 정점을 확인하면서 색으로 구분을 한다.
 * 그리고 정점을 확인하면서 선책한 정점과 이어지는 정점의 색갈이 같으면 이분그래프가 아니다.
 */
public class BAEK_1707 {
	static int T;
	static int V,E;
	static ArrayList<Integer>[] g;
	static int[] visit;
	static int RED=1;//정점을 구분하기위해서 색을 나눈다. 여기서 0은 미방분 정점이다.
	static int BLUE=2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			//입력
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			visit=new int[V+1];
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
			for(int i=1; i<=V; i++) {
				if(visit[i]==0) {//방문하지 않았으면
					bfs(i);//탐색
				}
			}
			
			boolean flag=check();
			
			if(flag) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
		}
		
		
	}
	
	private static boolean check() {//이분 그래프인지 확인하는 함수
		for(int i=1; i<=V; i++) {
			int size=g[i].size();//i 정점과 이어지는 점점의 수
			for(int j=0; j<size; j++) {
				int next=g[i].get(j);//i 정점과 이어지는 정점
				if(visit[i]==visit[next])return false;//둘의 색이 같으면 이분그래프가 아니다.
			}
		}
		
		return true;
	}
	private static void bfs(int start) {
		
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		int color=RED;//처음에는 빨간색을 가진다고 가정한다.
		visit[start]=color;//첫 탐색 정점은 빨간색
		
		while(!q.isEmpty()) {
			
			int now=q.poll();
			if(visit[now]==RED) {//현재 탐색 정점이 빨간색이면 다음 탐색 정점은 파란색으로 바꾼다.
				color=BLUE;
			}else if(visit[now]==BLUE) {//반대
				color=RED;
			}
			for(int i=0; i<g[now].size(); i++) {
				if(visit[g[now].get(i)]==0) {//아직 방문하지 않았으면
					visit[g[now].get(i)]=color;//그 정점을 현재 탐색 정점과는 다른 색으로 체크
					q.offer(g[now].get(i));//큐에 넣는다.
				
				}
			}
			
		}
		
		
		
	}

}
