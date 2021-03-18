package BAEK.month_202103.day_20210318;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_3079 {
	static long N,M;
	static long[] check;
	static long max;
	static long min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextLong();
		M=sc.nextLong();
		check=new long[(int) N];
		for(int i=0; i<N; i++) {
			check[i]=sc.nextInt();
			max=Math.max(check[i],max);//right ���� �Ϸ��� //���� ���� �ɸ��� �ɻ�뿡 M���� ���� �װ� �ð��� �ִ밪
		}
		//Arrays.sort(check);
		
		
		result();
		
		System.out.println(min);
		
		
		
	}
	private static void result() {
		
		long left=0;
		long right=max*M ;
		
		while(left<=right) {
			long mid=(left+right)/2;
			long sum=0;
			for(int i=0; i<check.length; i++) {
				long count=mid/check[i];
				sum+=count;
				if(sum>=M)break;//�̹� �ο��� �Ѱ����Ƿ� �� �ʿ� ����
				
			}
			
			if(sum>=M) {//�ӿ��� ����->�ð� ������ �۾����� ��
				
				right=mid-1;
				min=Math.min(min, mid);
				
			}
			else {
				left=mid+1;
			}
		
		}
		
	}

}
