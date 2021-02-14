package BACK.month_202102.day_20210209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_14888 {
	static int N;
	static int[] operator;
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
		
		operator=new int[4];
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<4; i++) {
			operator[i]=Integer.parseInt(st.nextToken());
		}
		int sum=num[0];
		result(operator[0],operator[1],operator[2],operator[3],1, sum);//더하기 빼기 곱하기 나누기 합
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
			sum+=num[k];//계산 할 차례의 숫자
			result(P-1,M,S,D,k+1,sum);//sum을 같이 끌고 간다.
			sum=temp;//원래 돌아왔을때 다시 이용하기 위해서
			/*
			 * 생각해보니까
			 * 그냥
			 * result(P-1,M,S,D,k+1,sum+num[k])로 하면 될듯 
			 */
		}
		if(M>0) {
			int temp=sum;
			sum-=num[k];//빼기
			result(P,M-1,S,D,k+1,sum);
			sum=temp;
		}
		if(S>0) {
			int temp=sum;
			sum*=num[k];//곱하기
			result(P,M,S-1,D,k+1,sum);
			sum=temp;
		}
		if(D>0) {
			int temp=sum;
			sum/=num[k];//나누기
			result(P,M,S,D-1,k+1,sum);
			sum=temp;
		}
	}

}
