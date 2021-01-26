package SWE.day_20210125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/** 
 * 스도쿠 검증 풀이중 
 * 
 * 
 * 
 * */


public class SWE_1974 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase=Integer.parseInt(br.readLine());
		
		
		for(int t=0; t<testCase; t++) {
			
			int[][] arr=new int[9][9];
			
			for(int i=0; i<9; i++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0; j<9; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			boolean flag=true;
			
			
			for(int i=0; i<9; i++) {
				Arrays.sort(arr[i]);
				int sum=0;
				for(int j=0; j<9; j++) {
					sum+=arr[i][j];
					
				}
				//System.out.println(sum);
				if(sum!=45) {
					flag=false;
					break;
				}
				
				
				
			}
			System.out.print("#"+(t+1)+" ");
			if(flag) {
				System.out.print("1");
			}
			else
				System.out.print("0");
			
			System.out.println();
			
			
		}
	}

}
