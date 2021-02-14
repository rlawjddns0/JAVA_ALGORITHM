package BACK.month_202102.day_20210207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BACK_16927 {
	static int[][] arr;
	static int min;
	static int R;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		min=Math.min(M, N)/2;//어디까지 들어갈지
		arr=new int[N][M];
		for(int i=0; i<N; i++) {
			StringTokenizer st1=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				arr[i][j]=Integer.parseInt(st1.nextToken());
			}
		}
		rotation(0,N,M);
		for(int i=0; i<N; i++) {
			for (int s : arr[i]) {
				System.out.print(s+" ");
			}
			System.out.println();
		}
	}
	
	
	private static void rotation(int start, int N, int M ) {
		
		if(start==min) {
			return;
		}
		
		Queue<Integer> q=new LinkedList<Integer>();
		
		for(int i=start; i<M; i++) {
			q.offer(arr[start][i]);
		}
		for(int i=start+1; i<N; i++) {
			q.offer(arr[i][M-1]);
		}
		for(int i=M-2; i>=start; i--) {
			q.offer(arr[N-1][i]);
		}
		
		for(int i=N-2; i>=start+1; i--) {
			q.offer(arr[i][start]);
		}
		
		
		
		for(int i=0; i<R; i++) {
			q.offer(q.poll());
		}
		
		
		for(int i=start; i<M; i++) {
			arr[start][i]=q.poll();
		}
		for(int i=start+1; i<N; i++) {
			arr[i][M-1]=q.poll();
		}
		for(int i=M-2; i>=start; i--) {
			arr[N-1][i]=q.poll();
		}
		for(int i=N-2; i>=start+1; i--) {
			arr[i][start]=q.poll();
		}
		
		rotation(start+1,N-1,M-1);
	}

}
