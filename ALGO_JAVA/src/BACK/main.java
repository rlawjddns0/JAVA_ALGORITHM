package BACK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
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
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int Test_Case=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		for(int i=0; i<Test_Case; i++) {
			st=new StringTokenizer(br.readLine()," ");
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
			sb.append('\n');
		}
		
		
		System.out.println(sb);
		

	}

}
