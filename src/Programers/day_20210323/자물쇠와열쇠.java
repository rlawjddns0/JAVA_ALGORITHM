package Programers.day_20210323;

import java.util.Arrays;
import java.util.Scanner;

public class 자물쇠와열쇠 {
	// static int M,N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] key;
		int[][] lock;

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		lock = new int[N][N];
		key = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				key[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				lock[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(solution(key, lock));
		//print();
	}

	static int[][] map;
	static int[][] tMap;
	static int[][] tKey;
	static int[][] tLock;
	private static boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		int M = key.length;//그냥 파라미터로 넘기기 귀찮아서 해줌
		int N = lock.length;
		tKey=new int[M][M];
		tLock=new int[N][N];
		for(int i=0; i<M; i++) {
			tKey[i]=key[i].clone();
		}
		for(int i=0; i<N; i++) {
			tLock[i]=lock[i].clone();
		}
		map = new int[2 * M + N - 2][2 * M + N - 2];//열쇠와 키 크기 생각해서 맵 만들어줌
		
		init(M,N,lock);//자물쇠를 맵에다가 집어넣기
		L: for (int i = 0; i < map.length-M; i++) {
			for (int j = 0; j < map.length-M; j++) {
				init(M,N,lock);
				if (insert(i, j, M, N)) {//(i,J).에 열쇠 집어 널기 
					answer = true;
					break L;
				}
			}
		}

		return answer;
	}
	private static void init(int M ,int N, int[][] lock) {//맵 초기화 맵에다가 다시 자물쇠를 넣어준다
		
		//System.out.println();
		map = new int[2 * M + N - 2][2 * M + N - 2];
		for (int i = M - 1, a = 0; a < N; i++, a++) {
			for (int j = M - 1, b = 0; b < N; j++, b++) {
				map[i][j] = lock[a][b];
			
			}
		}
	}
	private static boolean insert(int y, int x, int M, int N) {//y,x는 키 넣을 시작 좌표

		for (int i = 0; i < 4; i++) {//집어널고 90도로 4번 회전 시키면서 만약 잘 들어갔으면 트루
			rotate(y, x);
			if (check( M, N)) {
				return true;
			}
		}
		
		return false;

	}

	private static void rotate(int y, int x) {
		int M = tKey.length;
		int N=  tLock.length;
		int[][] tmp = new int[M][M];

		for (int j = 0; j < M; j++) {//90도 회전
			int[] tp=new int[M];
			for (int i = M - 1,a=0; i >= 0;a++, i--) {
				tp[a]=tKey[i][j];
			}
			for(int i=0; i<M; i++) {
				tmp[j][i]=tp[i];
			}
		}
		for(int i=0; i<tmp.length; i++) {//회전한키로 업데이트
			tKey[i]=tmp[i].clone();
		}
		
		init(M,N,tLock);//회전한거 넣기전에 맵 초기화
		for (int i = y, a = 0; i < y + M; a++, i++) {// key 넣기
			
			for (int j = x, b = 0; j < x + M; b++, j++) {
				map[i][j] = map[i][j] ^ tKey[a][b];//넣으면서 돌기 끼리 만나는 (1,1), (0,0) 을 0으로 만든다.
			}
		}
		print();
		System.out.println();
		
		

	}
	//M :키 길이 N: 자물쇠 길이
	private static boolean check(int M, int N) {

		int count = 0;
		for (int i = M - 1; i <(M-1)+ N; i++) {//자물쇠만큼 돌면서 1인거 확인
			for (int j = M - 1; j <(M-1)+ N; j++) {
				if (map[i][j] == 1)
					count++;
			}
		}
		//System.out.println("coutn:  "+count);
		if (count == N * N)//만약 자물쇠만큼 있으면 
			return true;//참
		else
			return false;

	}

	public static void print() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
