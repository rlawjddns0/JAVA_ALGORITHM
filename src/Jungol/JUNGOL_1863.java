package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JUNGOL_1863 {
	static int N, M;
	static int[] parents;
	static int[] rank;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken()); // 사람 수
		M = Integer.parseInt(st.nextToken()); // 사람 수
		parents = new int[N + 1];
		rank = new int[N + 1];
		makeSets();
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			union(p, c);
		}

		for (int i = 1; i <= N; i++) {
			if (i == parents[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static void makeSets() {// 크기가 1인 단위 집합을 만든다
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
//	        return findSet(parents[a]);    //without path compression
		return parents[a] = findSet(parents[a]); // without path compression
	}

	static void union(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if (rank[rootA] < rank[rootB]) {
			parents[rootA] = rootB;
		} else {
			parents[rootB] = rootA;
			if (rank[rootA] == rank[rootB]) {
				rank[rootA]++;

			}
		}

	}
}
