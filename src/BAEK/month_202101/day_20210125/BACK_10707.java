package BAEK.month_202101.day_20210125;

import java.util.Scanner;

public class BACK_10707 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int A=sc.nextInt();//x���� 1������ ���
		int B=sc.nextInt();//y���� �⺻ ���
		int C=sc.nextInt();//��뷮�� ����
		int D=sc.nextInt();//y���� 1���ʹ� �߰���� D
		int P=sc.nextInt();//�Ѵް� ������
		
		int X=P*A;//X�縦 �̿������� ���
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
