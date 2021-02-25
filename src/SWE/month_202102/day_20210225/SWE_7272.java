package SWE.month_202102.day_20210225;

import java.util.Arrays;
import java.util.Scanner;

public class SWE_7272 {
	static char[] check1= {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};//구멍이 없는거
	static char[] check2= {'A','D','O','P','Q','R'};
	static char check3='B';
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int t=1; t<=TC; t++) {
			char[] ch1=sc.next().toCharArray();
			char[] ch2=sc.next().toCharArray();
			if(ch1.length!=ch2.length) {
				System.out.println("#"+t+" "+"DIFF");
				continue;
			}
			for(int i=0; i<check1.length; i++) {
				for(int j=0; j<ch1.length; j++) {
					if(check1[i]==ch1[j])ch1[j]='&';
					if(check1[i]==ch2[j])ch2[j]='&';
				}
			}
			for(int i=0; i<check2.length; i++) {
				for(int j=0; j<ch1.length; j++) {
					if(check2[i]==ch1[j])ch1[j]='%';
					if(check2[i]==ch2[j])ch2[j]='%';
				}
			}
			
			for(int j=0; j<ch1.length; j++) {
				if(check3==ch1[j])ch1[j]='@';
				if(check3==ch2[j])ch2[j]='@';
			}
			

			if(String.valueOf(ch1).equals(String.valueOf(ch2))) {
				System.out.println("#"+t+" "+"SAME");
			}
			else {
				System.out.println("#"+t+" "+"DIFF");
			}

		}
		
		
	}

}
