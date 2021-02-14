package BAEK.month_202102.day_20210203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BACK_16931 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] arr=new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int result=2*N*M;//도형을 위, 아래 에서 봤을때 면적 더하기
		
		int sum=0;
		for(int j=0; j<N; j++) {
			for(int i=0; i<M; i++) {
				int temp=arr[j][i];
				for(int d=0; d<4; d++) {
					int nx=i+dx[d];
					int ny=j+dy[d];
					if(nx>=M || nx<0 ||ny>=N || ny<0) {//범위를 벗어나면
						sum+=temp;
						//System.out.println(sum);
						continue;
					}
					else {
						if((temp-arr[ny][nx])>0) {
							sum+=(temp-arr[ny][nx]);
						}
					}
					
				}
			}
		}
		
		System.out.println(sum+result);
		
		
		
		
		
		
		
		
	}

}
