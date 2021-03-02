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
		for (int i = 0; i < R; i++) {//�Է�
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time=0;
		int cnt=0;//�� ��� �� ġ�� ��
		
		while (true) {
//			L:for(int i=0; i<R; i++) {//�ܺ� ���� ���ϱ�
//				for(int j=0; j<C; j++) {
//					if(map[i][j]==0) {
//						bfs(i,j);//0�� �� ã���� bfs�� �ܺ� ���� Ž��
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
->������ 0�� �κи� ã�Ƽ� �ܺ� ���� ���� �ƴ��� Ž���ϸ�

[4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4]
[4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4]
[4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4]
[4, 4, 1, 4, 4, 4, 4, 4, 4, 1, 4, 4]
[4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4]
[4, 4, 1, 0, 0, 0, 0, 0, 0, 1, 4, 4]
[4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4]
[4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4]
[4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4]
->ó�� ���� �ܺο� ġ� ã�Ƽ� �ܺ� ����� �ٲٰ� �ٽ� 0�� �κ��� ã�⶧���� ���� ġ�� ���ο� 0�� ������ �װ� �ܺΰ���� �ٲ������ ����.. 
			 * 
			 * 
			 */
			bfs(0,0);//�׷��� ������ �ٱ��κ�? �� 0,0���� �ϴ°� �´µ�? 
			
			boolean flag=true;//���� ġ� �ִ��� ������ Ȯ��
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					 if (map[i][j] == 1) {
						if (check(i, j)) {//�ܺ� ����� ������ �ִ��� ������ Ȯ��
							flag=false;//���� ġ�� ����
							edge.offer(new loc(j, i));//����� ��� �ִ� ġ��� q�� �־��ֱ�
						}
					}
				}
			}
			
			if(flag)break;//���� ���� ġ� ������ �� ������ -> �ݺ��� ������
			cnt=edge.size();// ���� ���� ġ���� �� 
			while (!edge.isEmpty()) {//edge(����� ��� �ִ� ġ�� ť)�� ����������
				map[edge.peek().y][edge.peek().x] = 4;//�� ġ����� �ܺ� ����� �ٲ��ش�
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
			if (nx >= 0 && nx < C && ny >= 0 && ny < R && map[ny][nx] == 4) {//���Ž���� �� ĭ�̶� �ܺΰ��� (4)�� ��� ������ true�� ����
				return true;
			}
		}
		return false;

	}

	public static void bfs(int y,int x) {

		visit = new boolean[R][C];

		visit[y][x] = true;
		map[y][x] = 4;// �ܺ� ����
		Queue<loc> q = new LinkedList<loc>();
		q.offer(new loc(x, y));

		while (!q.isEmpty()) {
			int j = q.peek().x;
			int i = q.peek().y;
			q.poll();

			for (int d = 0; d < 4; d++) {//��� Ž�� �ϸ鼭 �ܺΰ��� ��� ã��
				int nx = j + dx[d];
				int ny = i + dy[d];

				if (nx >= 0 && nx < C && ny >= 0 && ny < R && map[ny][nx] != 1 && !visit[ny][nx]) {// ���� ã������ ġ� �ƴϸ鼭 �湮���� �ʾҴٸ� �ܺΰ��� 
					map[ny][nx] = 4;//�ܺΰ���� �ٲٰ�
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
