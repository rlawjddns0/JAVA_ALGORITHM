package BAEK.month_202111.day_20211116;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BAEK_10871 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int N,X;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		
		N=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		
		
		int[] arr=new int[N];
		st=new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(arr[i]<X)System.out.print(arr[i]+" ");
		}
		
//		for(int i=0; i<N; i++) {
//			if(arr[i]<X)System.out.print(arr[i]+" ");
//		}
		
		
	}

}
