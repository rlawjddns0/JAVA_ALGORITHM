package BACK.month_202101.day_20210121;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BACK_11651 {
//	public static void print(int[][] arr, int N) {
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<2; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("C:\\Users\\rlawj\\git\\repository\\ALGO_JAVA\\src\\input\\Input1.txt"));
		Scanner sc=new Scanner(System.in);
		StringTokenizer st;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[][] arr=new int[N][2];
		for(int i=0; i<N; i++)//입력
		{	
			st=new StringTokenizer(br.readLine()," ");
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		/*
		 * 람다식
		 * compare(a,b)
		 * 만약 a가 더 크면 리턴 1
		 * b가 더 크면 -1
		 * 같으면 0
		 * 
		 */
		
		Arrays.sort(arr,(num1,num2)->{
			if(num1[1]==num2[1]) {//만약 두 번째 요소가 같으면 
				return Integer.compare(num1[0], num2[0]);//첫 번쨰 요소로 비교
			}
			
			return Integer.compare(num1[1], num2[1]);//아니면 둠 번쨰 요소로 비교
			
		});
		
		//print(arr,N);
		
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<N; i++)
		{
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		System.out.println(sb);
		
		
		
		
	}

}
