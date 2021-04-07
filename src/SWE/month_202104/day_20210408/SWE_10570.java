package SWE.month_202104.day_20210408;

import java.util.Scanner;

public class SWE_10570 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1; t<=T; t++) {
			int A=sc.nextInt();
			int B=sc.nextInt();
			int count=0;
			for(int i=A; i<=B; i++) {
				if(check(Integer.toString(i))) {
					if(((Math.sqrt(i))-(int)Math.sqrt(i))==0) {
						if(check(Integer.toString(((int)(Math.sqrt(i)))))) {
								count++;
						}
					}
				}
				
			}
			
			
			System.out.println("#"+t+" "+count);
			
			
			
			
			
		}
		
	}

	private static boolean check(String string) {
		
		if(string.length()==1)return true;
		
		boolean flag=true;
		for(int i=0, j=string.length()-1; i<string.length()/2;j--, i++) {
			if(string.charAt(i)!=string.charAt(j)) {
				flag=false;
				break;
			}
			
		}
		
		
		
		
		return flag;
	}

}
