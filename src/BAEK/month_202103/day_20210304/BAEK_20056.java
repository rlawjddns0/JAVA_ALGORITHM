package BAEK.month_202103.day_20210304;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BAEK_20056 {
	static int N,M,K;
	static ArrayList<fireBall> fb;
	static int[] dx= {0,1,1,1,0,-1,-1,-1};
	static int[] dy= {-1,-1,0,1,1,1,0,-1};
	static int[][] count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("./src/input/파이어볼.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		count=new int[N][N];
		fb=new ArrayList<fireBall>();
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			fb.add(new fireBall(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			
		}
		while(K!=0) {
			init();
			for(int i=0; i<fb.size(); i++) {//이동
				int r=fb.get(i).r;
				int c=fb.get(i).c;
				int m=fb.get(i).m;//질량
				int s=fb.get(i).s;//속력
				int d=fb.get(i).d;//방향
				;
				
				int dis=s%N;//모듈라 연산으로 넘어가는 범위 구하기
				int nr=r+dy[d]*dis;
				int nc=c+dx[d]*dis;
				if(nr>=N)nr-=N;
				if(nr<0)nr+=N;
				if(nc>=N)nc-=N;
				if(nc<0)nc+=N;
			
				count[nr][nc]++;//파이어 볼이 이동한 후 그 자리에 파이어볼 카운트 해주기
				fb.get(i).r=nr;//이동 후 위치 갱신
				fb.get(i).c=nc;//이동 후 위치 갱신
				
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(count[i][j]>1) {//2개 이상 모여있다.
						int sumM=0;//무게 합
						int sumS=0;//속력 합
						int cnt=0;//지금 모여있는 파이어볼 카운트
						int odd=0,even=0;//나중에 방향을 위해서 
						for(int k=0; k<fb.size(); k++) {//리스트 탐색
							if(fb.get(k).r==i && fb.get(k).c==j) {//모여있는거 찾기
								sumM+=fb.get(k).m;//질량 합
								sumS+=fb.get(k).s;//속력 합
								cnt++;//합쳐진 파이어볼의 개수
								if(fb.get(k).d%2==0) {
									even++;//짝수
								}else {
									odd++;//홀수
								}
								fb.remove(k);//합친거는 삭제
								k--;
							}
						}

						if(sumM<5) {//합이 5 이하이면 그냥 업는거 그래서 count=0;
							count[i][j]=0;
							
							continue;
						}
						int divideM=sumM/5;
						int divideS=sumS/cnt;
						int start=0;
						if(even==0 || odd==0){ //모두 홀수 이거나 짝수
							start=0;
						}
						else {
							start=1;
						}
						int tmp=0;
						for(int d=start; d<8; d+=2) {
							fb.add(new fireBall(i,j,divideM,divideS,d));//현재 위치 , 나눠진 무게 , 나눠진 속력, 방향 저장
							tmp++;
						}
					}
				}
			}
			K--;
			
		}
		int ans=0;
		for(int i=0; i<fb.size(); i++) {//명령 끝나면 리스트에 남아 있는 
			ans+=fb.get(i).m;
		}
		System.out.println(ans);
		
	}
//	public static void print() {
//		System.out.println("fire ball");
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();
//		
//		System.out.println("count");
//		for(int i=0; i<N; i++) {
//			System.out.println(Arrays.toString(count[i]));
//		}
//		System.out.println();
//	}
	public static void init() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				count[i][j]=0;
			}
		}
	}

}
class fireBall{
	int r;
	int c;
	int m;//질량
	int d;//방향
	int s;//속력
	public fireBall(int r, int c, int m, int s, int d) {
		super();
		this.r = r;
		this.c = c;
		this.m = m;
		this.d = d;
		this.s = s;
	}
	@Override
	public String toString() {
		return "fireBall [r=" + r + ", c=" + c + ", m=" + m + ", d=" + d + ", s=" + s + "]";
	}
}