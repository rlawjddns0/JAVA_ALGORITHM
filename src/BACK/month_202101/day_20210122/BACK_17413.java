package BACK.month_202101.day_20210122;

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
		boolean flag=false;//< 나오는지 안나오는지
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<arr.length; i++) {
			Stack<Integer> stack=new Stack<Integer>();
			if(arr[i]=='<')//꺽ㅈ쇠가 열리면 참
			{
				flag=true;
			}
			else if(arr[i]=='>')//꺽쇠가 닫히면 거짓 
			{
				flag=false;
			}
			else if(flag==false&&arr[i]>='a'&& arr[i]<='z'|| flag==false &&arr[i]>='0'&& arr[i]<='9') {//문자면
				//int tmpi=i;//6
				while(i<arr.length && arr[i]!=' ' &&arr[i]!='<')//공백이나 < 나오기 전까지 스택에 집어넣는다
				{
					stack.push((int)(arr[i]));
					i++;
				}
				
				while(stack.size()!=0) {//스택 다 pop
					int tp=stack.pop();
					System.out.print((char)(tp));//스택은 LIFO라서 문자가 거꾸로 나온다
					
				}
				if(i<arr.length && arr[i]=='<') { //< 나오면 flag true <asa>ccc<asa>
					flag=true;
					
				}
			}
			
			
			
			if(flag==true&&i<arr.length) {//꺽쇠가 열리 부분 이후는 그냥 출력 해주면 된다
				System.out.print(arr[i]);
			}
			else if(flag==false&&i<arr.length)//공백 문자를 출력하는 부분<as>asdf adads<asdf>
			{
				System.out.print(arr[i]);
			}
						
			
			
			
			
		}
			
	}

}
