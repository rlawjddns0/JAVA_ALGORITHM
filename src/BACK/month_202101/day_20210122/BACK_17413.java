package BACK.month_202101.day_20210122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BACK_17413 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();//���ٷ� �Է� �ޱ�
		char[] arr=new char[str.length()];
		arr=str.toCharArray();//�ٽ� char������ �ϳ��� �迭�� ����
		
		
//		for(int i=0; i<str.length(); i++)
//			System.out.println(arr[i]);
		boolean flag=false;//< �������� �ȳ�������
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<arr.length; i++) {
			Stack<Integer> stack=new Stack<Integer>();
			if(arr[i]=='<')//�����谡 ������ ��
			{
				flag=true;
			}
			else if(arr[i]=='>')//���谡 ������ ���� 
			{
				flag=false;
			}
			else if(flag==false&&arr[i]>='a'&& arr[i]<='z'|| flag==false &&arr[i]>='0'&& arr[i]<='9') {//���ڸ�
				//int tmpi=i;//6
				while(i<arr.length && arr[i]!=' ' &&arr[i]!='<')//�����̳� < ������ ������ ���ÿ� ����ִ´�
				{
					stack.push((int)(arr[i]));
					i++;
				}
				
				while(stack.size()!=0) {//���� �� pop
					int tp=stack.pop();
					System.out.print((char)(tp));//������ LIFO�� ���ڰ� �Ųٷ� ���´�
					
				}
				if(i<arr.length && arr[i]=='<') { //< ������ flag true <asa>ccc<asa>
					flag=true;
					
				}
			}
			
			
			
			if(flag==true&&i<arr.length) {//���谡 ���� �κ� ���Ĵ� �׳� ��� ���ָ� �ȴ�
				System.out.print(arr[i]);
			}
			else if(flag==false&&i<arr.length)//���� ���ڸ� ����ϴ� �κ�<as>asdf adads<asdf>
			{
				System.out.print(arr[i]);
			}
						
			
			
			
			
		}
			
	}

}
