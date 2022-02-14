package BAEK.month_202202.day_20220204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_13913 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N>K) {
			System.out.println(N-K);
			for(int i=N; i>=K; i--) {
				System.out.print(i+" ");
			}
			System.exit(0);
		}
		
		

		Queue<pos> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(N);
		StringBuffer sb=new StringBuffer();
		sb.append(N+" ");
		q.offer(new pos(N, 0,sb));
		int[] dx = { -1, 1 };
		boolean[] visit = new boolean[100001];
		while (!q.isEmpty()) {

			pos cur = q.poll();

			if (cur.n == K) {
				System.out.println(cur.cnt);
				System.out.println(cur.sb);
				break;

			}
			for (int d = 0; d < 2; d++) {
				int nx = dx[d] + cur.n;
				if (nx < 0)
					continue;
				if (nx > 100000)
					continue;
				if (visit[nx])
					continue;
				
				
				visit[nx] = true;
				StringBuffer ssb=new StringBuffer();
				ssb.append(cur.sb.toString()+nx+" ");
				
				q.offer(new pos(nx, cur.cnt + 1, ssb));
			}

			int nnx = cur.n * 2;
			if (nnx <= 100000 && !visit[nnx]) {
				
				visit[nnx] = true;
				StringBuffer ssb=new StringBuffer();
				ssb.append(cur.sb.toString()+nnx+" ");
				q.offer(new pos(nnx, cur.cnt + 1, ssb));
			}

		}

	}

	static class pos {
		int n, cnt;
		StringBuffer sb=new StringBuffer();

		public pos(int n, int cnt, StringBuffer sb) {
			super();
			this.cnt = cnt;
			this.n = n;
			this.sb=sb;
		}

	}

}
