package BAEK.month_202107.day_20210720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_5427 {
	static int TEST,w,h;
	static char[][] map;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int sang_y,sang_x;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		TEST=Integer.parseInt(br.readLine());
		for(int t=1; t<=TEST; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			map=new char[h][w];
			
			for(int i=0; i<h; i++) {
				char[] tmp=br.readLine().toCharArray();
				for(int j=0; j<w; j++) {
					map[i][j]=tmp[j];
					if(map[i][j]=='@') {
						sang_y=i;
						sang_x=j;
					}
				}
			}
			
			bfs();
			
			
			
			
			
			
		}
		
		
	}
	private static void bfs() {
		
		boolean[][] visit=new boolean[h][w];
		visit[sang_y][sang_x]=true;
		Queue<pos> q=new LinkedList<pos>();
		q.offer(new pos(sang_y,sang_x,0));
		
		while(!q.isEmpty()) {
			pos now=q.poll();
			
			if(now.y==)
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
class pos{
	int y,x,t;

	public pos(int y, int x,int t) {
		super();
		this.y = y;
		this.x = x;
		this.t=t;
	}
	
}
