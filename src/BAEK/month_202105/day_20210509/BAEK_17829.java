package BAEK.month_202105.day_20210509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_17829 {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		if(N==2) {
			int[] tmp=new int[4];
			int k=0;
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					tmp[k++]=map[i][j];
				}
			}
			Arrays.sort(tmp);
			System.out.println(tmp[2]);
			System.exit(0);
		}
		int s=N;
		tp=new int[N/2][N/2];
		divide(0,0,N,map);
		if(tp.length==2) {
			int[] tmp=new int[4];
			int k=0;
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					tmp[k++]=tp[i][j];
				}
			}
			Arrays.sort(tmp);
			System.out.println(tmp[2]);
			System.exit(0);
		}
		s=N/2;
		int[][] ans=new int[tp.length][tp.length];;
		while(true) {
			
			
			ans=new int[tp.length][tp.length];
			for(int i=0; i<tp.length; i++) {
				ans[i]=tp[i].clone();
			}
			if(s==2)break;
			tp=new int[s][s];
			divide(0,0,s,ans);
			s=s/2;
		}
		
		int[] tmp=new int[4];
		int k=0;
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				tmp[k++]=ans[i][j];
			}
		}
		Arrays.sort(tmp);
		System.out.println(tmp[2]);
		
		
	}
	static int[][] tp;
	private static void divide(int startx, int starty, int N, int[][] map) {
		
		if(N==2) {
			int[] tmp=new int[4];
			int k=0;
			for(int i=starty; i<starty+N; i++) {
				for(int j=startx; j<startx+N; j++) {
					tmp[k++]=map[i][j];
				}
			}
			Arrays.sort(tmp);
//			System.out.println(tmp[2]);
			tp[starty/2][startx/2]=tmp[2];
			return ;
		}
		
			divide(startx,starty,N/2,map);
			divide(startx+N/2,starty,N/2,map);
			divide(startx,starty+N/2,N/2,map);
			divide(startx+N/2,starty+N/2,N/2,map);

		
		
		
	}

}
