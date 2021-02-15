package SWE.month_202101.day_20210118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWE_1926 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringBuffer sb= new StringBuffer();
		for(int i=1; i<=N; i++) {
			String n=Integer.toString(i);
			
			
			if(n.contains("3") || n.contains("6") || n.contains("9"))
			{
				n=n.replace("3","-");
				n=n.replace("6","-");
				n=n.replace("9","-");	
				n=n.replace("1","");
				n=n.replace("2","");
				n=n.replace("4","");
				n=n.replace("5","");
				n=n.replace("7","");
				n=n.replace("8","");
				n=n.replace("0","");

			}
				sb.append(n).append(" ");
			
			
			
			
		}
		
		
		
		System.out.println(sb.toString().trim());
	}

}
