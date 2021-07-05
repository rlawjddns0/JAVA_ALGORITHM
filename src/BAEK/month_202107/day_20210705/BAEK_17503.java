package BAEK.month_202107.day_20210705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_17503 {
	static int N, M, K;
	static PriorityQueue<beer> B;
	static beer[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int left = 0;
		int right = Integer.MAX_VALUE;

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		B = new PriorityQueue<>();
		input = new beer[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i]=new beer(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(input);
//		System.out.println(Arrays.toString(input));
		int sum=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0; i<K; i++) {
			pq.add((input[i].like));
			sum+=input[i].like;
//			System.out.println(pq.toString());
			if(pq.size()>N) {
//				System.out.println("1111111111");
				sum-=pq.poll();
				
			}
			if(pq.size()==N && sum>=M) {
				System.out.println(input[i].level);
				return ;
			}
			
			
		}
		System.out.println("-1");


	}

}

class beer implements Comparable<beer> {
	int like;
	int level;

	public beer(int like, int level) {
		super();
		this.like = like;
		this.level = level;
	}

	@Override
	public String toString() {
		return "beer [like=" + like + ", level=" + level + "]";
	}

	@Override
	public int compareTo(beer o) {
		return this.level-o.level;
	}

}
