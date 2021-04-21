package BAEK.month_202104.day_20210421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_15683_2 {
	
	
	static int N,M;
	static int[][] map;
	static int[][] tmp;
	static String[] type= {null,"0","02","03","023","0123"};
	static int[] dx= {1,0,-1,0};
	static int[]dy= {0,1,0,-1};
	static ArrayList<cctv> c;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		c=new ArrayList<>();
		map=new int[N][M];
		tmp=new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				tmp[i][j]=map[i][j];
				if(map[i][j]>=1 && map[i][j]<=5)c.add(new cctv(i,j,map[i][j]));
			}
		}
		
		
		
		dfs(0,tmp,-1);
		
		System.out.println(ans);
	}
	static int ans=Integer.MAX_VALUE;
	private static void dfs(int cnt, int[][] tmp, int f) {
		
		if(cnt==c.size()) {
			int count=0;
			for(int i=0; i<N; i++) {
				//System.out.println(Arrays.toString(tmp[i]));
				for(int j=0; j<M; j++) {
					if(tmp[i][j]==0) {
						count++;
					}
				}
			}
			//System.out.println();
			//ans=Math.min(count, ans);
			if(count<ans) {
				ans=count;
//				for(int i=0; i<N; i++) {
//					System.out.println(Arrays.toString(tmp[i]));
//				}
//				System.out.println();
			}
			return;
		}
		cctv tp=c.get(cnt);
		int x=tp.x;
		int y=tp.y;
		int num=tp.num;
//		for(int i=0; i<N; i++) {
//			tmap[i]=tmp[i].clone();
//		}
		for(int d=0; d<4; d++) {
			check(d,tmp,num,y,x,0,f);
			dfs(cnt+1,tmp,f-1);
			check(d,tmp,num,y,x,f,0);
		}
		
		
		
	}
	private static int[][] check(int d,int[][] tmp, int num, int y, int x,int b, int a) {
		
		
		for(int i=0; i<type[num].length(); i++) {
			int nd=(type[num].charAt(i)-'0'+d)%4;
			int nx=x+dx[nd];
			int ny=y+dy[nd];
			while(true) {
				if(nx>=M || ny>=N || nx<0 || ny<0 || map[ny][nx]==6)break;
				if(tmp[ny][nx]==b) tmp[ny][nx] = a;
				nx+=dx[nd];
				ny+=dy[nd];
				
			}
			
			
		}
		
		
		return tmp;
		
		
		
	}

}
//class cctv1{
//	int y,x,num;
//
//	public cctv(int y, int x, int num) {
//		super();
//		this.y = y;
//		this.x = x;
//		this.num = num;
//	}
//	
//}