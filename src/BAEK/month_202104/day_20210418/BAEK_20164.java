package BAEK.month_202104.day_20210418;

import java.util.Scanner;

public class BAEK_20164 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		count(str);
		dfs(str,count(str));
		
		System.out.println(min+" "+max);
		
		
		
	}
	private static int count(String str) {
		int cnt=0;
		for(int i=0; i<str.length(); i++) {
			if((str.charAt(i)-'0')%2==1) {
				cnt++;
			}
		}
		return cnt;
	}
	static int ans=0;
	static int cnt=0;
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	private static void dfs(String str, int cnt) {
		if(Integer.parseInt(str)<10) {
			max=Math.max(max, cnt);
			min=Math.min(min, cnt);
			return;
		}
		
		if(Integer.parseInt(str)<100) {
			
			
			int tmp=(str.charAt(0)-'0')+(str.charAt(1)-'0');
			dfs(Integer.toString(tmp),cnt+count(Integer.toString(tmp)));
			return;
		}
		
		
		for(int i=1; i<str.length()-1; i++) {
			for(int j=i+1; j<str.length(); j++) {
				String tmp1=str.substring(0,i);
				String tmp2=str.substring(i,j);
				String tmp3=str.substring(j,str.length());
			//	System.out.println(tmp1+" "+tmp2+" "+tmp3);
				int num=Integer.parseInt(tmp1)+Integer.parseInt(tmp2)+Integer.parseInt(tmp3);
				dfs(Integer.toString(num),cnt+count(Integer.toString(num)));
				
			}
		}
		
		
		
	
	
	}

}
