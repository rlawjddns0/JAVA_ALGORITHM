package BAEK.month_202104.day_20210414;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 시간 너무 비효율이라 다시 풀어보자
 */
public class BAEK_17144 {
	static int R, C, T;
	static int[][] map;
	static int upx, upy, downx, downy;
	static ArrayList<pos> list;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		list=new ArrayList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					downx = j;
					downy = i;
				}
				if(map[i][j]>4)list.add(new pos(i,j,0));
				
			}
		}

		upx = downx;
		upy = downy - 1;
		//print();
		//System.out.println();
		while (T != 0) {
			//System.out.println("Round:"+T);
			spead();
			//print();
			air();
			//print();

			T--;
		}
		
		System.out.println(count());
		

	}
	private static int count() {
		int sum=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>0) {
					sum+=map[i][j];
				}
			}
		}
		return sum;
	}
	private static void print() {
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
	}
	private static void air() {
		
		Queue<Integer> q1=new LinkedList<>();
		
		for(int i=upy; i>=0;i--) {
			q1.offer(map[i][upx]);
		}
		for(int i=1; i<C; i++) {
			q1.offer(map[0][i]);
		}
		for(int i=1; i<=upy; i++) {
			q1.offer(map[i][C-1]);
		}
		for(int i=C-2; i>upx; i--) {
			q1.offer(map[upy][i]);
		}
		q1.poll();
		q1.offer(0);
		
		for(int i=upy; i>=0;i--) {
			map[i][upx]=q1.poll();
		}
		for(int i=1; i<C; i++) {
			map[0][i]=q1.poll();
		}
		for(int i=1; i<=upy; i++) {
			map[i][C-1]=q1.poll();
		}
		for(int i=C-2; i>upx; i--) {
			map[upy][i]=q1.poll();
		}
		
		map[upy][upx]=-1;
		
		
		Queue<Integer> q2=new LinkedList<>();
		
		for(int i=downy; i<R; i++) {
			q2.offer(map[i][downx]);
		}
		for(int i=1; i<C; i++) {
			q2.offer(map[R-1][i]);
		}
		for(int i=R-2; i>=downy; i--) {
			q2.offer(map[i][C-1]);
		}
		for(int i=C-2; i>downx; i--) {
			q2.offer(map[downy][i]);
		}
		q2.poll();
		q2.offer(0);
		
		for(int i=downy; i<R; i++) {
			map[i][downx]=q2.poll();
		}
		for(int i=1; i<C; i++) {
			map[R-1][i]=q2.poll();
		}
		for(int i=R-2; i>=downy; i--) {
			map[i][C-1]=q2.poll();
		}
		for(int i=C-2; i>downx; i--) {
			map[downy][i]=q2.poll();
		}
		
		map[downy][downx]=-1;
		
		
		list.clear();
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>4)list.add(new pos(i,j,0));
			}
		}
		

	}

	private static void spead() {

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		ArrayList<pos> t=new ArrayList<pos>();
		//System.out.println(list.toString());
		for (pos tmp : list) {
			int cnt=0;
			for (int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny =tmp.y + dy[d];
				if(nx>=0 && nx<C && ny>=0 && ny<R && map[ny][nx]!=-1 ) {
					if((d==0 || d==1)&& map[ny][nx]!=0) {
						t.add(new pos(ny,nx,(int)(map[tmp.y][tmp.x]/5)));
						cnt++;
						continue;
					}
					
					map[ny][nx]+=(int)(map[tmp.y][tmp.x]/5);
					cnt++;
				}
				
			}
			map[tmp.y][tmp.x]-=(int)(map[tmp.y][tmp.x]/5)*cnt;
			
		}
		
		for (pos pos : t) {
			map[pos.y][pos.x]+=pos.w;
		}
		
		

	}

}
class pos{
	int y,x,w;

	public pos(int y, int x, int w) {
		super();
		this.y = y;
		this.x = x;
		this.w=w;
	}

	@Override
	public String toString() {
		return "pos [y=" + y + ", x=" + x + "]";
	}
	
}
