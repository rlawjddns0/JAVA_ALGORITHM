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
        int jokers = 0;  //��Ŀ�� ����
        //��Ŀ�� ����+ �ִ� ī��
        for (int i = 0; i < N; i++) {
			int nn=scann.nextInt();
			if(nn==0) {
				jokers++;
			}else {
				nums[nn]=true;
			}
		}
        //���� =�ּ� ��Ŀ��
        int maxL=jokers;
        int len=0;
        Queue<Integer> joker=new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]) {  // ���� ī��
				len++;
			}else {        // ��Ŀ�� ���� �� �ִ� ī��
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
