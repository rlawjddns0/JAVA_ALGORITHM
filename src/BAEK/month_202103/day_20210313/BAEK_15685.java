package BAEK.month_202103.day_20210313;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_15685 {
	static int N;
	static dragon[] d;
	static int[][] map;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("./src/input/드래곤커브.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[101][101];
		N = Integer.parseInt(br.readLine());
		d = new dragon[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			check(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		cal();
		
		//print();
		System.out.println(cnt);

	}
	public static void cal() {
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]==1 && map[i][j+1]==1 && map[i+1][j]==1 && map[i+1][j+1]==1) {
					cnt++;
				}
			}
		}
	}
	public static void check(int x, int y, int d, int g ) {
		
		ArrayList<Integer> dir=new ArrayList<Integer>();
		dir.add(d);//처음
		
		for(int i=0; i<g; i++) {
			for(int j=dir.size()-1; j>=0; j--) {
				int tmpd=dir.get(j);
				tmpd++;
				if(tmpd==4)tmpd=0;
				dir.add(tmpd);
				
			}
		}
		map[y][x]=1;
//		for(int i=0; i<dir.size(); i++) {
//			x=x+dx[dir.get(i)];
//			y=y+dy[dir.get(i)];
//			map[y][x]=1;
//		}
		
		for (Integer t : dir) {//더 빠르다
			x=x+dx[t];
			y=y+dy[t];
			map[y][x]=1;
		}
		
		
		
	}
	public static void print() {
		for(int i=0; i<101; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

}

class dragon {
	int x, y, d, gen;

	@Override
	public String toString() {
		return "dragon [x=" + x + ", y=" + y + ", d=" + d + ", gen=" + gen + "]";
	}

	public dragon(int x, int y, int d, int gen) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
		this.gen = gen;
	}

}