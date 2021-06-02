package SWE.month_202106.day_20210601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_11856 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		
		
		for(int t=1; t<=TC; t++) {
			char[] S=br.readLine().toCharArray();
			if(S.length!=4) {
				
				System.out.println("#"+t+" "+"No");
				continue;
			}
			
			int[] check=new int[26];
			for(int i=0; i<S.length; i++) {
				check[S[i]-'A']++;
			}
			int cnt=0;
			for(int i=0; i<26; i++) {
				if(check[i]==2) {
					cnt++;
				}
			}
			
			if(cnt==2) {
				System.out.println("#"+t+" "+"Yes");
			}else {
				
				System.out.println("#"+t+" "+"No");
			}
			
			
			
			
		}
	}

}
