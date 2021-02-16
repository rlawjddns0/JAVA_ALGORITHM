package BAEK.month_202102.day_20210215;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_16928 {
	static int move[] = new int[101];
	static int count[] = new int[101];
	static boolean[] v = new boolean[101];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		for (int i = 0; i < N + M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			move[from] = to;
		}

		solve();

	}

	public static void solve() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		if (move[1] != 0) {//시작부터 사다리나 뱀 있는 경우
			q.offer(move[1]);
			count[move[1]] = 0;
			v[move[1]] = true;
			v[1]=true;
		} else {
			q.offer(1);// 시작 지점
			count[1] = 0;// 시작 지점은 주사위 0번
			v[1] = true;// 방문 체크
		}
		while (!q.isEmpty()) {
			int current = q.poll();// 현재 위치
			if (current == 100) {// 100이면 그만
				System.out.println(count[current]);
				return;
			}

			for (int i = 1; i < 7; i++) {// 현재 위치에서 주사위 굴리기
				int x = current + i;// 현재 위치 + 주사위 눈
				if (x > 100)
					continue;// 주사윌ㄹ 굴렸는데 100을 넘어가면 안넘어가게끔 하는 주사위를 굴려야함
				if (v[x] == true)
					continue;// 방문 한 곳이면 다시 굴리기

				v[x] = true;// 새로운 위치 방문 체크

				if (move[x] != 0) {// 사다리나 뱀이 있으면
					if (!v[move[x]]) {// 사다리나 뱀을 타고 간 곳을 아직 안갔으면
						q.offer(move[x]);// 타고 간 위치 q에 넣기
						v[move[x]] = true;// 방문 체크
						count[move[x]] = count[current] + 1;// 현재 방문 위치를 주사위 몇번 굴려서 갔는지

					}
				} else {// 사다리나 뱀이 없으면
					q.offer(x);// 위치 넣기
					count[x] = count[current] + 1;// 현재 방문 위치를 주사위 몇번 굴려서 갔는지

				}
			}
		}
	}

}
