package BAEK.month_202101.day_20210118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BACK_16923 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[] check=new int[26];
		String arr=br.readLine();
		char[] s=new char[26];
		
		
		if(arr.length()<26) {//26�ڰ� �� ������ 
			for(int i=0; i<arr.length(); i++) {
				check[(arr.charAt(i))-'a']=1;
			}
			int temp = 97;
			for(int i=0; i<check.length; i++)
				if(check[i]==0)
				{
					temp+=i;
					break;
				}
			System.out.println(arr+(char)temp);
		
			
		}
		else {//26�ڰ� �� ������
			
			
			for(int i=0; i<arr.length(); i++) {
				s[i]=(arr.charAt(i));
			}
			for(int i=0; i<arr.length(); i++) {
				check[arr.charAt(i)-'a']=i;
			}
			
//			for(int i=0; i<arr.length(); i++) {
//				System.out.print(check[i]+" ");
//				
//			}
//			System.out.println();
//			for(int i=0; i<arr.length(); i++) {
//				System.out.print(s[i]);
//				
//			}
//			System.out.println();


		
			L:for (int j = 25; j >= 0; j--)	//���ڿ��� �ں��� Ž��
				for (int k = s[j]- 'a'+1; k < 26; k++) {	//�ش� ������ �� ���� ���ڵ��� Ž��
					if (check[s[j]-'a'] < check[k]) {	
		               //���� �� ������ ���ĺ��� ��ġ�� ���� ���ں��� �տ� ��ġ�Ѵٸ�
//						System.out.println(check[s[j]-'a']);
//						s[check[s[j]-'a']] = (char)(k + 'a');	//�� ���ڷ� ���� ���ڸ� ��ü�ϰ�
//						System.out.println(check[s[j]-'a']+1);
//						s[check[s[j]-'a']+1] = '\0';	//���� ���ڸ� null���ڷ�
						s[j] = (char)(k + 'a');	//�� ���ڷ� ���� ���ڸ� ��ü�ϰ�
						s[j + 1] = '\0';	
						break L;
					}
				}
			
			
			
			boolean flag=true;
			for(int i=0; i<s.length; i++) {
				if(s[i]=='\0')
				{
					flag=false;
					break;
				}
					
			}
			
			if(flag) {
				System.out.println("-1");
			}
			else
			{
				for(int i=0; i<26; i++) {
					if(s[i]=='\0')
						break;
					System.out.print(s[i]);
						
				}
			}
			
			
		
		}
	}

		
	
	

}


