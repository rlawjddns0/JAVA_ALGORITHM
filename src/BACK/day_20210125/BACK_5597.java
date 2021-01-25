package BACK.day_20210125;

import java.util.Arrays;
import java.util.Scanner;

public class BACK_5597 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] flag=new boolean[30];
		Scanner sc=new Scanner(System.in);
		
		for(int i=0; i<28; i++) {
			int n=sc.nextInt();
			flag[n-1]=true;
		}
		
		for(int i=0; i<30; i++)
			if(!flag[i])
				System.out.println(i+1);
		
		

	}

}
