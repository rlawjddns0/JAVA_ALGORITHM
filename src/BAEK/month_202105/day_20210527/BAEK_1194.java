package BAEK.month_202105.day_20210527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_1194 {
	static int N,M;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int starty,startx;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new char[N][M];
		visit=new boolean[N][M][64];
		
		for(int i=0; i<N; i++) {
			char[] tmp=br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(tmp[j]=='0') {
					startx=j;
					starty=i;
				}
				map[i][j]=tmp[j];
			}
		}
		bfs(startx,starty,key);
		
		
	
	}
	private static void bfs(int x, int y, int key) {

		Queue<user> q=new LinkedList<>();
		q.offer(new user(y,x,key,0));
		visit[y][x][key]=true;
		while(!q.isEmpty()) {
			user tmp=q.poll();
			int cy=tmp.y;
			int cx=tmp.x;
			int ckey=tmp.key;
			int ccnt=tmp.cnt;
			if(map[cy][cx]=='1') {
				System.out.println(ccnt);
				return;
			}
			for(int d=0; d<4; d++) {
				int nx=cx+dx[d];
				int ny=cy+dy[d];
				if(nx>=M || nx<0 || ny>=N || ny<0 || visit[ny][nx][ckey])continue;
				if(map[ny][nx]=='#')continue;
				if(map[ny][nx]>='a' && map[ny][nx]<='z') {
					int tmpkey=ckey |(1<<(map[ny][nx]-'a'));
					if(!visit[ny][nx][tmpkey]) {
						visit[ny][nx][tmpkey]=true;
						visit[cy][cx][ckey]=true;
						q.offer(new user(ny,nx,tmpkey,ccnt+1));
					}
					
				}
				else if(map[ny][nx]>='A' && map[ny][nx]<='Z') {
					int check=(1 << (map[ny][nx] - 'A')) & ckey;
					
					if(check>0) {
						visit[ny][nx][ckey]=true;
						q.offer(new user(ny,nx,ckey,ccnt+1));
					}
				}
				else {
					visit[ny][nx][ckey]=true;
					q.offer(new user(ny,nx,ckey,ccnt+1));
				}
			}
		}
		
		
		System.out.println("-1");
		
		
	}
	static int key;
	
	static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

}
class user{
	int y,x,key,cnt;

	public user(int y, int x, int key,int cnt) {
		super();
		this.y = y;
		this.x = x;
		this.cnt=cnt;
		this.key = key;
	}

	@Override
	public String toString() {
		return "user [y=" + y + ", x=" + x + ", key=" + key + "]";
	}
	
}
