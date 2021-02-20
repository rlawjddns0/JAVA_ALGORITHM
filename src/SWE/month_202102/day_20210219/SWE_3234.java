package SWE.month_202102.day_20210219;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWE_3234 {
	static int right;
	static int left;
	//static int[] weight;
	static int ans;
	static int N;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("SWE_3234.txt"));
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for(int t=1; t<=TC; t++) {
			ans=0;
			
			N=sc.nextInt();
			int[] weight=new int[N];
			for(int i=0; i<N; i++)
			{
				weight[i]=sc.nextInt();
			}
			
			permutation(weight,0,0,0,new boolean[N]);
			
			
			
			
			System.out.println("#"+t+" "+ans);
			
			
		}

	}
	static int count;
	public static void permutation(int[] weight,int left,int right,int idx, boolean[] v) {
		if(right>left)return;
		if(idx==weight.length) {
			ans++;
			
			return;
			
		}
		
		for(int i=0; i<weight.length; i++) {
			if(v[i])continue;
			v[i]=true;
			permutation(weight,left+weight[i],right,idx+1,v);//순열 안에서 파워셋??
			permutation(weight,left,right+weight[i],idx+1,v);
			v[i]=false;
		}
		
	}

}
