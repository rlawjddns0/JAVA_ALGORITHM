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
	static int[][] map;
	static int[][] count;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("./src/input/���̾.txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		count=new int[N][N];
		fb=new ArrayList<fireBall>();
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			fb.add(new fireBall(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			map[fb.get(i).r][fb.get(i).c]=fb.get(i).m;
			
		}
		while(K!=0) {
			init();
			for(int i=0; i<fb.size(); i++) {//�̵�
				int r=fb.get(i).r;
				int c=fb.get(i).c;
				int m=fb.get(i).m;//����
				int s=fb.get(i).s;//�ӷ�
				int d=fb.get(i).d;//����
				
				map[r][c]=0;
				
				int dis=s%N;//���� �������� �Ѿ�� ���� ���ϱ�
				int nr=r+dy[d]*dis;
				int nc=c+dx[d]*dis;
				if(nr>=N)nr-=N;
				if(nr<0)nr+=N;
				if(nc>=N)nc-=N;
				if(nc<0)nc+=N;
			
				map[nr][nc]+=m;
				count[nr][nc]++;//�̵��ϰ� � �ִ��� ī��Ʈ
				fb.get(i).r=nr;
				fb.get(i).c=nc;
				
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(count[i][j]>1) {//2�� �̻� ���ִ�.
						int sumM=0;
						int sumS=0;
						int cnt=0;
						int odd=0,even=0;
						for(int k=0; k<fb.size(); k++) {
							if(fb.get(k).r==i && fb.get(k).c==j) {//���ִ°� ã��
								sumM+=fb.get(k).m;//���� ��
								sumS+=fb.get(k).s;//�ӷ� ��
								cnt++;//������ ���̾�� ����
								if(fb.get(k).d%2==0) {
									even++;
								}else {
									odd++;
								}
								fb.remove(k);
								k--;
							}
						}

						if(sumM<5) {//���� 5 �����̸� �� �ǳʶ�
							count[i][j]=0;
							
							continue;
						}
						int divideM=sumM/5;
						int divideS=sumS/cnt;
						int start=0;
						if(even==0 || odd==0){ //��� Ȧ�� �̰ų� ¦��
							start=0;
						}
						else {
							start=1;
						}
						int tmp=0;
						for(int d=start; d<8; d+=2) {
							fb.add(new fireBall(i,j,divideM,divideS,d));
							tmp++;
						}
						//count[i][j]=4;
					}
				}
			}
			K--;
			
		}
		int ans=0;
		for(int i=0; i<fb.size(); i++) {
			ans+=fb.get(i).m;
		}
		System.out.println(ans);
		
	}
	public static void print() {
		System.out.println("fire ball");
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println();
		
		System.out.println("count");
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(count[i]));
		}
		System.out.println();
	}
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
	int m;//����
	int d;//����
	int s;//�ӷ�
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