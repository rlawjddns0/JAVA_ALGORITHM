package BAEK.month_202102.day_20210219;

import java.util.Scanner;

public class BAEK_18512 {
	static int[] check=new int[10000208];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int X=sc.nextInt();
		int Y=sc.nextInt();
		int p1=sc.nextInt();
		int p2=sc.nextInt();
		
		int sumX=p1;
		int sumY=p2;
		
		System.out.println(solve(X,Y,p1,p2));
		
	}
	public static int solve(int X, int Y, int p1, int p2) {
		check[p2]=1;//시작점 넣고 시작
		for(int i=1; i<=100000; i++) {
			check[p2+(i*Y)]=1;
		}
		
		if(check[p1]==1)return p1;//시작이 같으면 바로 리턴
		else check[p1]=1;
		for(int i=1; i<=100000; i++) {
			if(check[p1+(i*X)]==1) {
				return p1+(i*X);
			}
		}
		
		
		
		
		
		return -1;
	}

}
