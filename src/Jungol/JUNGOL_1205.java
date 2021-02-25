package Jungol;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JUNGOL_1205 {
	static boolean[]visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scann=new Scanner(System.in);
        boolean[] nums = new boolean[1000001];
        int N= scann.nextInt();
        int jokers = 0;  //조커의 개수
        //조커의 개수+ 있는 카드
        for (int i = 0; i < N; i++) {
			int nn=scann.nextInt();
			if(nn==0) {
				jokers++;
			}else {
				nums[nn]=true;
			}
		}
        //길이 =최소 조커수
        int maxL=jokers;
        int len=0;
        Queue<Integer> joker=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]) {  // 받은 카드
				len++;
			}else {        // 조커를 넣을 수 있는 카드
				if(joker.size()<jokers) {
					len++;
					joker.offer(i);
				}else {
					if(!joker.isEmpty()) {
						len=i -joker.poll();
						joker.offer(i);
					}else {
						len=0;
					}
				}
			}
			maxL=Math.max(maxL, len);
		}
        System.out.println(maxL);
		
		
		
	}

}
