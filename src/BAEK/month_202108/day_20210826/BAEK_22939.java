package BAEK.month_202108.day_20210826;

import java.io.*;
import java.util.*;

public class BAEK_22939 {
	static int N;
	static char[][] map;
	static int endy, endx;
	static pos[] Assassin=new pos[3];
	static pos[] Healer=new pos[3];
	static pos[] Mage=new pos[3];
	static pos[] Tanker=new pos[3];
	static int A, H, M, T;
	static pos start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<pos[]> list = new ArrayList<>();
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp[j];
				if (map[i][j] == 'H') {
					start = new pos(i, j);
				}

				if (map[i][j] == 'J') {
					Assassin[A++] = new pos(i, j);
				} else if (map[i][j] == 'B') {
					Mage[M++] = new pos(i, j);
				} else if (map[i][j] == 'C') {
					Healer[H++] = new pos(i, j);
				} else if (map[i][j] == 'W') {
					Tanker[T++] = new pos(i, j);
				}

				if (map[i][j] == '#') {
					endy = i;
					endx = j;
				}
			}
		}
		list.add(Assassin);
		list.add(Tanker);
		list.add(Healer);
		list.add(Mage);
		
		String[] ss= {"Assassin","Tanker","Healer","Mage"};//이 순서로 탐색

		for (int i = 0; i < 4; i++) {
			permutation(new int[3], new boolean[3], 0,list.get(i),ss[i]);
//			System.out.println(result.toString());
		}
		
		Collections.sort(result);
		System.out.println(result.get(0));

	}
	static long ans=Integer.MAX_VALUE;
	static ArrayList<String> result=new  ArrayList<>();
	private static void permutation(int[] sel, boolean[] visit, int k, pos[] pos, String ss) {
		if(k==3) {
			
			int dist=Math.abs(start.y-pos[sel[0]].y)+Math.abs(start.x-pos[sel[0]].x)+//집에서 첫번째 좌표
					Math.abs(pos[sel[0]].y-pos[sel[1]].y)+Math.abs(pos[sel[0]].x-pos[sel[1]].x)+//첫->두
					Math.abs(pos[sel[1]].y-pos[sel[2]].y)+Math.abs(pos[sel[1]].x-pos[sel[2]].x)+//두->세
					Math.abs(pos[sel[2]].y-endy)+Math.abs(pos[sel[2]].x-endx);//세-> 루삥뽕

			if(ans>dist) {//거리 제일 작은거
				result.clear();//지원 분야 초기화
				ans= dist;
				result.add(ss);//지원 분야 입력
			}
			
			if(ans==dist) {//같은거리가 또 있으면 지원분야 ++
				result.add(ss);
			}
			return;
		}
		for(int i=0; i<3; i++) {
			if(visit[i])continue;
			sel[k]=i;
			visit[i]=true;
			permutation(sel,visit,k+1,pos,ss);
			visit[i]=false;
		}
		
		
		
	}

	

}

class pos {
	int y, x;

	public pos(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

}
