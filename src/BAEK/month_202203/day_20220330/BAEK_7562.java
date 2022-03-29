package BAEK.month_2022023.day_20220329;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_7562 {
	static int T;
	static int l;
	static boolean[][] map;
	static pos from;
	static pos to;
	static int[] dx= {1,2,2,1,-1,-2,-2,-1};
	static int[] dy= {-2,-1,1,2,2,1,-1,-2};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<T; t++) {
			l=Integer.parseInt(br.readLine());
			map=new boolean[l][l];
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			from=new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st=new StringTokenizer(br.readLine()," ");
			to=new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			map[from.y][from.x]=true;
			Queue<ches> q=new LinkedList<ches>();
			
			q.offer(new ches(from.y,from.x,0));
			
			
			while(!q.isEmpty()) {
				ches cur=q.poll();
//				System.out.println(cur.toString());
				if(cur.y==to.y && cur.x==to.x) {
					System.out.println(cur.cnt);
					break;
				}
				
				
				for(int d=0; d<8; d++) {
					int ny=cur.y+dy[d];
					int nx=cur.x+dx[d];
					if(ny>=l || ny<0 || nx>=l || nx<0)continue;
					if(map[ny][nx])continue;
					q.offer(new ches(ny,nx,cur.cnt+1));
					map[ny][nx]=true;
				}
				
				
				
				
				
			}
			
			
		}		
		
		
		
	}
	
	static class ches{
		int y,x,cnt;

		public ches(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "ches [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}
		
		
		
	}
	
	static class pos{
		int y,x;

		public pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
}
