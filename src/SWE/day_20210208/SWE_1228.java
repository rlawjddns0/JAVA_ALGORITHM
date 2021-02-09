package SWE.day_20210208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class SWE_1228 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int t=1; t<=10; t++) {
			int num=Integer.parseInt(br.readLine());
			LinkedList<String> arr=new LinkedList<String>();//원본 암호문
			//System.out.println(num);
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0; i<num; i++) {
				String tp=st.nextToken();
				arr.add(i,tp);
			}//원본 암호문 읽고
			int order=Integer.parseInt(br.readLine());//명령어의 갯수
			String[] str=new String[order];
			st=new StringTokenizer(br.readLine(),"I");
			
			for(int i=0; i<order; i++) {
				str[i]=st.nextToken();
			}
			//System.out.println(Arrays.toString(str));
			
			
			for(int i=0; i<order; i++) {
				StringTokenizer tmp=new StringTokenizer(str[i]," ");
				int index=Integer.parseInt(tmp.nextToken());//수정 할 위치
				//System.out.println(index);
				int n=Integer.parseInt(tmp.nextToken());//갯수
				//System.out.println(n);
				StringBuffer sb=new StringBuffer();
				for(int j=0,k=index; j<n; j++,k++) {
					arr.add(k, tmp.nextToken());
				}
				
			}
			
			System.out.print("#"+t+" ");
			for(int i=0; i<10; i++) {
				System.out.print(arr.get(i)+" ");
			}
			System.out.println();
			
			
		}
	}

}
