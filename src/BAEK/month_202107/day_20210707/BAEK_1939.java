package BAEK.month_202107.day_20210707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_1939 {
	static int N,M;
	static int start,end;
	static ArrayList<v>[] g;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		visit=new boolean[N+1];
		
		g=new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			g[i]=new ArrayList<v>();
		}
		int left=1;
		int right=0;//Integer.MAX_VAULE로 하면 메모리 초과가 난다
		int middle=0;
		int ans=0;
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			g[from].add(new v(to,w));
			g[to].add(new v(from,w));
			right=Math.max(right, w);
		}
		
		st=new StringTokenizer(br.readLine()," ");
		start=Integer.parseInt(st.nextToken());
		end=Integer.parseInt(st.nextToken());
		
		
		while(left<=right) {//최대 중량을 찾기 위해서
			middle=(left+right)/2;
			
			if(solution(middle)) {//내가 찾은 중량이 트루면 ->시작점부터 끝점까지 middle로 갈 수 있으면
				ans=middle;//정답을 저장
				left=middle+1;//일단 무게를 더 올려본다.
			}else {//못가면
				right=middle-1;//무게를 내린다.
			}
			
			
			
			
			
		}
		
		
		
		System.out.println(ans);
		
	
	
	}
	static int ans=Integer.MIN_VALUE;
	private static boolean solution(int W) {
		Queue<Integer> q=new LinkedList<>();
		q.offer(start);
		Arrays.fill(visit, false);
		visit[start]=true;
		
		
		while(!q.isEmpty()) {
			int next=q.poll();
			
			if(next==end) {
				return true;
			}
			
			for(int i=0; i<g[next].size(); i++) {
				if(!visit[g[next].get(i).next]&& g[next].get(i).w>=W) {//아직 방문 안했고  이분 탐색한 무게로 갈 수 있으면
					q.offer((g[next].get(i).next));//큐에 넣고
					visit[g[next].get(i).next]=true;//방문처리
				}
			}
			
			
			
		}
		
		return false;
		
		
	}

}
class v{
	int next,w;

	public v(int next, int w) {
		super();
		this.next=next;
		this.w = w;
	}
	
}
