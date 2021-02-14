package BAEK.month_202101.day_20210120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_10703 {

	public static void main(String[] args) throws IOException, IndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine(), " ");
		
		int R=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		
		StringBuilder[] MET=new StringBuilder[R];
		
		

		for(int i=0; i<R; i++) {
			StringBuilder tp=new StringBuilder(br.readLine());
			MET[i]=tp;
		}
		
		
		
		int y=0; //
		int x=0;//��� �عٴ�
		for(int i=R-1; i>=0; i--)//��� �� �� ��ġ�� ã�� ����
		{
			if(MET[i].indexOf("X")!=-1) {
				y=MET[i].indexOf("X");
				x=i;
				break;
			}
		}
		int min=10000;//�ּڰ�
		//int count=0;
		
		int tmp=0;
		for(int i=0;i<S;i++) {
	         int count = 0;
	         int state = 0;
	         for(int j=0;j<R;j++) {//���������� ������ ���� Ž��
	            if(MET[j].charAt(i) == 'X') {//��� ������ state=1
	               state = 1;
	               count = 0;
	            }
	            else if(MET[j].charAt(i) == '#') {//���� ������ break�� ���� ���Դ� �������� �˻�
	               break;
	            }
	            if(state == 1) {//�� Ž������ ��� ������ 
	               if(MET[j].charAt(i) == '.') {//���簡 ����� ī��Ʈ
	                  count++;
	               }
	            }
	         }
	         if(count >0) {//�������� ������ 1�� �̻�
	            if(min > count) {//���� ���� �������� min������ ������ min�� ����
	               min = count;
	            }
	         }
	      }
		int count=min;
		for(int i=x; i>=0; i--) {//�Ʊ� ã�� ��� �ٴں��� ����
			for(int j=0; j<S; j++) {
				
				
				if(MET[i].charAt(j)=='X') {//��� �� �κк���
					if(i+count<R) {//�迭 �Ѿ�� �ȵ�
						MET[i+count].setCharAt(j, 'X');//�� X�� ��ġ���� �ּҰŸ��� ���� ��ġ�� X ����
						MET[i].setCharAt(j, '.');//���� X�� ã�Ҵ� ��ġ�� . ����
					}
					
					
				}
			}
		}

		
		//StringBuffer sb=new StringBuffer();
		for(int i=0; i<R; i++)//���ۿ� ���پ� ����
		{
			//sb.append(MET[i]).append("\n");
			System.out.println(MET[i]);
		}
		
		//System.out.println(sb);
	
	}

}
