package BAEK.month_202101.day_20210126;

import java.util.Scanner;

/** 
 * 
 * �Է�
ù° �ٿ� ����� ������ ���̿� ������ ���̰� ���ʷ� �־�����.
 ��° �ٿ� ������ ������ �־�����. 
 ����� ������ ���̿� ������ ����, ������ ������ ��� 100������ �ڿ����̴�. 
 �̾� �� �ٿ� �ϳ��� ������ ��ġ�� �־�����. 
 ������ ��ġ�� �� ���� �ڿ����� ǥ�õȴ�. 
 ù° ���� ������ ��ġ�� ������ ��Ÿ���µ�, 1�� ����� ����, 2�� ����� ����, 3�� ����� ����, 4�� ����� ���ʿ� ������ ������ �ǹ��Ѵ�. 
 ��° ���� ������ ����� ���� �Ǵ� ���ʿ� ��ġ�� ��� ����� ���� ���κ����� �Ÿ��� ��Ÿ����, ������ ����� ���� �Ǵ� ���ʿ� ��ġ�� ��� ����� ���� ���κ����� �Ÿ��� ��Ÿ����. 
 ������ �ٿ��� �������� ��ġ�� ������ ��ġ�� ���� ������� �־�����. 
 ������ ��ġ�� �������� ��ġ�� ����� �������� �� �� ����.
 * 
 * 
 * ���
	ù° �ٿ� �������� ��ġ�� �� ���� ������ �ִ� �Ÿ��� ���� ����Ѵ�.
 * */

public class BACK_2564 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int num=sc.nextInt();//���� ����
		int[][] arr=new int[num][2];
		for(int i=0; i<num; i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		
		int[] dongGun =new int[2];
		dongGun[0]=sc.nextInt();
		dongGun[1]=sc.nextInt();
		
		
//		for(int i=0; i<num; i++) {
//			for(int j=0; j<2; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println(dongGun[0]);
//		System.out.println(dongGun[1]);
//		
		int result=0;
		if(dongGun[0]==1) {//��
			for(int i=0; i<num; i++) {
				if(arr[i][0]==1) {
					result+=Math.abs(arr[i][1]-dongGun[1]);
				}
				else if(arr[i][0]==2){
					int a=M+arr[i][1]+dongGun[1];//���� ����
					int b=M+(N-arr[i][1])+(N-dongGun[1]);//������ ����
					result+=Math.min(a, b);
				}
				else if(arr[i][0]==3) {
					result+=dongGun[1]+arr[i][1];
				}
				else {
					result+=(N-dongGun[1]+arr[i][1]);
				}
			}
		}
		else if(dongGun[0]==2) {//��
			for(int i=0; i<num; i++) {
				if(arr[i][0]==1) {
					int a=M+arr[i][1]+dongGun[1];//���� ����
					int b=M+(N-arr[i][1])+(N-dongGun[1]);//������ ����
					result+=Math.min(a, b);
				}
				else if(arr[i][0]==2){//��
					result+=Math.abs(arr[i][1]-dongGun[1]);
				}
				else if(arr[i][0]==3) {//��
					result+=dongGun[1]+(M-arr[i][1]);					
				}
				else {
					result+=N-dongGun[1]+ M-arr[i][1];
				}
			}
			
		}
		else if(dongGun[0]==3) {//��
			for(int i=0; i<num; i++) {
				if(arr[i][0]==1) {
					result+=dongGun[1]+arr[i][1];
				}
				else if(arr[i][0]==2){
					result+=M-dongGun[1]+arr[i][1];
				}
				else if(arr[i][0]==3) {
					result+=Math.abs(dongGun[1]-arr[i][1]);
				}
				else {
					int a=N+arr[i][1]+dongGun[1];//���Y
					int b=N+(M-arr[i][1])+(M-dongGun[1]);//�Ʒ��� ����
					result+=Math.min(a, b);
				}
			}
		}
		else {//��
			for(int i=0; i<num; i++) {
				if(arr[i][0]==1) {
					result+=dongGun[1]+N-arr[i][1];
				}
				else if(arr[i][0]==2){
					result+=M-dongGun[1]+N-arr[i][1];
				}
				else if(arr[i][0]==3) {
					int a=N+arr[i][1]+dongGun[1];//���Y ����
					int b=N+(M-arr[i][1])+(M-dongGun[1]);//�Ʒ��� ����
					result+=Math.min(a, b);
				}
				else {
					result+=Math.abs(dongGun[1]-arr[i][1]);
				}
			}
		}

		
		
		
		
		
		
		System.out.println(result);
		
		
		
		
		
	}

}
