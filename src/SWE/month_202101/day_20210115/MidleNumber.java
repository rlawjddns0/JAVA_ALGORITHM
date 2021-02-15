package SWE.month_202101.day_20210115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MidleNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N;//테스트 케이스
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());//숫자 갯수 받기
		StringTokenizer st;
        int middleNumber=N/2;
        int arr[]=new int[N];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		System.out.println(arr[middleNumber]);
		
		
		
		

	}

}
