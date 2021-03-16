package BAEK.month_202103.day_20210311;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_16235 {
	static int N, M, K;
	static int[][] A;
	static int[][] map;
	static LinkedList<tree> t;
	static Queue<tree> dead;
	static int[] dx = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("./src/input/��������ũ.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		t = new LinkedList<tree>();
		dead = new LinkedList<tree>();
		for (int i = 1; i < N + 1; i++) {
			Arrays.fill(map[i], 5);
		}
		// print();
		A = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			t.add(new tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), true));
		}


		while (K != 0) {
			// print();
			spring();
			summer();
			fall();
			winter();
			K--;
		}

		System.out.println(t.size());

	}

	private static void winter() {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				map[i][j] += A[i][j];
			}
		}
	}

	private static void fall() {
		
		ArrayList<tree> baby=new ArrayList<tree>();//�Ʊ⳪��
		for (tree tmp : t) {
			if (tmp.age % 5 == 0) {
				for (int d = 0; d < 8; d++) {
					int nx = tmp.x + dy[d];
					int ny = tmp.y + dx[d];
					if (nx >= 1 && nx < N + 1 && ny >= 1 && ny < N + 1) {//��濡 �Ʊ⳪�� �ɾ��ֱ�
						baby.add(new tree(nx, ny, 1, true));//�ϴ� �Ʊ⳪�� ��ǥ�� �־���
					}

				}
			}
		}
		t.addAll(0, baby);//�տ��ٰ� � ������ �ٿ��ָ� � �������� ����� �԰Եȴ�

	}

	private static void summer() {
		while(!dead.isEmpty()) {//���� ���� �� �������
			tree t=dead.poll();
			map[t.x][t.y]+=t.age/2;
		}
	}

	private static void spring() {//ó�� �Է��� ��ĭ�� ���� �ϳ�

		Iterator<tree> it=t.iterator();//���ͷ����ͷ��ϸ� �ӵ��� ������??
		while(it.hasNext()) {
			tree tmp=it.next();//������ �ϳ� �޾��ְ�
			int r=tmp.x;
			int c=tmp.y;
			int age=tmp.age;
			
			if(map[r][c]<age) {//����� ���̸�ŭ ������
				dead.offer(tmp);//�������� ��ũ�� ����Ʈ�� �־��ְ�
				it.remove();//�߰��� ���� ������ ��ũ�尡 ����
			}else {//������
				map[r][c]-=age;//���̸�ŭ ��� �԰�
				tmp.age++;//���� �ѻ� �߰�
			}
		}

	}

	public static void print() {
		for (int i = 0; i < N + 1; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(t.toString());
		System.out.println();
	}

}

class tree {
	int x, y, age;
	boolean alive;

	tree(int x, int y, int age, boolean alive) {
		this.x = x;
		this.y = y;
		this.age = age;
		this.alive = alive;

	}

	

	@Override
	public String toString() {
		return "tree [x=" + x + ", y=" + y + ", age=" + age + "]";
	}

}