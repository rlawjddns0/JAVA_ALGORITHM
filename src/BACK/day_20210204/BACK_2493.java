package BACK.day_20210204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/** 
 * 다시 풀어보기~~
 * 오른쪽 부터 비교가 아닌 왼쪽부터 비교
 * 현재 들어온 탑의 높이가 스택에 있던 탑의 높이보다 높으면 스택에 있던 탑과 인덱스 팦 해주고 더 높은 탑을 스택에 넣어준다
 * 작으면 현재 들어 있는 탑의 인덱스 출력
 * 
 * 
 * */
public class BACK_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		Stack<Integer> stack=new Stack<Integer>();
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		Stack<Integer> idx=new Stack<Integer>();
		StringBuffer sb=new StringBuffer();
		
		stack.push(Integer.parseInt(st.nextToken()));
		idx.push(1);//처음꺼 집어넣어주고 시작
		sb.append("0 ");
		for(int i=2; i<=N; i++) {
			int value=Integer.parseInt(st.nextToken());
			
			
			while(!stack.isEmpty()) {
				if(value<stack.peek()) {
					sb.append(idx.peek()+" ");
					break;
				}
				stack.pop();
				idx.pop();
				
			}
			if(stack.isEmpty()) {
				sb.append("0 ");
			}
			stack.push(value);
			idx.push(i);
		}
		System.out.println(sb);
			
		
		
		
		
	}

}
