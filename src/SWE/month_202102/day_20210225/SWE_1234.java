package SWE.month_202102.day_20210225;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SWE_1234 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		for(int t=1; t<=10; t++) {
			ArrayList<Integer> arr=new ArrayList<Integer>();
			int N=sc.nextInt();
			String str=sc.next();
			for(int i=0; i<str.length(); i++) {
				char tmp=str.charAt(i);
				arr.add((int)tmp-48);
			}
			for(int i=0; i<arr.size()-1; i++) {
				if(arr.get(i)==arr.get(i+1)) {
					arr.remove(i);
					arr.remove(i);
					i=-1;
					if(arr.size()==1)break;
				}
			}
			
			System.out.print("#"+t+" ");
			for(int i=0; i<arr.size(); i++) {
				System.out.print(arr.get(i));
			}
			System.out.println();
			
		}
	}

}
