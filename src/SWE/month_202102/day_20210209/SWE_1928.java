package SWE.month_202102.day_20210209;

import java.util.Arrays;
import java.util.Scanner;

public class SWE_1928 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		
		int TC=sc.nextInt();
		for(int t=1; t<=TC; t++) {
			boolean[] check=new boolean[11];
			String N=sc.next();
			int ans=0;
			int sum=0;
			int Snum=1;
			int tmp=Integer.parseInt(N);
			int tmp1=Integer.parseInt(N);
			while(true) {
				sum=0;
				//System.out.println(sum);
				//System.out.println(N);
				char[] ch=new char[N.length()];
				ch=N.toCharArray();
				//System.out.println(Arrays.toString(ch));
				for(int i=0;i<ch.length; i++) {
					//System.out.println(ch[0]-'1');
					check[ch[i]-'0']=true;
				}
				//System.out.println(Arrays.toString(check));
				
				
				for(int i=0; i<10; i++) {
					if(check[i])sum++;
				}
				if(sum==10) {
					break;
				}
			
				tmp=tmp1*Snum;
				N=Integer.toString(tmp);
				ans++;
				Snum++;
			}
			
			System.out.println("#"+t+" "+ans*tmp1);
		}
	}

}
