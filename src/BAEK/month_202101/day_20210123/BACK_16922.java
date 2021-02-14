package BAEK.month_202101.day_20210123;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BACK_16922 {
	private final static int[] number= {1,5,10,50};
	private static int answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		
		
	}
	private static void solution(int n) {
		answer=0;
		result(n,0,0,new boolean [1001]);
		System.out.println(answer);
	}
	private static void result(int n, int sum, int idx, boolean[] visit) {
		
		if(n==0) {
			if(!visit[sum]){//아직 합의 결과가 안나왔으면
				
				visit[sum]=true;
				answer++;
			}
		}
		
		for(int i=idx; i<4; i++) {
			result(n-1,sum+number[i],i,visit);
		}
			
		
	}

}
