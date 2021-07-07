package BAEK.month_202107.day_20210707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_5014 {
	static int F,S,G,U,D;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		F=Integer.parseInt(st.nextToken());//가장 높은 층 즉 건물에 크기
		S=Integer.parseInt(st.nextToken());//시작 층
		G=Integer.parseInt(st.nextToken());//목적 층
		U=Integer.parseInt(st.nextToken());//위로 몇층 갈 수 있는지
		D=Integer.parseInt(st.nextToken());//아래로 몇 층 갈 수 있는지
		
		
		int ans=bfs();//최소거리이므로 bfs로 ~
		if(ans==-1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(ans);
		}
		
		
		
		
		
		
	}
	private static int bfs() {
		Queue<floor> q=new LinkedList<>();
		q.add(new floor(S,0));//시작층과 층을 얼마나 옮겼는지에 대한 카운트를 넣어준다 
                              //처음 시작은 안움직이니까 0
		visit=new boolean[F+1];//1부터니까 +1

		visit[S]=true;//처음 시작한 층은 트루~
		
		
		while(!q.isEmpty()) {
			
			floor cur=q.poll();
			
			if(cur.current==G) {//지금 나온 층이 목적 층이면 지금까지 움직였던 카운트 리턴
				return cur.cnt;
			}
			
			
			if(cur.current+U<=F && !visit[cur.current+U]) {//위로 올라가는 경우 U를 더한게 F보다 작거나 같고 아직 방문 하지 않았다면
				q.offer(new floor(cur.current+U,cur.cnt+1));//U더한 값 넣어주고 카운트 +1
				visit[cur.current+U]=true;
			}
			
			if(cur.current-D>0 && !visit[cur.current-D]) {
				q.offer(new floor(cur.current-D,cur.cnt+1));
				visit[cur.current-D]=true;
			} 
			
			
			
			
		}
		
		
		return -1;
		
		
	
	}

}
class floor{
	int current;
	int cnt;
	public floor(int current, int cnt) {
		super();
		this.current = current;
		this.cnt = cnt;
	}
	
}