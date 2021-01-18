package BACK.day_20210117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bronze1_4344 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));//input
//		StringBuffer sb=new StringBuffer();
//		
//		Scanner scanner=new Scanner(System.in);
//		int testCase=scanner.nextInt();
//		int arr[]=null;
//		DecimalFormat form = new DecimalFormat("##.####");
//		while(testCase!=0) {
//			int num=scanner.nextInt();
//			float sum=0;
//			arr=new int[num];
//			for(int i=0; i<num; i++)
//			{
//				arr[i]=scanner.nextInt();
//				sum+=arr[i];
//			}
//			
//			float count=0;
//			for(int i=0; i<num; i++) {
//				if(arr[i]>sum/num)
//					count++;
//			}
//			
//			
//			sb.append(String.format("%.3f", (count/(float)num)*100)).append('%').append('\n');
//			testCase--;
//		}
//		
//		System.out.println(sb);
//		
//		
//
//	}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr;
		
		int testcase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i = 0 ; i < testcase ; i++) {
 
			st = new StringTokenizer(br.readLine()," "); // 학생 수 및 성적 입력
			
			
			int N = Integer.parseInt(st.nextToken());	//학생 수 
			arr = new int[N];
			
			double sum = 0;	// 성적 누적 합 변수 
			
			// 성적 입력부분 
			for(int j = 0 ; j < N ; j++) {
				int val = Integer.parseInt(st.nextToken());	// 성적 저장
				arr[j] = val;
				sum += val;	// 성적 누적 합 
			}
			
			double mean = (sum / N) ;
			double count = 0; // 평균 넘는 학생 수 변수 
			
			// 평균 넘는 학생 비율 찾기 
			for(int j = 0 ; j < N ; j++) {
				if(arr[j] > mean) {
					count++;
				}
			}
			
			System.out.printf("%.3f%%\n",(count/N)*100);
			
	
		}
	}

}
