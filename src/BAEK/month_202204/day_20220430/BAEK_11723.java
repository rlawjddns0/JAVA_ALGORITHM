package BAEK.month_202204.day_20220430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int M=Integer.parseInt(br.readLine());
		StringBuffer sb=new StringBuffer();
		int[] num=new int[21];
		for(int i=0; i<M; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int n=0;
			String op=st.nextToken();
			if(op.equals("all") ||op.equals("empty")) {
				
			}else {
				n=Integer.parseInt(st.nextToken());
			}
			
			if("add".equals(op)) {
				if(num[n]==0)num[n]++;
			}else if("remove".equals(op)) {
				if(num[n]>0)num[n]=0;
				
			}else if("check".equals(op)) {
				if(num[n]>0)sb.append("1\n");
				else sb.append("0\n");
			}else if("toggle".equals(op)) {
				if(num[n]>0)num[n]=0;
				else if(num[n]==0)num[n]=1;
			}else if("all".equals(op)) {
				for(int j=1; j<21; j++) {
					num[j]=1;
				}
			}else if("empty".equals(op)) {
				for(int j=1; j<21; j++) {
					num[j]=0;
				}
			}
			
			
		}
		
		System.out.println(sb);
		
		
		
	}
}
