package BAEK.month_202101.day_20210125;

import java.util.Scanner;

public class BACK_10707 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();//x사의 1리터탕 요금
		int B=sc.nextInt();//y사의 기본 요금
		int C=sc.nextInt();//사용량의 상한
		int D=sc.nextInt();//y사의 1리터당 추가요금 D
		int P=sc.nextInt();//한달간 수도양
		
		int X=P*A;//X사를 이용했을때 요금
		int Y=0;
		if(C>P) {
			 Y=B;
		}
		else {
			int sum=B;
			for(int i=0; i<P-C; i++)
				sum+=D;
			Y=sum;
			
		}
		
		
		
		if(X>Y) {
			System.out.println(Y);
		}
		else
		{
			System.out.println(X);
		}
		
		
		
		
		
		
		
		
	}

}
