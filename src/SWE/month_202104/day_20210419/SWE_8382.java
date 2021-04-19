package SWE.month_202104.day_20210419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_8382 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			
			//������ �������� �ű��
			x2-=x1;
			y2-=y1;
			
			//����� �����
			x2=Math.abs(x2);
			y2=Math.abs(y2);
			
			if(x2==y2) {
				//2 ��ǥ�� ������ ���簢��
				System.out.println("#"+t+" "+x2*2);
			}else {
				
				int sum=Math.min(x2, y2)*2;//�� ��ǥ�� �ּҰ� ���ؼ� ���簢����ŭ ���� ���ϱ�
				int tmp=Math.abs(y2-x2);//�� ��ǥ�� ���� ���ϱ�
				if(tmp%2==0) {//�� ������ ���� ¦����
					sum+=tmp*2;
					System.out.println("#"+t+" "+sum);
				}else {//Ȧ����
					if(tmp==1) {
						System.out.println("#"+t+" "+(sum+1));
					}else {
						System.out.println("#"+t+" "+(sum+(((tmp-1)*2)+1)));
					}
				}
			}
			
			
		}
	
	
	}

}
