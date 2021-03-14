//package BAEK.month_202103.day_20210313;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BAEK_13460 {
//	static int N, M;
//	static char[][] map;
//	static char[][] tmp;
//	static boolean[][] visit;
//	static int[] dx = { 1, 0, -1, 0 };
//	static int[] dy = { 0, 1, 0, -1 };
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("./src/input/±∏ΩΩ≈ª√‚2.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		map = new char[N][M];
//		for (int i = 0; i < N; i++) {
//			map[i] = br.readLine().toCharArray();
//		}
//
//		bfs();
//
//	}
//
//	private static void bfs() {
//
//		Queue<loc> q = new LinkedList<>();
//
//		for (int i = 0; i < N; i++) {
//			for(int j=0; j<M;j++) {
//				if(map[i][j]=='R'||map[i][j]=='B') {
//					q.offer(new loc(j,i,map[i][j]));
//				}
//			}
//		}
//
//		for(int i=0; i<q.size(); i++) {
//			int x=q.peek().x;
//			int y=q.peek().y;
//			char color=q.peek().color;
//			q.offer(q.poll());
//			
//			for(int d=0; d<4; d++) {
//				int nx=0;
//				int ny=0;
//				while(true) {
//					nx=x+dx[d];
//					ny=y+dy[d];
//					if(map[])
//					
//					
//					
//				}
//			}
//			
//			
//			
//			
//			
//			
//		}
//
//	}
//
//	public static void print() {
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//	}
//
//}
//
//class loc {
//	int x, y;
//	char color;
//	loc(int x, int y,char color) {
//		this.x = x;
//		this.y = y;
//		this.color=color;
//	}
//}
