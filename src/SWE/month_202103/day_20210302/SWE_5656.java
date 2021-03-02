package SWE.month_202103.day_20210302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWE_5656 {
	static int[][] map,tmp;
	static int N, W, H;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			tmp=new int[H][W];//초기화시 필요
			ans=Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tmp[i][j]=map[i][j];
				}
			}
			solve(new int[N], 0, 0);//N개의 중복 허용 하는 조합 고르기
			System.out.println("#"+t+" "+ans);
			
		}
	}

	static int count;
	static int ans = Integer.MAX_VALUE;
	private static void print() {
		for(int i=0; i<H; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	private static void init() {//map 초기화
		for(int i=0; i<H; i++) {
			map[i]=tmp[i].clone();
		}
	}
	private static void solve(int[] sel, int k, int idx) {
		// TODO Auto-generated method stub
		if (k == N) {//N개의 행 골랐으면
			init();//초기화 해주고
			count = 0;//초기화
			crash(sel);//선택한 행 부수기
			ans = Math.min(ans, count);
			return;
		}

		for (int i = 0; i < W; i++) {
			sel[k] = i;
			solve(sel, k + 1, i);
		}

	}

	private static void crash(int[] sel) {
		for (int i = 0; i < sel.length; i++) {
			for (int j = 0; j < H; j++) {
				if (map[j][sel[i]] > 0) {//선택한 행의 맨 위에서부터 내려오다 0보다 큰 값이 있으면
					//좌표를 저장하고
					int x = sel[i];
					int y = j;
					if(map[y][x]==1) {//근데 부술 벽돌이 1이면 그것만 부수고 break
						map[y][x]=0;
						break;
					}
					bfs(y, x);//1 이상이면 부실 수 있는 벽돌 탐색
					break;
				}
			}
			gravity();
			
		}
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]!=0) {
					count++;//선택한거 다 부수고 남은 벽돌 갯수 카운트
				}
			}
		}

	}
	private static void gravity() {//중력 구현
		for(int j=0; j<W; j++) {
			for(int i=H-1; i>=0; i-- ) {
				if(map[i][j]!=0) {
					while(i+1<H && map[i+1][j]==0) {
						map[i+1][j]=map[i][j];
						map[i][j]=0;
						i++;
					}
				}
			
			}
			
		}
	}

	private static boolean[][] visit;

	private static void bfs(int y, int x) {

		visit = new boolean[H][W];

		Queue<loc> q = new LinkedList<loc>();
		q.offer(new loc(x, y));
		visit[y][x] = true;

		while (!q.isEmpty()) {
			int x1 = q.peek().x;
			int y1 = q.peek().y;
			q.poll();
			int tmp = map[y1][x1];//현재 벽돌의 숫자
			tmp--;//1개 빼주고
			map[y1][x1]=0;//선택한 벽돌 0으로
			for (int cnt = 1; cnt <= tmp; cnt++) {//벽돌 숫자 이용해서 계속 곱하면서 
				for (int d = 0; d < 4; d++) {
					int nx = x1 + dx[d] * cnt;
					int ny = y1 + dy[d] * cnt;
					if (nx >= 0 && nx < W && ny >= 0 && ny < H && !visit[ny][nx]) {
						if(map[ny][nx]==1) {//탐색시 벽돌이 1이면 q에 안넣고 0으로
							map[ny][nx]=0;
							visit[ny][nx]=true;
						}
						else if(map[ny][nx]>1) {//1 이상이면 q에 넣긴
							q.offer(new loc(nx,ny));
							visit[ny][nx]=true;
						}
					}
				}
			}

		}
	}

}

class loc {
	int x;
	int y;

	loc(int x, int y) {
		this.x = x;
		this.y = y;
	}
}