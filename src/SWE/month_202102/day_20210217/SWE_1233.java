package SWE.month_202102.day_20210217;

import java.util.Scanner;

public class SWE_1233 {
	static int ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=10;
		for(int t=1; t<=T; t++) {
			ans=0;
			int N=sc.nextInt();
			
			if(N%2==0) {
				for(int i=1; i<=N; i++) {
					sc.nextLine();
				}
				System.out.println("-1");
			}
			else {
				for(int i=1; i<=N/2; i++) {
					String[] str=sc.nextLine().split(" ");
					char c=str[1].charAt(0);
					if(c=='+'||c=='-'||c=='*'||c=='/') {
						
					}
					else {
						ans=0;
					}
				}
				for(int i=N/2+1; i<=N; i++) {
					String[] str=sc.nextLine().split(" ");
					char c=str[1].charAt(0);
					if(c>='0' && c<='9') {
						
					}
					else {
						ans=0;
					}
				}
				System.out.println(ans);
			}
			
			
		}
	}

}
