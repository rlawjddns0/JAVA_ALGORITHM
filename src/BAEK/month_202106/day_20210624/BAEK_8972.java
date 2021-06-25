package BAEK.month_202106.day_20210624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_8972 {
	static int R,C;
	static int jongsuy, jongsux;
	static char[][] map;
	static int[][] arduino;
	static ArrayList<crazy> list;
	static int dx[]= {0,-1,0,1,-1,0,1,-1,0,1};
	static int dy[]= {0,1,1,1,0,0,0,-1,-1,-1};
	static char[] order;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		arduino=new int[R][C];
		list=new ArrayList<>();
		for(int i=0; i<R; i++) {
			char[] tmp=br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				map[i][j]=tmp[j];
				if(map[i][j]=='R') {
					list.add(new crazy(i,j));
					arduino[i][j]++;
				}
				if(map[i][j]=='I') {
					jongsux=j;
					jongsuy=i;
				}
			}
		}
		order=br.readLine().toCharArray();
		
		int TEST=0;
		for(TEST=0; TEST<order.length; TEST++) {
			int d=order[TEST]-'0';
			
			int ny=jongsuy+dy[d];
			int nx=jongsux+dx[d];
			
			if(map[ny][nx]=='R')break;//종수가 움직였는데 미친 아두이노가 있으면
			
			//갱신
			map[jongsuy][jongsux]='.';
			map[ny][nx]='I';
			jongsuy=ny;
			jongsux=nx;
			
			
			
			if(!arduino())break;
//			print();
			
			
			
			
			
			
			
		}
		
//		print();
		
		
		if(TEST<order.length) {
			System.out.println("kraj"+ " "+(TEST+1));
		}else {
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		
		
		
		
		
	}
	private static void print() {
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(arduino[i]));
		}
		System.out.println();
		
	}
	private static boolean arduino() {
		char[][] tmp=new char[R][C];
		for(int i=0; i<R; i++) {
			Arrays.fill(tmp[i], '.');
		}
		tmp[jongsuy][jongsux]='I';
		for(int i=0; i<list.size(); i++) {
			int x=list.get(i).x;
			int y=list.get(i).y;
			int min=Integer.MAX_VALUE;
			int mind=0;
			for(int d=1; d<dx.length; d++) {
				int ny=y+dy[d];
				int nx=x+dx[d];
				if((Math.abs(jongsux-nx)+Math.abs(jongsuy-ny))<min) {
					mind=d;
//					System.out.println("거리: "+(Math.abs(jongsux-nx)+Math.abs(jongsuy-ny)));
//					System.out.println("방향: "+mind);
					min=(Math.abs(jongsux-nx)+Math.abs(jongsuy-ny));
					
				}
				
			}
			int ny=y+dy[mind];
			int nx=x+dx[mind];
			if(map[ny][nx]=='I')return false;
			
			tmp[ny][nx]='R';
			arduino[y][x]--;
			arduino[ny][nx]++;
			
			
			
			
		}
		for(int i=0; i<R; i++) {
			map[i]=tmp[i].clone();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arduino[i][j]>=2) {
					arduino[i][j]=0;
					map[i][j]='.';
				}
			}
		}
		list.clear();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]=='R') {
					list.add(new crazy(i,j));
				}
				
			}
		}
		
		
		
		
		
		return true;
		
		
		
		
	}

}
class crazy{
	int y,x;

	public crazy(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		return "crazy [y=" + y + ", x=" + x + "]";
	}
	
}