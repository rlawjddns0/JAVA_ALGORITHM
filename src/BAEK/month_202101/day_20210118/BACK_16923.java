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
		
		
		if(arr.length()<26) {//26자가 다 없을때 
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
		else {//26자가 다 있을때
			
			
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


		
			L:for (int j = 25; j >= 0; j--)	//문자열의 뒤부터 탐색
				for (int k = s[j]- 'a'+1; k < 26; k++) {	//해당 글자의 뒤 순서 글자들을 탐색
					if (check[s[j]-'a'] < check[k]) {	
		               //만약 뒤 순서의 알파벳의 위치가 현재 글자보다 앞에 위치한다면
//						System.out.println(check[s[j]-'a']);
//						s[check[s[j]-'a']] = (char)(k + 'a');	//그 글자로 현재 글자를 교체하고
//						System.out.println(check[s[j]-'a']+1);
//						s[check[s[j]-'a']+1] = '\0';	//다음 글자를 null문자로
						s[j] = (char)(k + 'a');	//그 글자로 현재 글자를 교체하고
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


