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
		for(int i=0; i<N; i++)//�Է�
		{	
			st=new StringTokenizer(br.readLine()," ");
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		/*
		 * ���ٽ�
		 * compare(a,b)
		 * ���� a�� �� ũ�� ���� 1
		 * b�� �� ũ�� -1
		 * ������ 0
		 * 
		 */
		
		Arrays.sort(arr,(num1,num2)->{
			if(num1[1]==num2[1]) {//���� �� ��° ��Ұ� ������ 
				return Integer.compare(num1[0], num2[0]);//ù ���� ��ҷ� ��
			}
			
			return Integer.compare(num1[1], num2[1]);//�ƴϸ� �� ���� ��ҷ� ��
			
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
