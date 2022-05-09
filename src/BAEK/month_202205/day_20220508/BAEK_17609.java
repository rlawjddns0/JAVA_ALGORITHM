package BAEK.month_202205.day_20220508;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_17609 {
	public static void main(String[] args) throws IOException {
		int N=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<N; i++) {
			String input=br.readLine();
			sb.append(solution(input)+"\n");
		}
		System.out.println(sb);
		
	}

	private static int solution(String input) {
		int left=0;
		int right=input.length()-1;
		
		
		while(left<right) {
			
			if(input.charAt(left)==input.charAt(right)) {
				left++;
				right--;
				continue;
			}else if(input.charAt(left)!=input.charAt(right)) {
				int tmpLeft=left;
				int tmpRight=right;
				tmpLeft++;
				boolean leftFlag=true;
				boolean rightFlag=true;
				while(tmpLeft<tmpRight) {
					if(input.charAt(tmpLeft)==input.charAt(tmpRight)) {
						tmpLeft++;
						tmpRight--;
						continue;
					}else {
						leftFlag=false;
						break;
					}
				}
				if(leftFlag)return 1;
				tmpLeft=left;
				tmpRight=right;
				tmpRight--;
				while(tmpLeft<tmpRight) {
					if(input.charAt(tmpLeft)==input.charAt(tmpRight)) {
						tmpLeft++;
						tmpRight--;
						continue;
					}else {
						rightFlag=false;
						break;
					}
				}
				if(rightFlag)return 1;
				else if(!leftFlag&&!rightFlag)return 2;
				
			}
			
		}
		
		
		
		
		
		
		
		
		return 0;
	}
}
