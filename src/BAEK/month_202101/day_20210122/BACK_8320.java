package BAEK.month_202101.day_20210122;

import java.util.Scanner;

public class BACK_8320 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int count=0;
		
		for(int i=1; i<=N; i++)
		{
			for(int j=i; j<=N; j++) {
				//System.out.println(i*j);
				if(i*j<=N)
					count++;
				else break;
			}
		}
		System.out.println(count);
		
	}

}
