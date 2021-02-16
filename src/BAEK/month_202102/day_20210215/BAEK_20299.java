package BAEK.month_202102.day_20210215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_20299 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		StringBuffer sb=new StringBuffer();
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		int count=0;
		for(int i=0; i<N; i++) {
			StringTokenizer st1=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st1.nextToken());
			int b=Integer.parseInt(st1.nextToken());
			int c=Integer.parseInt(st1.nextToken());
			
			if(a<L ||b<L || c<L)continue;
			if(a+b+c<K)continue;
			
			count++;
			sb.append(a+" "+b+" "+c+" ");
			
		}
		System.out.println(count);
		System.out.println(sb);
		
		
		
	}

}
