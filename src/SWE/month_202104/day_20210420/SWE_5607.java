package SWE.month_202104.day_20210420;

import java.util.Scanner;

public class SWE_5607 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int t=1; t<=TC; t++)
		{
			
			int N=sc.nextInt();
			int R=sc.nextInt();
			
			System.out.println("#"+t+" "+nCr(N,R,1234567891));
			
			
		}
		
	}
	public static long nCr(int n, int r, int p) {
		if(r==0)
			return 1L;
		long[] fac=new long[n+1];
		fac[0]=1;
		
		for(int i=1; i<=n; i++) {
			fac[i]=fac[i-1]*i%p;
		}
		
		return(fac[n]*power(fac[r],p-2,p)%p*power(fac[n-r],p-2,p)%p)%p;
	}
	public static long power(long x, long y, long p) {
		long res=1L;
		x=x%p;
		while(y>0) {
			if(y%2==1)
				res=(res*x)%p;
			y=y>>1;
		x=(x*x)%p;
		}
		return res;
	}
}
