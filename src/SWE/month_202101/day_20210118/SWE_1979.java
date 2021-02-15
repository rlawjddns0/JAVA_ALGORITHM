package SWE.month_202101.day_20210118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_1979 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb=new StringBuffer();
		int testCase=Integer.parseInt(br.readLine());
		for(int i=0; i<testCase; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());//N*N
			int word=Integer.parseInt(st.nextToken());//湲��옄 �겕湲�
			int[][] arr=new int[N][N];
			for(int j=0; j<N; j++) {
				st=new StringTokenizer(br.readLine()," ");
				for(int k=0; k<N; k++) {
					arr[j][k]=Integer.parseInt(st.nextToken());//諛곗�? �엯�젰諛쏄�?
				}
			}
			
			int count=0;
			int result=0;
			for(int q=0; q<N; q++) {//�뻾 寃��궗
				count=0;
				for(int w=0; w<N; w++) {
					
					
					if(arr[q][w]==1)
						count++;
					else {
						if(count==word) {
							result++;
							count=0;
						}
							count=0;
					}
					
					
					
				}
				if(count==word) {
						result++;
					}
				System.out.println(result);
				
			}
		
			
			for(int q=0; q<N; q++) {//�뿴 寃��궗
				count=0;
				for(int w=0; w<N; w++) {										
					if(arr[w][q]==1)
						count++;
					else {
						if(count==word) {
							result++;
							count=0;
						}
						count=0;
					}
					
					
				}
				if(count==word) {
					result++;
				}
				System.out.println(result);
				
			}
			
			
			sb.append("#").append(i+1).append(" ").append(result).append("\n");
	
			
			
			
		}
		System.out.println(sb);
		
	}

}
