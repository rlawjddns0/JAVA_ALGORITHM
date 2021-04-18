package BAEK.month_202104.day_20210416;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;
/*
 * 
 * 다시 풀어보기
 */
public class BAEK_1194 {
	static int N, M;
	static char[][] map;
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new boolean[65][N][M];
		int y = 0, x = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					y = i;
					x = j;
				}
			}
		}

		System.out.println(bfs(y, x));

	}

	private static int bfs(int i, int j) {

		Queue<minsik> q = new LinkedList<>();
		//ArrayList<Character> key= new ArrayList<>();
		
		q.offer(new minsik(i, j, 0, 0));

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		while (!q.isEmpty()) {
			minsik tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int ckey = tmp.key;
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N || map[ny][nx] == '#'||visit[ckey][ny][nx])
					continue;
				if (map[ny][nx] == '1') {
					return tmp.cnt + 1;
				}
				if (Character.isLowerCase(map[ny][nx])) {//소문자이면 ->key
					int nkey=ckey|(1<<map[ny][nx]-'a');
					visit[nkey][ny][nx] = true;
					q.offer(new minsik(ny, nx, tmp.cnt + 1, nkey));

				}
				if (Character.isUpperCase(map[ny][nx])) {//대문자이면 문
					int nkey=ckey&(1<<(map[ny][nx]-'A'));// 대문자의 정수를 구해서 그만큼 시프트 연산 후 현재 키와 and 연산
					int doorKey=1<<(map[ny][nx]-'A');//문을 시프트 연산
					if(nkey==doorKey) {//둘이 같으면 문이 열리네요~
						visit[ckey][ny][nx]=true;//한번 갔으니께 방문
						q.offer(new minsik(ny,nx,tmp.cnt+1,ckey));
					}
				}
				if (map[ny][nx] == '.') {// 그냥 가~
					q.offer(new minsik(ny, nx, tmp.cnt + 1, ckey));
					visit[ckey][ny][nx] = true;
				}
				if (map[ny][nx] == '0') {//그냥 가~
					q.offer(new minsik(ny, nx, tmp.cnt + 1, ckey));
					visit[ckey][ny][nx] = true;
				}
			}

		}

		return -1;

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
}

class minsik {
	int y, x, cnt, key;

	public minsik(int y, int x, int cnt, int key) {
		super();
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.key = key;
	}

	@Override
	public String toString() {
		return "minsik [y=" + y + ", x=" + x + ", key=" + key + "]";
	}

}

class Point {
	int y, x;

	@Override
	public String toString() {
		return "pos [y=" + y + ", x=" + x + "]";
	}

	public Point(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

}