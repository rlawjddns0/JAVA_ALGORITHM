package BAEK.month_202107.day_20210720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 
 * 처음에는 2차원 배열로 불을 관리하였지만
 * 시간초과가 났다. 그래서 다른 방법으로는 어레이 리스트로 불의 좌표를 다 저장한다음
 * 한번에 불을 관리해줬다. 그래도 시간초과가 났다 그래서 다른 사람의 코드를 참조하여 q를 사용했더니 됐다;;
 * 
 */
public class BAEK_5427 {
	static int TEST, w, h;
	static char[][] map;
	static char[][] fire;
	static boolean[][] fire_visit;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int sang_y, sang_x;
	static ArrayList<fire> f;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TEST = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TEST; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			f = new ArrayList<>();
			for (int i = 0; i < h; i++) {
				char[] tmp = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					map[i][j] = tmp[j];
					if (map[i][j] == '@') {
						sang_y = i;
						sang_x = j;
					}
					if (map[i][j] == '*') {
						f.add(new fire(i, j));
					}
				}
			}

//			fire_print();
//			System.out.println();
//			map_print();
//			System.out.println();

			bfs();

		}

	}

	private static void bfs() {

		boolean[][] visit = new boolean[h][w];
		visit[sang_y][sang_x] = true;
		Queue<pos> q = new LinkedList<pos>();
		q.offer(new pos(sang_y, sang_x, 0));
		Queue<fire> fq=new LinkedList<>();
		for(int i=0; i<f.size(); i++) {
			fq.add(f.get(i));
		}
		
		
		
		while (!q.isEmpty()) {
			
			
			//불 부터 옮긴다.
			int flameSize=fq.size();
			for(int i=0; i<flameSize; i++) {
				
				fire tmp=fq.poll();
				
				for(int d=0; d<4; d++) {
					int ny=tmp.y+dy[d];
					int nx=tmp.x+dx[d];
					if (ny >= h || ny < 0 || nx >= w || nx < 0)
						continue;
					if(map[ny][nx]=='.') {
						map[ny][nx]='*';
						fq.add(new fire(ny,nx));
					}
				}
				
				
				
				
				
			}
			
			
			//일단 q에 들어오는 모든 경우를 한번에 다 돌려야 한다. 그래서 size를 따로 변수에 저장하였다.
			int curSize = q.size();
			for (int k = 0; k < curSize; k++) {

				pos now = q.poll();

				if (now.y == h - 1 || now.y == 0 || now.x == 0 || now.x == w - 1) {//경계선이면 무저건 탈출 가능
					System.out.println(now.t + 1);
					return;
				}

				for (int d = 0; d < 4; d++) {
					int ny = now.y + dy[d];
					int nx = now.x + dx[d];
					if (ny >= h || ny < 0 || nx >= w || nx < 0)
						continue;
					if (map[ny][nx] == '#')
						continue;
					if (map[ny][nx] == '*')
						continue;
					if (visit[ny][nx])
						continue;
					q.offer(new pos(ny, nx, now.t + 1));
					visit[ny][nx] = true;
				}

			}
//			fire_print();
//			System.out.println();
//			map_print();
//			System.out.println();

		}
		System.out.println("IMPOSSIBLE");
		return;
	}

	private static void fire_print() {
		for (int i = 0; i < h; i++) {
			System.out.println(Arrays.toString(fire[i]));
		}
	}

	private static void map_print() {
		for (int i = 0; i < h; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	
}

class pos {
	int y, x, t;

	public pos(int y, int x, int t) {
		super();
		this.y = y;
		this.x = x;
		this.t = t;
	}

}

class fire {
	int y, x;

	public fire(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

}
