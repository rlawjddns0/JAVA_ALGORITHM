package BAEK.month_202102.day_20210224;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_3190 {
	static int N, K, L;
	static int[][] map;
	static info[] f;
	static int[] dx = { 1, 0, -1, 0 };// 오른쪽,아래, 왼 위
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<change> c=new ArrayList<change>();
		Queue<info> q=new LinkedList<info>();
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			map[y][x] = -1;// 사과 집어넣기
		}
		L = sc.nextInt();
		f = new info[L];
		for (int i = 0; i < L; i++) {
			q.add(new info(sc.nextInt(),sc.next().charAt(0)));
			//System.out.println(f[i].toString());
		}
		//d[0]:오른쪽 d[1]:아래쪽 d[2]:왼쫃 d[3]:위쪽
		int hx=1,hy=1,tx=1,ty=1;//머리 위치 ,꼬리 위치
		char dirh='R',dirt='R';//머리 방향, 꼬리 방향
		int dxh=dx[0],dyh=dy[0],dxt=dx[0],dyt=dy[0];//머리 꼬리s
		map[hy][hx]=1;//시작
		int i=0;
		while(true) {
			//System.out.println(i);
			//print();
			if(!q.isEmpty()&&i==q.peek().time) {
				if(q.peek().dir=='D') {
					if(dirh=='R') {dirh='D'; dxh=dx[1]; dyh=dy[1];c.add(new change(dxh,dyh,hx,hy,'R'));}
					else if(dirh=='D') {dirh='L';dxh=dx[2]; dyh=dy[2];c.add(new change(dxh,dyh,hx,hy,'D'));}
					else if(dirh=='L') {dirh='U';dxh=dx[3]; dyh=dy[3];c.add(new change(dxh,dyh,hx,hy,'L'));}
					else {dirh='R'; dxh=dx[0]; dyh=dy[0];c.add(new change(dxh,dyh,hx,hy,'U'));}
					q.poll();
				}else if(q.peek().dir=='L'){
					if(dirh=='R') {dirh='U'; dxh=dx[3]; dyh=dy[3];c.add(new change(dxh,dyh,hx,hy,'R'));}
					else if(dirh=='D') {dirh='R';dxh=dx[0]; dyh=dy[0];c.add(new change(dxh,dyh,hx,hy,'D'));}
					else if(dirh=='L') {dirh='D';dxh=dx[1]; dyh=dy[1];c.add(new change(dxh,dyh,hx,hy,'L'));}
					else {dirh='L'; dxh=dx[2]; dyh=dy[2];c.add(new change(dxh,dyh,hx,hy,'U'));}
					q.poll();
				}
			}
			
			
			hx=hx+dxh;
			hy=hy+dyh;
			
			if(hx>N || hx<1 || hy>N ||hy<1||map[hy][hx]==1)break;
			
			
			if(map[hy][hx]==-1) {
				map[hy][hx]=1;
			}
			else {
				map[hy][hx]=1;
				map[ty][tx]=0;
				
				if(c.size()!=0 &&ty==c.get(0).y && tx==c.get(0).x) {
					dyt=c.get(0).hy;
					dxt=c.get(0).hx;
					dirt=c.get(0).d;
					c.remove(0);
				}
				ty=ty+dyt;
				tx=tx+dxt;
			}
			i++;
		}
		
		
		
		System.out.println(i+1);
		
		
		

	}
	public static void print() {
		for(int i=0; i<N+1; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}

}
class change{
	int x;
	int y;
	char d;
	int hx; 
	int hy;
	change(int hx, int hy,int x, int y, char d){
		this.d=d;
		this.hx=hx;
		this.hy=hy;
		this.x=x;
		this.y=y;
	}
}
class info {
	int time;
	char dir;

	info(int time, char dir) {
		this.time = time;
		this.dir = dir;
	}

	@Override
	public String toString() {
		return "info [time=" + time + ", dir=" + dir + "]";
	}

}
