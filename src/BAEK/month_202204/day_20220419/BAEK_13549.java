package BAEK.month_202204.day_20220418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_13549 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int ans = 0;

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		boolean[] visit1 = new boolean[100001];
		boolean[] visit2 = new boolean[100001];
		int[] dx = { 1, -1 };
		
		LinkedList<pos> q = new LinkedList<>();
		q.offer(new pos(N, 0));
		

		while (!q.isEmpty()) {
			pos cur = q.poll();
//			System.out.println(q.toString());
//			System.out.println(cur.idx);
			visit1[cur.idx]=true;
			if (cur.idx == K) {
				ans = cur.time;
				break;
			}
			
			if(cur.idx*2<=100000 && !visit1[cur.idx*2]) {
				q.addFirst(new pos(cur.idx*2,cur.time));
			}
			

			for (int d = 0; d < 2; d++) {
				
					int nx = dx[d] + cur.idx;
//					System.out.println("nx:"+nx);
					if (nx < 0 || nx > 100000)
						continue;
					if (visit1[nx])
						continue;
					q.offer(new pos(nx, cur.time + 1));
				
			}

		}

		System.out.println(ans);

	}

	static class pos {
		int idx, time;

		public pos(int idx, int time) {
			super();
			this.idx = idx;
			this.time = time;
		}

		@Override
		public String toString() {
			return "pos [idx=" + idx + ", time=" + time + "]";
		}
		

	}
}
