package SWE.day_20210118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SWE_1983 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		StringTokenizer st;
		int ratio=0;
		StringBuffer sb=new StringBuffer();
		String[] js={"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
		for (int i = 0; i < testCase; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());//�븰�깮 �닔
			int K=Integer.parseInt(st.nextToken());//�븣?�� �떢�� �븰�깮	
			String[] result=new String[N];
			ratio=N/10;//?��꾩쑉
			HashMap<Integer,Double>map=new HashMap<Integer,Double>();
			Double arr[] = new Double[N];
			for(int j=0; j<N; j++) {	
				st=new StringTokenizer(br.readLine()," ");
				int middle=Integer.parseInt(st.nextToken());
				int Final=Integer.parseInt(st.nextToken());
				int HW=Integer.parseInt(st.nextToken());
				double score=middle*0.35+Final*0.45+HW*0.2;//?��?��?��
				arr[j]=score;
				map.put(j, arr[j]);
			}
			Arrays.sort(arr);
			HashMap<Double,String>score=new HashMap<Double,String>();
			int l=0;
			int count=0;
			for(int p=arr.length-1; p>=0; p--) {
				
				if(count>=ratio) {
					l++;
					count=0;
				}
				score.put(arr[p], js[l]);
				count++;
				
			}
			
			
					
		
			
			
			sb.append("#").append(i+1).append(" ").append(score.get(map.get(K-1))).append("\n");
			
		}
		
		
		System.out.println(sb);
		
		
	}

}
