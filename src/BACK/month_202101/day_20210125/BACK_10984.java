package BACK.month_202101.day_20210125;

import java.util.Scanner;

public class BACK_10984 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int sum1=0;
		int sum2=0;
		for(int i=0; i<4; i++)
		{
			sum1+=sc.nextInt();
		}
		
		for(int i=0; i<4; i++)
			sum2+=sc.nextInt();
		
		
		if(sum1<sum2)
			System.out.println(sum2);
		else if(sum1> sum2)
			System.out.println(sum1);
		else
			System.out.println(sum1);
	}

}
