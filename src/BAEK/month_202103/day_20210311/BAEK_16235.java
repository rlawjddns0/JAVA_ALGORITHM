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
		System.setIn(new FileInputStream("./src/input/나무재태크.txt"));
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
		
		ArrayList<tree> baby=new ArrayList<tree>();
		for (tree tmp : t) {
			if (tmp.age % 5 == 0) {
				for (int d = 0; d < 8; d++) {
					int nx = tmp.x + dy[d];
					int ny = tmp.y + dx[d];
					if (nx >= 1 && nx < N + 1 && ny >= 1 && ny < N + 1) {
						baby.add(new tree(nx, ny, 1, true));
					}

				}
			}
		}
		t.addAll(0, baby);

	}

	private static void summer() {
		while(!dead.isEmpty()) {
			tree t=dead.poll();
			map[t.x][t.y]+=t.age/2;
		}
	}

	private static void spring() {

		Iterator<tree> it=t.iterator();
		while(it.hasNext()) {
			tree tmp=it.next();
			int r=tmp.x;
			int c=tmp.y;
			int age=tmp.age;
			
			if(map[r][c]<age) {
				dead.offer(tmp);
				it.remove();
			}else {
				map[r][c]-=age;
				tmp.age++;
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

class tree implements Comparable<tree> {
	int x, y, age;
	boolean alive;

	tree(int x, int y, int age, boolean alive) {
		this.x = x;
		this.y = y;
		this.age = age;
		this.alive = alive;

	}

	@Override
	public int compareTo(tree o) {
		if (this.x == o.x && this.y == o.y) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "tree [x=" + x + ", y=" + y + ", age=" + age + "]";
	}

}