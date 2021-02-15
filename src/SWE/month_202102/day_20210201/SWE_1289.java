package SWE.month_202102.day_20210201;

import java.util.Arrays;
import java.util.Scanner;

public class SWE_1289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner sc=new Scanner(System.in);
		int testCase=sc.nextInt();
		
		for(int t=0; t<testCase; t++) {
			String bit=sc.next();
			char[] BIT=new char[bit.length()];
			char[] temp=new char[bit.length()];
			Arrays.fill(temp, '0');
			BIT=bit.toCharArray();
			boolean flag=false;//1일 떄 먼저 시작
			int count=0;
			int check=0;
			while(true) {
				
				if(check==bit.length()) {
					break;
				}
				else {
					int start=0;
					for(int i=0; i<bit.length(); i++) {
						if(BIT[i]!=temp[i]) {
							start=i;
							break;
						}
					}
					if(flag==false) {
						for(int i=start; i<bit.length(); i++) {
								temp[i]='1';
						}
						count++;
						flag=true;
					}
					else if(flag==true) {
						for(int i=start; i<bit.length(); i++) {
							temp[i]='0';
						}
						count++;
						flag=false;
					}
					for(check=0; check<bit.length(); check++)
					{
						if(BIT[check]!=temp[check]) {
							break;
						}
					}
				}
			}
			System.out.println("#"+(t+1)+" "+count);
			
			
			
			
			
			
			
			
		}
	}

}
