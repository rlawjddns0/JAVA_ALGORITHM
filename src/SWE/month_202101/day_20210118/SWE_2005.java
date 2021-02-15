package SWE.month_202101.day_20210118;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWE_2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
        StringTokenizer st;
        int result[]=new int[testCase];
        for(int i=0; i<testCase; i++){
            st=new StringTokenizer(br.readLine(), " ");
            int N=Integer.parseInt(st.nextToken());//N �엯�젰 諛쏄�?
            int M=Integer.parseInt(st.nextToken());//M �엯�젰 諛쏄�?
            int count=N-M+1;//�뙆?��?�콈 理쒕�? ��吏곸?�� �닔 �엲�뒗 �슏�닔
            int arr[][]=new int [N][N];
            for(int j=0; j<N; j++){//諛곗�? �엯�젰 諛쏄�?
                st=new StringTokenizer(br.readLine());
                for(int k=0; k<N; k++){
                    arr[j][k]=Integer.parseInt(st.nextToken());
                }
            }
            int max=0;
            for(int q=0; q<count; q++) {
            	
	            for(int j=0; j<count; j++)
	            {
	            	int temp=0;
	                for(int k=0; k<M; k++) {
	                	for(int p=0;p<M; p++)
	                	{
	                		temp+=arr[q+k][j+p];
	                		
	                	}
	                }
	                if(max<temp)
	        			max=temp;
	                
	            }
	            result[i]=max;
            }



        }
        
        
        
        for(int i=0; i<testCase; i++)
        {
        	System.out.printf("#%d %d",i+1,result[i]);
        	System.out.println();
        }
        
        
        
        
    }
}