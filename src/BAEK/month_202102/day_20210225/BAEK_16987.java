package BAEK.month_202102.day_20210225;

import java.util.Scanner;

public class BAEK_16987 {
	static int N;
	static egg[] e;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sdf");
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		e=new egg[N];
		egg[] tmp=new egg[N];
		for(int i=0; i<N; i++) {
			e[i]=new egg(sc.nextInt(),sc.nextInt());
		}
		
		for(int i=0; i<N; i++) {
			solve(e[i]);
		}
		
		
	}
	public static void solve(egg e) {
		
	
	}

}
class egg{
	int d;
	int w;
	egg(int d, int w){
		this.d=d;
		this.w=w;
	}
	
}