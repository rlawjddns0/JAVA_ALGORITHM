package BAEK.month_202102.day_20210228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2636 {
	static int R, C;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Queue<loc> edge = new LinkedList<loc>();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {//입력
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time=0;
		int cnt=0;//다 녹기 전 치즈 수
		
		while (true) {
//			L:for(int i=0; i<R; i++) {//외부 공기 구하기
//				for(int j=0; j<C; j++) {
//					if(map[i][j]==0) {
//						bfs(i,j);//0인 곳 찾으면 bfs로 외부 공기 탐색
//						break L;
//					}
//				}
//			}
			
			/*
			 * 
9 12
0 0 0 0 0 0 0 0 0 0 0 0
0 1 1 1 1 1 1 1 1 1 1 0
0 1 1 1 1 1 1 1 1 1 1 0
0 1 1 0 0 0 0 0 0 1 1 0
0 1 1 1 1 1 1 1 1 1 1 0
0 1 1 0 0 0 0 0 0 1 1 0 
0 1 1 1 1 1 1 1 1 1 1 0 
0 1 1 1 1 1 1 1 1 1 1 0
0 0 0 0 0 0 0 0 0 0 0 0
->기존에 0인 부분만 찾아서 외부 공기 인지 아닌지 탐색하면

[4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4]
[4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4]
[4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4]
[4, 4, 1, 4, 4, 4, 4, 4, 4, 1, 4, 4]
[4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4]
[4, 4, 1, 0, 0, 0, 0, 0, 0, 1, 4, 4]
[4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4]
[4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4]
[4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4]
->처음 제일 외부에 치즈를 찾아서 외부 공기로 바꾸고 다시 0인 부분을 찾기때문에 만약 치즈 내부에 0이 있으면 그걸 외부공기로 바꿔버려서 실패.. 
			 * 
			 * 
			 */
			bfs(0,0);//그래서 무조건 바깥부분? 인 0,0부터 하는게 맞는듯? 
			
			boolean flag=true;//녹을 치즈가 있는지 없는지 확인
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					 if (map[i][j] == 1) {
						if (check(i, j)) {//외부 공기와 접촉해 있는지 없는지 확인
							flag=false;//녹을 치즈 있음
							edge.offer(new loc(j, i));//공기와 닿아 있는 치즈들 q에 넣어주기
						}
					}
				}
			}
			
			if(flag)break;//만약 녹을 치즈가 없으면 다 녹은거 -> 반복문 나가기
			cnt=edge.size();// 현재 녹을 치즈의 수 
			while (!edge.isEmpty()) {//edge(공기와 닿아 있는 치즈 큐)가 없을때까지
				map[edge.peek().y][edge.peek().x] = 4;//그 치즈들을 외부 공기로 바꿔준다
				edge.poll();
			}
			
			time++;
		}
		System.out.println(time+"\n"+cnt);

	}

	public static boolean check(int i, int j) {

		for (int d = 0; d < 4; d++) {
			int nx = j + dx[d];
			int ny = i + dy[d];
			if (nx >= 0 && nx < C && ny >= 0 && ny < R && map[ny][nx] == 4) {//사방탐색중 한 칸이라도 외부공기 (4)와 닿아 있으면 true를 리턴
				return true;
			}
		}
		return false;

	}

	public static void bfs(int y,int x) {

		visit = new boolean[R][C];

		visit[y][x] = true;
		map[y][x] = 4;// 외부 공기
		Queue<loc> q = new LinkedList<loc>();
		q.offer(new loc(x, y));

		while (!q.isEmpty()) {
			int j = q.peek().x;
			int i = q.peek().y;
			q.poll();

			for (int d = 0; d < 4; d++) {//사방 탐색 하면서 외부공기 계속 찾기
				int nx = j + dx[d];
				int ny = i + dy[d];

				if (nx >= 0 && nx < C && ny >= 0 && ny < R && map[ny][nx] != 1 && !visit[ny][nx]) {// 현재 찾은곳이 치즈가 아니면서 방문하지 않았다면 외부공기 
					map[ny][nx] = 4;//외부공기로 바꾸고
					visit[ny][nx] = true;
					q.offer(new loc(nx, ny));
				}
			}
		}

	}

	public static void print() {
		for (int i = 0; i < R; i++) {
			System.out.println(Arrays.toString(map[i]));
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
