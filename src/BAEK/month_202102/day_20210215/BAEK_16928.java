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
		
		if (move[1] != 0) {//���ۺ��� ��ٸ��� �� �ִ� ���
			q.offer(move[1]);
			count[move[1]] = 0;
			v[move[1]] = true;
			v[1]=true;
		} else {
			q.offer(1);// ���� ����
			count[1] = 0;// ���� ������ �ֻ��� 0��
			v[1] = true;// �湮 üũ
		}
		while (!q.isEmpty()) {
			int current = q.poll();// ���� ��ġ
			if (current == 100) {// 100�̸� �׸�
				System.out.println(count[current]);
				return;
			}

			for (int i = 1; i < 7; i++) {// ���� ��ġ���� �ֻ��� ������
				int x = current + i;// ���� ��ġ + �ֻ��� ��
				if (x > 100)
					continue;// �ֻ����� ���ȴµ� 100�� �Ѿ�� �ȳѾ�Բ� �ϴ� �ֻ����� ��������
				if (v[x] == true)
					continue;// �湮 �� ���̸� �ٽ� ������

				v[x] = true;// ���ο� ��ġ �湮 üũ

				if (move[x] != 0) {// ��ٸ��� ���� ������
					if (!v[move[x]]) {// ��ٸ��� ���� Ÿ�� �� ���� ���� �Ȱ�����
						q.offer(move[x]);// Ÿ�� �� ��ġ q�� �ֱ�
						v[move[x]] = true;// �湮 üũ
						count[move[x]] = count[current] + 1;// ���� �湮 ��ġ�� �ֻ��� ��� ������ ������

					}
				} else {// ��ٸ��� ���� ������
					q.offer(x);// ��ġ �ֱ�
					count[x] = count[current] + 1;// ���� �湮 ��ġ�� �ֻ��� ��� ������ ������

				}
			}
		}
	}

}
