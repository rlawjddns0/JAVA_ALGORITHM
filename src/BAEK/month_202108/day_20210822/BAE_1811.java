package BAEK.month_202108.day_20210822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BAEK_1811 {
	static String L;
	static String K;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = br.readLine();
		K = br.readLine();
		int a = (int)Math.pow(2,L.length());
		int b = (int)Math.pow(2,K.length());
		
		if (a < b) {
			visit = new boolean[b];
		} else {
			visit = new boolean[a];
		}
		visit[Integer.parseInt(L, 2)] = true;
		Queue<pos> q = new LinkedList<pos>();
		q.offer(new pos(L, 0));
		while (!q.isEmpty()) {
			pos cur = q.poll();
//			System.out.println(q.toString());
			if (cur.curL.equals(K)) {
				System.out.println(cur.count);
				break;
			}
			int curNum = Integer.parseInt(cur.curL, 2);
//			System.out.println(curNum);
			
			if (curNum - 1 != 0 && !visit[curNum - 1]) {
				String tmp = Integer.toBinaryString(curNum - 1);
//				System.out.println(tmp);
				visit[curNum - 1]=true;
				q.offer(new pos(tmp, cur.count + 1));
			}
			if (curNum +1<visit.length && !visit[curNum + 1]) {
				String tmp = Integer.toBinaryString(curNum + 1);
				visit[curNum + 1]=true;
				q.offer(new pos(tmp, cur.count + 1));
			}
			
			for (int i = 1; i < cur.curL.length(); i++) {
				if (cur.curL.charAt(i) == '0') {
					StringBuffer sb = new StringBuffer();
					sb.append(cur.curL);
					sb.replace(i, i + 1, "1");
					String tmp = sb.toString();
					if (!visit[Integer.parseInt(tmp, 2)]) {
						visit[Integer.parseInt(tmp, 2)]=true;
						q.offer(new pos(tmp, cur.count + 1));
					}

				} 
				if(cur.curL.charAt(i) == '1') {
					StringBuffer sb = new StringBuffer();
					sb.append(cur.curL);
					sb.replace(i, i + 1, "0");
					String tmp = sb.toString();
					if (!visit[Integer.parseInt(tmp, 2)]) {
						visit[Integer.parseInt(tmp, 2)]=true;
						q.offer(new pos(tmp, cur.count + 1));
					}
				}
			}
//			System.out.println(q.toString());

		}

	}

}

class pos {
	String curL;
	int count;

	public pos(String curL, int count) {
		super();
		this.curL = curL;
		this.count = count;
	}

	@Override
	public String toString() {
		return "pos [curL=" + curL + ", count=" + count + "]";
	}

}
