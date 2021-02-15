package SWE.month_202101.day_20210125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_1961 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase=Integer.parseInt(br.readLine());
		for(int t=0; t<testCase; t++) {
			int N=Integer.parseInt(br.readLine());
			int[][] arr=new int[N][N];
			
			for(int i=0; i<N; i++)
			{
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] Rotation_90=Rotation(arr,N);
			int[][] Rotation_180=Rotation(Rotation_90,N);
			int[][] Rotation_270=Rotation(Rotation_180,N);
			
			
			System.out.println("#"+(t+1));
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<N; j++) {
					System.out.print(Rotation_90[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(Rotation_180[i][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(Rotation_270[i][j]);
				}
				System.out.println();
			}
			
			
			
			
			
			
			
			
			
		}

	}
	public static int[][] Rotation(int[][] arr,int N) {
		int[][] temp=new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				temp[i][j]=arr[N-j-1][i];//90도씩 돌리기
				
			}
		}
		return temp;
		
		
		
	}

}
