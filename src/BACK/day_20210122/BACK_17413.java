package BACK.day_20210122;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BACK_17413 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();//한줄로 입력 받기
		char[] arr=new char[str.length()];
		arr=str.toCharArray();//다시 char형으로 하나씩 배열에 저장
		
		
//		for(int i=0; i<str.length(); i++)
//			System.out.println(arr[i]);
		boolean flag=false;
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<arr.length; i++) {
			Stack<Integer> stack=new Stack<Integer>();
			if(arr[i]=='<')
			{
				flag=true;
			}
			else if(arr[i]=='>')
			{
				flag=false;
			}
			else if(flag==false&&arr[i]>='a'&& arr[i]<='z'|| flag==false &&arr[i]>='0'&& arr[i]<='9') {//문자면
				//int tmpi=i;//6
				while(i<arr.length && arr[i]!=' ' &&arr[i]!='<')
				{
					stack.push((int)(arr[i]));
					i++;
				}
				
				while(stack.size()!=0) {
					int tp=stack.pop();
					System.out.print((char)(tp));
					
				}
				if(i<arr.length && arr[i]=='<')
					flag=true;
				
			}
			
			
			
			if(flag==true&&i<arr.length) {
				System.out.print(arr[i]);
			}
			else if(flag==false&&i<arr.length)
			{
				System.out.print(arr[i]);
			}
						
			
			
			
			
		}
			
	}

}
