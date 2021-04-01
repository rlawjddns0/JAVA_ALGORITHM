package BAEK.month_202104.day_20210401;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_21278 {
	static long[][] D;//Integer.MAX끼리 더해지는 경우가 있어서 그 경우 int형 범위를 넘어간다 그래서 lon형으로 선언
	static int N,M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		D=new long[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			Arrays.fill(D[i], Integer.MAX_VALUE);
		}
		for(int i=1; i<N+1; i++) {
			D[i][i]=0;
		}
		for(int i=0; i<M; i++) {
			int from=sc.nextInt();
			int to=sc.nextInt();
			D[from][to]=1;
			D[to][from]=1;
		}
		
		floyd();
		dfs(new int[2], 0,1);//(1,2) 나 (2,1)이나 같다
		System.out.println(ch1+" "+ch2+" "+Sum);
		
	}
	static int Sum=Integer.MAX_VALUE;
	static int ch1, ch2;
	public static void dfs(int[] sel, int k, int idx) {
		if(k==sel.length) {
			//System.out.println(Arrays.toString(sel));
			int tmpsum=0;
			for(int i=1; i<N+1; i++) {
				if(sel[0]==i || sel[1]==i)continue;//치킨집은 무시
				int min=Integer.MAX_VALUE;
				for(int j=0; j<sel.length; j++) {
					min=(int)Math.min(min, D[i][sel[j]]);//치킨집이 아닌곳에서 치킨집 까지의 거리가 가장 최소인 거릭 구하기(가장 가까운 치킨집)구하기 
				}
				tmpsum+=(min*2);
				
			}
			//System.out.println(tmpsum);
			//sel[0]이 무조건 작은 숫자임
			if(tmpsum<Sum) {//치킨집까지으 거리가 제일 작은게 나왔다
				Sum=tmpsum;//제일 작은거 갱신
				ch1=sel[0];//번호가 작은 치킨집
				ch2=sel[1];//큰 치킨집
			}else if(Sum==tmpsum) {//같다
				if(sel[0]<ch1) {//이전에 작은 치킨집 번호보다 지금 온 치킨집 번호가 더 작다
					ch1=sel[0];
					ch2=sel[1];
				}else if(sel[0]==ch1) {//작은게 같으면
					if(sel[1]<ch2) {//큰거 비교
						ch1=sel[0];
						ch2=sel[1];
					}
				}
			}
			
			
			
			
			return;
		}
		
		
		for(int i=idx; i<N+1; i++) {
			sel[k]=i;
			dfs(sel,k+1,i+1);
		}
		
	}
	
	public static void print() {
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				System.out.print(D[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void floyd() {
		
		for(int k=1; k<N+1; k++) {
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					D[i][j]=Math.min(D[i][k]+D[k][j], D[i][j]);
				}
			}
		}
		
	}

}
