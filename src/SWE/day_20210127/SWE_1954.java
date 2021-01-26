package SWE.day_20210127;

import java.util.Arrays;
import java.util.Scanner;

public class SWE_1954 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		
		
		int[][] snail=new int[n][n];
		for(int i=0; i<n; i++)
			Arrays.fill(snail[i], 0);
		
		for(int i=0; i<n*n; i++) {
			for(int j=0; j<n; j++) {
				snail[i][j]=j+1;
			}
			for(int j=f)
		}
		
	}

}
