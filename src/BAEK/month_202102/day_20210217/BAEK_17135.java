package BAEK.month_202102.day_20210217;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class BAEK_17135 {
	static int N, M, D;
	static int[][] map;
	static int[][] temp;
	static int[] castle;
	static ArrayList<enemy> E = new ArrayList<enemy>();
	static ArrayList<enemy> TE = new ArrayList<enemy>();
	static ArrayList<mindist> minDist;
	static ArrayList<mindist> dieList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();

		map = new int[N][M];
		temp = new int[N][M];
		castle = new int[M];// 궁수가 있는 위치
		for (int i = 0; i < M; i++)
			castle[i] = i;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				temp[i][j] = map[i][j];
				if (temp[i][j] == 1) {
					E.add(new enemy(j, i));
					TE.add(new enemy(j, i));
				}
			}
		}
		solve(new int[3], 0, 0);

		System.out.println(ans);
	}

	static int die;
	static int ans = Integer.MIN_VALUE;

	private static void solve(int[] sel, int k, int idx) {
		// TODO Auto-generated method stub
		if (k == sel.length) {
			init();// 맵 재구성

			die = 0;
			for (int p = N; p >= 0; p--) {
				dieList = new ArrayList<mindist>();
				for (int i = 0; i < sel.length; i++) {
					minDist = new ArrayList<mindist>();
					int castleX = sel[i];// 궁수의 x좌표
					int castleY = p;// 궁수의 y좌표
					for (int j = 0; j < E.size(); j++) {
						int enemyX = E.get(j).x;// 적 x 좌표
						int enemyY = E.get(j).y;// 적 y좌표
						// if(map[enemyY][enemyX]==2)continue;
						if (enemyY >= p) {
							continue;
						} // 적이 이미 맵 벗어났거나 없으면 컨티뉴
						int dis = Math.abs(castleY - enemyY) + Math.abs(castleX - enemyX);// 거리계산
						if (dis <= D && map[enemyY][enemyX] != 2) {// 거리가 제한거리 이하이면
							minDist.add(new mindist(enemyX, enemyY, dis, j));

						}
					}
					if (minDist.size() != 0) {
						Collections.sort(minDist);
						dieList.add(minDist.get(0));
					}
				}

				for (int i = 0; i < dieList.size(); i++) {
					if (map[dieList.get(i).y][dieList.get(i).x] == 1) {
						map[dieList.get(i).y][dieList.get(i).x] = 2;
						die++;
					}
				}
				// moveEnemy();
				// System.out.println(E.toString());

			}
			ans = Math.max(die, ans);
			return;
		}

		for (int i = idx; i < castle.length; i++) {
			sel[k] = castle[i];
			solve(sel, k + 1, i + 1);
		}

	}

	public static void moveEnemy() {
//		for (int i = N - 1; i >= 1; i--) {
//			map[i] = map[i - 1].clone();
//		}
//		Arrays.fill(map[0], 0);
		for (int i = 0; i < E.size(); i++) {
			E.get(i).y = E.get(i).y + 1;
		}
	}

	public static void init() {
		for (int i = 0; i < N; i++) {
			map[i] = temp[i].clone();
		}
		E.clear();
		for (int i = 0; i < TE.size(); i++) {
			E.add(new enemy(TE.get(i).x, TE.get(i).y));

		}
	}

}

class mindist implements Comparable<mindist> {
	int dist;
	int x;
	int y;
	int idx;

	mindist(int x, int y, int dist, int idx) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.idx = idx;
	}

	@Override
	public int compareTo(mindist o) {
		// TODO Auto-generated method stub
		if (this.dist - o.dist == 0) {
			return this.x - o.x;
		}
		return this.dist - o.dist;
	}

	@Override
	public String toString() {
		return "mindist [dist=" + dist + ", x=" + x + ", y=" + y + ", idx=" + idx + "]";
	}

}

class enemy {
	int x;
	int y;

	enemy(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "enemy [x=" + x + ", y=" + y + "]";
	}

}