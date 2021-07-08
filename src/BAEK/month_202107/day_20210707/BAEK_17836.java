package BAEK.month_202107.day_20210707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_17836 {
	static int N, M, T;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1;  j<=M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int ans=bfs();
		if(ans==-1 || ans>T) {
			System.out.println("Fail");
		}else {
			System.out.println(ans);
		}
		
		
	}

	private static int bfs() {
		
		boolean[][][] visit=new boolean[2][N+1][M+1];//���� �ִ°�� 1, ���� ���°�� 0
		Queue<user> q=new LinkedList<user>();
		q.offer(new user(1,1,0,0));//(1,1)���� �����Ͽ� time=0, ���� ����.
		visit[0][1][1]=true;//���� �ִ� ���� ���� ��츦 ������
		
		while(!q.isEmpty()) {
			user cur=q.poll();
			
			
			if(cur.y==N && cur.x==M) {//��ǥ�� �����ϸ�
				return cur.time;//�ð� ����
			}
			
			for(int d=0; d<4; d++) {
				int ny=cur.y+dy[d];
				int nx=cur.x+dx[d];
				if(ny<1 || ny>N || nx<1 || nx>M || visit[cur.sord][ny][nx])continue;//������ ����� �湮������ ��Ƽ��~
				
				if(cur.sord==1) {//���� ������ �ִ� ���
					q.offer(new user(ny,nx,cur.time+1,1));
					visit[cur.sord][ny][nx]=true;//�湮 üũ
				}else {//���� ���
					if(map[ny][nx]==0) {//���� ĭ�� 0�̸� �׳� �� �� �ִ�
						q.offer(new user(ny,nx,cur.time+1,0));
						visit[cur.sord][ny][nx]=true;
					}
					else if(map[ny][nx]==2) {//���� �Դ´�
						q.offer(new user(ny,nx,cur.time+1,1));
						visit[cur.sord][ny][nx]=true;
					}else if(map[ny][nx]==1) {//������.
						continue;
					}
				}
				
				
			}
			
			
			
			
			
		}
		
		return -1;
		
		
		
		
		
		
	}

}

class user {
	int y, x;
	int time;
	int sord;
	public user(int y, int x, int time, int sord) {
		super();
		this.y = y;
		this.x = x;
		this.time = time;
		this.sord = sord;
	}
	@Override
	public String toString() {
		return "user [y=" + y + ", x=" + x + ", time=" + time + ", sord=" + sord + "]";
	}

}