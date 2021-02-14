package BACK.month_202101.day_20210122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BACK_11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N=Integer.parseInt(br.readLine());//»ç¶÷ ¼ö
		st=new StringTokenizer(br.readLine()," ");
		
		//int[] order=new int[N];
		int[] minute=new int[N];
		
		for(int i=0; i<N; i++)
			minute[i]=Integer.parseInt(st.nextToken());
		
		int sum=0;
		Arrays.sort(minute);
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<i+1; j++ ) {
				sum+=minute[j];
			}
		}
		
		
		System.out.println(sum);
		
		
		

	}

}
