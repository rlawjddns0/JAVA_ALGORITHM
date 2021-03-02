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
			tmp=new int[H][W];//�ʱ�ȭ�� �ʿ�
			ans=Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					tmp[i][j]=map[i][j];
				}
			}
			solve(new int[N], 0, 0);//N���� �ߺ� ��� �ϴ� ���� ����
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
	private static void init() {//map �ʱ�ȭ
		for(int i=0; i<H; i++) {
			map[i]=tmp[i].clone();
		}
	}
	private static void solve(int[] sel, int k, int idx) {
		// TODO Auto-generated method stub
		if (k == N) {//N���� �� �������
			init();//�ʱ�ȭ ���ְ�
			count = 0;//�ʱ�ȭ
			crash(sel);//������ �� �μ���
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
				if (map[j][sel[i]] > 0) {//������ ���� �� ���������� �������� 0���� ū ���� ������
					//��ǥ�� �����ϰ�
					int x = sel[i];
					int y = j;
					if(map[y][x]==1) {//�ٵ� �μ� ������ 1�̸� �װ͸� �μ��� break
						map[y][x]=0;
						break;
					}
					bfs(y, x);//1 �̻��̸� �ν� �� �ִ� ���� Ž��
					break;
				}
			}
			gravity();
			
		}
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]!=0) {
					count++;//�����Ѱ� �� �μ��� ���� ���� ���� ī��Ʈ
				}
			}
		}

	}
	private static void gravity() {//�߷� ����
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
			int tmp = map[y1][x1];//���� ������ ����
			tmp--;//1�� ���ְ�
			map[y1][x1]=0;//������ ���� 0����
			for (int cnt = 1; cnt <= tmp; cnt++) {//���� ���� �̿��ؼ� ��� ���ϸ鼭 
				for (int d = 0; d < 4; d++) {
					int nx = x1 + dx[d] * cnt;
					int ny = y1 + dy[d] * cnt;
					if (nx >= 0 && nx < W && ny >= 0 && ny < H && !visit[ny][nx]) {
						if(map[ny][nx]==1) {//Ž���� ������ 1�̸� q�� �ȳְ� 0����
							map[ny][nx]=0;
							visit[ny][nx]=true;
						}
						else if(map[ny][nx]>1) {//1 �̻��̸� q�� �ֱ�
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