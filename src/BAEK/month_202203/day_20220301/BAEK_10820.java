package BAEK.month_202202.day_2022022;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BAEK_10820 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str=br.readLine();
			
			if("".equals(str) || str==null)break;
			int small=0;
			int big=0;
			int num=0;
			int empty=0;
			
			
			
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)==' ')
				{
					empty++;
				}else if(str.charAt(i)-'0'>=0 && str.charAt(i)-'0'<=9) {
					num++;
				}else if(str.charAt(i)>='a' && str.charAt(i)<='z') {
					small++;
				}else {
					big++;
				}
			}
			
			
			System.out.println(small+" "+big+" "+num+" "+empty);
			
			
			
		}
	}

}
