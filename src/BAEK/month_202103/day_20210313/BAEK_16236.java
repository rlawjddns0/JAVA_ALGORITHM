package BAEK.month_202103.day_20210313;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_16236 {
	static int N;
	static int [][] map;
	static baby_shark B;
	static ArrayList<fish> F;
	static LinkedList<sort_fish> dis;
	static int time;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,-1,0,1};
	static boolean[][] visit;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("./src/input/아기상어.txt"));
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		F=new ArrayList<fish>();
		dis=new LinkedList<sort_fish>();
		map=new int[N][N];
		visit=new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==9)B=new baby_shark(j, i, 2);
				if(map[i][j]!=0 && map[i][j]!=9) {
					F.add(new fish(j,i,map[i][j]));
				}
			}
		}
		check();//가장 가까우면서도 가장 위에 있고 가장 왼쪽에 있는
		if(dis.size()==0) {
			System.out.println(0);
		}else {
			int x=B.x;
			int y=B.y;
			for(int i=0; i<dis.size(); i++) {
				Queue q=new LinkedList<E>
				
				
				
			}
			
			
		}
		System.out.println(dis.toString());
	}
	
	public static void check() {
		for(int i=0; i<F.size(); i++) {
				dis.add(new sort_fish(F.get(i).x, F.get(i).y, F.get(i).size,
						(Math.abs(B.x-F.get(i).x))+Math.abs(B.y-F.get(i).y)));
		}
		Collections.sort(dis);
	}

}
class baby_shark{
	int x,y,size;

	public baby_shark(int x, int y, int size) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
	}
}
class fish{
	int x,y,size;

	public fish(int x, int y, int size) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
}
class sort_fish implements Comparable<sort_fish>{
	int x,y,size,dis;

	public sort_fish(int x, int y, int size, int dis) {
		super();
		this.x = x;
		this.y = y;
		this.size = size;
		this.dis = dis;
	}

	@Override
	public String toString() {
		return "sort_fish [x=" + x + ", y=" + y + ", size=" + size + ", dis=" + dis + "]";
	}

	@Override
	public int compareTo(sort_fish o) {
		if(this.dis<o.dis) {
			return -1;
		}
		else if(this.dis==o.dis) {
			if(this.y<o.y) {
				return -1;
			}
			else if(this.y==o.y) {
				if(this.x<o.x) {
					return -1;
				}
			}
		}
		return 0;
	}
	
}