package SWE.day_20210127;

import java.util.Arrays;
import java.util.Scanner;
/** 
 * 0:���� �ӵ� ����.
 * 1:����
 * 2:����
 * 
 * �ð��� ������ 1�ʾ� ���� �Է� ���� �������� �������� �������� Ȯ���ؼ� ���� �ӵ��� �Բ� �Ÿ��� ����
 * */
public class SWE_1940 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testCase=sc.nextInt();
		
		for(int t=0; t<testCase; t++) {
			int Command=sc.nextInt();
			int state=0;
			int v=0;//���� ������ �ӵ� ����
			int tmpV=0;//���� �ӵ� ����
			int dis=0;//�Ÿ�
			for(int i=0; i<Command; i++) {
				state=sc.nextInt();
				if(state!=0) {//0�̸� �Է� ����
					v=sc.nextInt();
				}
				
				if(state==0)//����
				{
					dis+=v*1;//�ӵ��� �����ϴϱ� �Ÿ��� �Ȱ��� �þ��.
				}
				else if(state==1) {//����
					v+=tmpV;;
					dis+=v*1;
					tmpV=v;
				}
				else {//����
					if(v>tmpV) {//���� �ӵ����� ���� �ӵ��� �� ũ��
						v=0;//�ӵ��� 0
					}
					else
					{
						v=tmpV-v;//���� �ӵ����� �ӵ� ���̰�
						dis+=v*1;//�� �ӵ��� �Ÿ� ���
						tmpV=v;//���� �ӵ� ����
					}
					
				}
				
			}
			System.out.println("#"+(t+1)+" "+dis);
			
			
		}
		
		
	}

}
