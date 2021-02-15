package SWE.month_202102.day_20210205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWE_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		
		for(int t=1; t<=testCase; t++) {
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int num1=0;
			int num2=0;
			if(N%2==0) {
				num1=N/2;
				num2=N/2;
				
			}
			else {
				num1=N/2+1;
				num2=N/2;
				
			}
			Queue<String> q1=new LinkedList<String>();
			Queue<String> q2=new LinkedList<String>();

			for(int i=0; i<num1; i++) {
				q1.offer(st.nextToken());
			}
			for(int i=0; i<num2; i++) {
				q2.offer(st.nextToken());
			}
			
			
			
			
			boolean flag=true;
			System.out.print("#"+t+" ");
			for(int i=0; i<N; i++)
			{
				if(flag) {
					System.out.print(q1.poll()+" ");
					flag=false;
				}
				else
				{
					System.out.print(q2.poll()+" ");
					flag=true;
				}
			}
			System.out.println();
			
		
			
			
			
			
		}
	}

}
