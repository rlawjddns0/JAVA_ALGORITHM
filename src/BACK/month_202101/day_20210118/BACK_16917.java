package BACK.month_202101.day_20210118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_16917 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine()," ");
		
		int YANG=Integer.parseInt(st.nextToken());//��� ����
		int HOO=Integer.parseInt(st.nextToken());//�Ķ��̵� ����
		int BAN=Integer.parseInt(st.nextToken());//�ݹ� ����
		int x=Integer.parseInt(st.nextToken());//��� ����
		int y=Integer.parseInt(st.nextToken());//�Ķ��̵� ����
		
		int tmp=2*BAN;
		int sum=0;
		if((HOO+YANG)<=tmp) {
			System.out.println(HOO*y+YANG*x);
		}
		else {
			int max=Math.max(x, y);
			int min=Math.min(x, y);
			int abs=Math.abs(x-y);
			int temp1=tmp*max;//�ݹ����� �� ���
			
			int temp2=0;
			temp2=tmp*min+((x<y)?(abs*HOO):(abs*YANG));//�ݹ����� ��� ������ �Ķ��̵� �Ǵ� ������� ä�� ��
			if(temp1<temp2)//2�� ���ؼ� ���
				System.out.println(temp1);
			else
				System.out.println(temp2);
			
			
			
		}
		
		
		
	}

}
