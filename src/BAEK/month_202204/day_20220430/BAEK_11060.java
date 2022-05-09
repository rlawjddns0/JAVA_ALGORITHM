package BAEK.month_202204.day_20220430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_11060 {
	public static void main(String[] args) throws IOException {
		int N=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());		
			
				
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int[] map=new int[N];
		boolean[] visit=new boolean[N];
		for(int i=0; i<N; i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		
		Queue<pos> q=new LinkedList<>();
		q.offer(new pos(0,map[0],0));
		visit[0]=true;
		
		while(!q.isEmpty()) {
			pos cur=q.poll();
			
			if(cur.idx==N-1) {
				System.out.println(cur.cnt);
				System.exit(0);
			}
			
			for(int w=1; w<=cur.width; w++) {
				int nx=cur.idx+w;
				if(nx>=N)break;
				if(visit[nx])continue;
				q.offer(new pos(nx,map[nx],cur.cnt+1));
				visit[nx]=true;
			}
			
		}
		
		System.out.println("-1");
		
		
		
		
		
		
	}
	static class pos{
		int idx,width,cnt;

		public pos(int idx, int width, int cnt) {
			super();
			this.idx = idx;
			this.width = width;
			this.cnt = cnt;
		}
		
	}

}
