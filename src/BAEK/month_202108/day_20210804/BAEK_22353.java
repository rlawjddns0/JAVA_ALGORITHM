package BAEK.month_202108.day_20210804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_22353 {
	static int N,M;
	static int[][] before_map;
	static int[][] after_map;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		before_map=new int[N][M];
		after_map=new int[N][M];
		visit=new boolean[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				before_map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				after_map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				if(after_map[i][j]!=before_map[i][j] && !visit[i][j]) {//���ϴٰ� ���� ���� �湮���� �ʾҰ� ���� �񱳸� �������� ��
					if(cnt>0) {//�ٵ� ���࿡ �񱳸� 1�� �̻� ������ ���ü� ���� �����
						System.out.println("NO");
						return;
					}
					cnt++;//�� Ƚ��
					bfs(i,j);
				}
			}
		}
		
		
		System.out.println("YES");
		
		
		
		
		
		
		
		
	}

	private static void bfs(int i, int j) {
		int beforeNum=before_map[i][j];
		int afterNum=after_map[i][j];
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		Queue<pos> q=new LinkedList<pos>();
		q.offer(new pos(i,j,beforeNum));
		before_map[i][j]=afterNum;
		visit[i][j]=true;
		ArrayList<pos> list=new ArrayList<>();
		
		
		while(!q.isEmpty()) {
			pos cur=q.poll();
			
			for(int d=0; d<4; d++) {
				int ny=cur.y+dy[d];
				int nx=cur.x+dx[d];
				if(ny>=N || ny<0 || nx>=M || nx<0 || visit[ny][nx])continue;
				if(before_map[ny][nx]!=cur.num)continue;//���� �ٸ� ���ڸ� �н�
				if(after_map[ny][nx]!=afterNum) {//���� ���ǿ��� ���ϱ��� �ʿ����� ���ڰ� ���ٰ� �ߴµ� ���� �� �ʿ����� ���ڰ� �ٸ�-> ���ü� ���� ���
					System.out.println("NO");//NO ��� �ٷ� ����
					System.exit(1);
				}
				visit[ny][nx]=true;
				list.add(new pos(ny,nx,afterNum));
				q.offer(new pos(ny,nx,beforeNum));
			}
			
		}
		for (pos pos : list) {//��� �ɵ�
			before_map[pos.y][pos.x]=pos.num;
		}
		
//		print();
	}
	public static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(before_map[i]));
		}
	}

}
class pos{
	int y,x;
	int num;
	public pos(int y, int x, int num) {
		super();
		this.y = y;
		this.x = x;
		this.num=num;
	}

	
}
