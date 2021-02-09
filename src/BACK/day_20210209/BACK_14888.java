package BACK.day_20210209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_14888 {
	static int N;
	static int[] op;
	static int[] num;
	static int Max=Integer.MIN_VALUE,Min=Integer.MAX_VALUE;
	//static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		num=new int[N];
		for(int i=0; i<N; i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		op=new int[4];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<4; i++) {
			op[i]=Integer.parseInt(st.nextToken());
		}
		int sum=num[0];
		result(op[0],op[1],op[2],op[3],1, sum);//int plus, int minus int surplus int divide int k, int sum
		System.out.println(Max);
		System.out.println(Min);
	}
	static public void result(int P, int M, int S, int D, int k, int sum){
		if(k==N) {
			if(Max<sum) {
				Max=sum;
			}
			if(Min>sum) {
				Min=sum;
			}
			
		}
		
		if(P>0) {
			int temp=sum;
			sum+=num[k];
			result(P-1,M,S,D,k+1,sum);
			sum=temp;
		}
		if(M>0) {
			int temp=sum;
			sum-=num[k];
			result(P,M-1,S,D,k+1,sum);
			sum=temp;
		}
		if(S>0) {
			int temp=sum;
			sum*=num[k];
			result(P,M,S-1,D,k+1,sum);
			sum=temp;
		}
		if(D>0) {
			int temp=sum;
			sum/=num[k];
			result(P,M,S,D-1,k+1,sum);
			sum=temp;
		}
	}

}
