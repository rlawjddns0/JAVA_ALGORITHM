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
				
				if(after_map[i][j]!=before_map[i][j] && !visit[i][j]) {//비교하다가 서로 아직 방문하지 않았고 서로 비교를 안했으면 비교
					if(cnt>0) {//근데 만약에 비교를 1번 이상 했으면 나올수 없는 경우임
						System.out.println("NO");
						return;
					}
					cnt++;//비교 횟수
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
				if(before_map[ny][nx]!=cur.num)continue;//서로 다른 숫자면 패스
				if(after_map[ny][nx]!=afterNum) {//위에 조건에서 변하기전 맵에서의 숫자가 같다고 했는데 변한 후 맵에서는 숫자가 다름-> 나올수 없는 경우
					System.out.println("NO");//NO 찍고 바로 종료
					System.exit(1);
				}
				visit[ny][nx]=true;
				list.add(new pos(ny,nx,afterNum));
				q.offer(new pos(ny,nx,beforeNum));
			}
			
		}
		for (pos pos : list) {//없어도 될듯
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
