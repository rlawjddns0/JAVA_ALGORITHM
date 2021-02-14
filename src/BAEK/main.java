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
		//보통의 scaaner 방식
		
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
		
		
//		두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 
//
//		수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> number=new HashSet<Integer>();
		for(int i=0; i<10; i++) {
			number.add(Integer.parseInt(br.readLine())%42);
			
		}
		System.out.println(number.size());

	}

}
