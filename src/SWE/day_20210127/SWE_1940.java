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
			int state=0;;
			int v=0;
			int tmpV=0;
			int dis=0;//�Ÿ�
			for(int i=0; i<Command; i++) {
				state=sc.nextInt();
				if(state!=0) {
					v=sc.nextInt();
				}
				
				if(state==0)//����
				{
					dis+=v*1;
				}
				else if(state==1) {//����
					v+=tmpV;;
					dis+=v*1;
					tmpV=v;
				}
				else {//����
					if(v>tmpV) {
						v=0;
						dis+=v*1;
						tmpV=v;
					}
					else
					{
						v=tmpV-v;
						dis+=v*1;
						tmpV=v;
					}
					
				}
				
			}
			System.out.println("#"+(t+1)+" "+dis);
			
			
		}
		
		
	}

}
