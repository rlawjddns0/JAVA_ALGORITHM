package BAEK.month_202102.day_20210210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_17406 {
	static int[][] map;
	static int[][] tmp;
	static int[][] Tmap;
	static int num,x,y;
	static int[][] input;
	static int min=Integer.MAX_VALUE;
	static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		num=Integer.parseInt(st.nextToken());
		
		map=new int[x+1][y+1];
		for(int i=1; i<=x; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=y; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		input=new int[num][3];
		for(int i=0; i<num; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < 3; j++) {
				input[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
	
		permutation(new int[num][3], 0, new boolean[num]);
		System.out.println(ans);
		
	}
	public static void permutation(int[][] sel,int k, boolean[] v) {
		if(k==sel.length) {
		
			Tmap=new int[x+1][y+1];
			for(int i=1; i<=x; i++) {
				for(int j=1; j<=y; j++) {
					Tmap[i][j]=map[i][j];//บนป็
				}
			}
			for(int i=0; i<sel.length; i++) {
				solve(sel[i]);
			}
			
			int sum=0;
			for(int i=1; i<=x; i++) {
				sum=0;
				for(int j=1; j<=y; j++) {
					sum+=Tmap[i][j];
				}
				min=Math.min(sum, min);
			}
			ans=Math.min(min, ans);
			
			
			return;
		}
		
		for(int i=0; i<input.length; i++) {
			if(v[i]==false) {
				sel[k]=input[i];
				v[i]=true;
				permutation(sel,k+1,v);
				v[i]=false;
			}
		}
		
		
	}
	public static void solve(int[] input) {
		
		int r=input[0];
		int c=input[1];
		int s=input[2];
		tmp=new int[2*s+1][2*s+1];
		
		
		
		for(int i=r-s,e=0; i<=r+s;e++ ,i++) {
			for(int j=c-s,q=0; j<=c+s;q++,j++) {
				tmp[e][q]=Tmap[i][j];
			}
		}
		

		
		int min=Math.min(tmp.length, tmp[0].length);
		min/=2;
		
		rotate(min,0,2*s,2*s);
		
		
		
		for(int i=r-s,e=0; i<=r+s;e++ ,i++) {
			for(int j=c-s,q=0; j<=c+s;q++,j++) {
				Tmap[i][j]=tmp[e][q];
			}
		}
		
		
		
	}
	public static void rotate(int min, int start, int lastx, int lasty) {
		if(min==0) {
			
			return;
		}
		
		
		Deque<Integer> q=new LinkedList<Integer>();
		
		for(int i=start; i<=lastx; i++) {
			q.offer(tmp[start][i]);
		}
		for(int i=start+1; i<=lasty; i++) {
			q.offer(tmp[i][lastx]);
		}
		for(int i=lastx-1; i>=start; i--) {
			q.offer(tmp[lasty][i]);
		}
		for(int i=lasty-1; i>start; i--) {
			q.offer(tmp[i][start]);
		}
		
		q.offerFirst(q.pollLast());
		
		for(int i=start; i<=lastx; i++) {
			tmp[start][i]=q.poll();
		}
		for(int i=start+1; i<=lasty; i++) {
			tmp[i][lastx]=q.poll();
		}
		for(int i=lastx-1; i>=start; i--) {
			tmp[lasty][i]=q.poll();
		}
		for(int i=lasty-1; i>start; i--) {
			tmp[i][start]=q.poll();
		}

		
		rotate(min-1, start+1,lastx-1,lasty-1);
		
	}
	public static void print(int[][] map) {
		
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}

}
