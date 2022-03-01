package BAEK.month_202202.day_2022022;

import java.util.Scanner;

public class BAEK_1212 {
	static String[] str= {"000","001","010","011","100","101","110","111"};
	
	
	public static void main(String[] args) {
		String num;
		Scanner sc=new Scanner(System.in);
		num=sc.nextLine();
		if(num.equals("0")) {
			System.out.println(0);
			System.exit(0);
		}
		StringBuffer sb=new StringBuffer();
		
		for(int i=0; i<num.length(); i++) {
			sb.append(str[num.charAt(i)-'0']);
		}
		int tmp=0;
		boolean flag=true;
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i)=='0' && flag) {
				tmp++;
			}else if(sb.charAt(i)=='1') {
				flag=false;
			}
			if(!flag)break;
		}
		System.out.println(sb.substring(tmp, sb.length()));
		
		
	}
}
