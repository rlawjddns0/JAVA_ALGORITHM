package BAEK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
//BACK_10950
public class main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		Scanner scanner= new Scanner(System.in);
//		int Test_Case_num=0;
//		int [][] array;
//		Test_Case_num=scanner.nextInt();
//		array=new int[Test_Case_num][2];
//		for(int i=0; i<Test_Case_num; i++) {
//			for(int j=0; j<2; j++) {
//				array[i][j]=scanner.nextInt();
//			}
//		}
//		
//		for(int i=0; i<Test_Case_num; i++) {
//			System.out.println(array[i][0]+ array[i][1]);
//		}
		//������ scaaner ���
		
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		
//		int Test_Case=Integer.parseInt(br.readLine());
//		
//		StringTokenizer st;
//		StringBuilder sb=new StringBuilder();
//		
//		for(int i=0; i<Test_Case; i++) {
//			st=new StringTokenizer(br.readLine()," ");
//			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
//			sb.append('\n');
//		}
//		
//		
//		System.out.println(sb);
		
		
//		�� �ڿ��� A�� B�� ���� ��, A%B�� A�� B�� ���� ������ �̴�. ���� ���, 7, 14, 27, 38�� 3���� ���� �������� 1, 2, 0, 2�̴�. 
//
//		�� 10���� �Է¹��� ��, �̸� 42�� ���� �������� ���Ѵ�. �� ���� ���� �ٸ� ���� �� �� �ִ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> number=new HashSet<Integer>();
		for(int i=0; i<10; i++) {
			number.add(Integer.parseInt(br.readLine())%42);
			
		}
		System.out.println(number.size());

	}

}
