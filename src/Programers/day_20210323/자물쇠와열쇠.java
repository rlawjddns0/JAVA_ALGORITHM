package Programers.day_20210323;

import java.util.Arrays;
import java.util.Scanner;

public class �ڹ���Ϳ��� {
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
		int M = key.length;//�׳� �Ķ���ͷ� �ѱ�� �����Ƽ� ����
		int N = lock.length;
		tKey=new int[M][M];
		tLock=new int[N][N];
		for(int i=0; i<M; i++) {
			tKey[i]=key[i].clone();
		}
		for(int i=0; i<N; i++) {
			tLock[i]=lock[i].clone();
		}
		map = new int[2 * M + N - 2][2 * M + N - 2];//����� Ű ũ�� �����ؼ� �� �������
		
		init(M,N,lock);//�ڹ��踦 �ʿ��ٰ� ����ֱ�
		L: for (int i = 0; i < map.length-M; i++) {
			for (int j = 0; j < map.length-M; j++) {
				init(M,N,lock);
				if (insert(i, j, M, N)) {//(i,J).�� ���� ���� �α� 
					answer = true;
					break L;
				}
			}
		}

		return answer;
	}
	private static void init(int M ,int N, int[][] lock) {//�� �ʱ�ȭ �ʿ��ٰ� �ٽ� �ڹ��踦 �־��ش�
		
		//System.out.println();
		map = new int[2 * M + N - 2][2 * M + N - 2];
		for (int i = M - 1, a = 0; a < N; i++, a++) {
			for (int j = M - 1, b = 0; b < N; j++, b++) {
				map[i][j] = lock[a][b];
			
			}
		}
	}
	private static boolean insert(int y, int x, int M, int N) {//y,x�� Ű ���� ���� ��ǥ

		for (int i = 0; i < 4; i++) {//����ΰ� 90���� 4�� ȸ�� ��Ű�鼭 ���� �� ������ Ʈ��
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

		for (int j = 0; j < M; j++) {//90�� ȸ��
			int[] tp=new int[M];
			for (int i = M - 1,a=0; i >= 0;a++, i--) {
				tp[a]=tKey[i][j];
			}
			for(int i=0; i<M; i++) {
				tmp[j][i]=tp[i];
			}
		}
		for(int i=0; i<tmp.length; i++) {//ȸ����Ű�� ������Ʈ
			tKey[i]=tmp[i].clone();
		}
		
		init(M,N,tLock);//ȸ���Ѱ� �ֱ����� �� �ʱ�ȭ
		for (int i = y, a = 0; i < y + M; a++, i++) {// key �ֱ�
			
			for (int j = x, b = 0; j < x + M; b++, j++) {
				map[i][j] = map[i][j] ^ tKey[a][b];//�����鼭 ���� ���� ������ (1,1), (0,0) �� 0���� �����.
			}
		}
		print();
		System.out.println();
		
		

	}
	//M :Ű ���� N: �ڹ��� ����
	private static boolean check(int M, int N) {

		int count = 0;
		for (int i = M - 1; i <(M-1)+ N; i++) {//�ڹ��踸ŭ ���鼭 1�ΰ� Ȯ��
			for (int j = M - 1; j <(M-1)+ N; j++) {
				if (map[i][j] == 1)
					count++;
			}
		}
		//System.out.println("coutn:  "+count);
		if (count == N * N)//���� �ڹ��踸ŭ ������ 
			return true;//��
		else
			return false;

	}

	public static void print() {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
