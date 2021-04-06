package SWE.month_202104.day_20210406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SWE_10912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int[] alpha=new int[26];
			char[] input=sc.next().toCharArray();
			StringBuffer sb=new StringBuffer();
			
			
			for(int i=0;i<input.length; i++) {
				alpha[input[i]-'a']++;
			}
			
			for(int i=0; i<alpha.length; i++) {
				if(alpha[i]>0) {
					alpha[i]=alpha[i]%2;
				}
			}
			
			ArrayList<Character> ch=new ArrayList<>();
			
			for(int i=0; i<alpha.length; i++) {
				if(alpha[i]>0) {
					char tmp= (char) (i+'a');
					ch.add(tmp);
				}
			}
			if(ch.size()==0) {
				System.out.println("#"+t+" "+"Good");
			}else {
				Collections.sort(ch);
				for(int i=0; i<ch.size(); i++) {
					sb.append(ch.get(i));
				}
				System.out.println("#"+t+" "+sb);
			}
			
		}

	}

}
