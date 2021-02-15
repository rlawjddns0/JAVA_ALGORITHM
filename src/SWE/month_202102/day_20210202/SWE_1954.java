package SWE.month_202102.day_20210202;

import java.util.Scanner;

public class SWE_1954 {
	static int[][] arr;
	static int[] dx= {1,0,-1,0};//오, 아 , 왼 , 위
	static int[] dy= {0,1,0,-1};
	static int n;
	static int last;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testCase=sc.nextInt();
		for(int t=0; t<testCase; t++) {
			int N=sc.nextInt();
			n=1;
			last=N*N;
			arr=new int[N][N];
			arr[0][0]=1;
			recursive(0,1,0,N,N,0,0);//0,0에서 오른쪽으로 배열까지
			System.out.println("#"+(t+1));
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			
		}
		

	}
	private static void recursive(int y,int x, int d, int R,int B,int L,int T) {//map 방향,어디까지 갈꺼니?
		
		if(n==last)
			return;
		
		if((x+1)>=R && d==0) {//직전에 오른쪽으로 가다가 끝을 만나고 
			d=1;
			
			T=T+1;
			n++;
		}
		else if((y+1)>=B && d==1 ) {
			d=2;
			R=R-1;
			n++;
		}
		else if((x-1)<L && d==2) {
			d=3;
			B=B-1;
			n++;
		}
		else if((y-1)<T && d==3) {
			d=0;
			L=L+1;
			n++;
		}
		else {
			n++;
		}
		
		
		
		arr[y][x]=n;
		
		
		int nx=x+dx[d];
		int ny=y+dy[d];
		//System.out.println("Y: "+ny+" X: "+nx+" D: "+d);
		recursive(ny,nx,d,R,B,L,T);
		
		
	}
}
