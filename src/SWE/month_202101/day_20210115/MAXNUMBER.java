package SWE.month_202101.day_20210115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MAXNUMBER {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		int testCase;//�׽�Ʈ ���̽�
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		testCase=Integer.parseInt(br.readLine());//test case �ޱ�
		
		String arr[]=new String[testCase];
        StringTokenizer st;
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<testCase; i++) {
            st=new StringTokenizer(br.readLine()," ");
            int max=0;
           
            for(int j=0; j<10; j++) {
				int num=Integer.parseInt(st.nextToken());
				if(max<num)
					max=num;
			}
			sb.append("#").append(i+1).append(" ").append(max).append("\n");//string format ����Ͽ� �Ҽ��� ǥ��
            
             
        }
        
        System.out.println(sb);
       
		
	}

}
