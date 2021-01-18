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
 
			st = new StringTokenizer(br.readLine()," "); // �л� �� �� ���� �Է�
			
			
			int N = Integer.parseInt(st.nextToken());	//�л� �� 
			arr = new int[N];
			
			double sum = 0;	// ���� ���� �� ���� 
			
			// ���� �Էºκ� 
			for(int j = 0 ; j < N ; j++) {
				int val = Integer.parseInt(st.nextToken());	// ���� ����
				arr[j] = val;
				sum += val;	// ���� ���� �� 
			}
			
			double mean = (sum / N) ;
			double count = 0; // ��� �Ѵ� �л� �� ���� 
			
			// ��� �Ѵ� �л� ���� ã�� 
			for(int j = 0 ; j < N ; j++) {
				if(arr[j] > mean) {
					count++;
				}
			}
			
			System.out.printf("%.3f%%\n",(count/N)*100);
			
	
		}
	}

}
