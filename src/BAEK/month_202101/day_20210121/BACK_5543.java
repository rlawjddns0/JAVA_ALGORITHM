package BAEK.month_202101.day_20210121;

import java.util.Scanner;

public class BACK_5543 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] set=new int[2];
		Scanner sc=new Scanner(System.in);
		int ham=2000;
		int veb=2000;
		for(int i=0; i<3; i++)
		{
			int x=sc.nextInt();
			if(x<ham)
				ham=x;
			
		}
		for(int i=0; i<2; i++)
		{
			int x=sc.nextInt();
			if(x<veb)
				veb=x;
		}
		System.out.println(ham+veb-50);
	}

}
