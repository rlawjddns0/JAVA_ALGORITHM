package SWE.month_202103.day_20210324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWE_3307 {
   
    
    public static void main(String[] args) throws IOException {
      
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	int T=Integer.parseInt(br.readLine());
    	
    	
    	for(int t=1; t<=T; t++) {
    		int n=Integer.parseInt(br.readLine());
    		int[] arr=new int[n];
    		StringTokenizer st=new StringTokenizer(br.readLine()," ");
    		
    		for(int i=0; i<n; i++) {
    			arr[i]=Integer.parseInt(st.nextToken());
    		}
    		int[] lis=new int[n];
    		int size=0;
    		for (int i = 0; i < n; i++) {
    			int temp=Arrays.binarySearch(lis,0,size,arr[i]);
    			temp=Math.abs(temp)-1;//중복값이 없으므로 탐색에 실패하고 음수값이 리턴
    			lis[temp]=arr[i];
    			
    			if(temp==size)//사이즈가 temp와 같단는것은 뒤에 추가
    			{
    				size++;
    			}
    		}
    		
    		Arrays.sort(lis);
    		System.out.println("#"+t+" "+size);
    		
    		
    		
    	}
    	
    	
    	
    }
}
