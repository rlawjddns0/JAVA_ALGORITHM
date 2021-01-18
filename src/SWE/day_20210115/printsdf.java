package SWE.day_20210115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class printsdf {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());//테스트 케이스
		StringTokenizer st;
		
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			sb.append("#").append(i+1).append(" ").append(a/b).append(" ").append(a%b).append("\n");
		}
		
		
		System.out.println(sb);
		
	}

}
