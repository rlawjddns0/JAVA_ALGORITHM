package BAEK.month_202112.day_20211228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_6593 {
	static int L,R,C;
	static char[][][] building;
	static boolean[][][] visit;
	static int sh,sy,sx;
	public static void main(String[] args) throws IOException {
		StringBuffer sb=new StringBuffer();
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			if(!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
			
			L=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			if(L==0 && R==0 && C==0)break;
			building=new char[L][R][C];
			visit=new boolean[L][R][C];
			int answer=-1;
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					String str=br.readLine();
					for(int k=0; k<C; k++) {
						building[i][j][k]=str.charAt(k);
						if(building[i][j][k]=='S') {
							sh=i;
							sy=j;
							sx=k;
						}
					}
				}
				br.readLine();

			}
			
			answer=solution();
			if(answer==0) {
				System.out.println("Trapped!");
			}
			  
			
		}
		System.out.println(sb);
		
		
		
		
		
	}
	private static int solution() {
		int[] dh= {-1,1};
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		
		visit[sh][sy][sx]=true;
		Queue<pos> q=new LinkedList<>();
		q.offer(new pos(sh,sy,sx,0));
		
		while(!q.isEmpty()) {
			
			pos cur=q.poll();
			
			int curh=cur.h;// 현재 있는 층
			int cury=cur.y;// 현재 y
			int curx=cur.x;// 현재 x
			int minute=cur.minute;
			if(building[curh][cury][curx]=='E') {
				System.out.println("Escaped in "+minute+" minute(s).");
				return -1;
			}
			for(int h=0; h<2; h++) {
				int nh=curh+dh[h];
				if(nh<0 || nh>=L)continue;
				if(visit[nh][cury][curx])continue;
				if(building[nh][cury][curx]=='#')continue;
				q.offer(new pos(nh,cury,curx,cur.minute+1));
				visit[nh][cury][curx]=true;
			}
			
			for(int d=0; d<4; d++) {
				int ny=dy[d]+cury;
				int nx=dx[d]+curx;
				if(ny<0 || ny>=R || nx<0 || nx>=C)continue;
				if(visit[curh][ny][nx])continue;
				if(building[curh][ny][nx]=='#')continue;
				q.offer(new pos(curh,ny,nx,cur.minute+1));
				visit[curh][ny][nx]=true;
			}
		}
		
		
		return 0;
	}
	static class pos{
		int h,y,x,minute;

		public pos(int h, int y, int x,int minute) {
			super();
			this.h = h;
			this.y = y;
			this.x = x;
			this.minute=minute;
		}
		
	}
}

