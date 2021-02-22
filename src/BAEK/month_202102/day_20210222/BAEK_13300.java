package BAEK.month_202102.day_20210222;

import java.util.Arrays;
import java.util.Scanner;

public class BAEK_13300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int ans=0;
		stu[] st= new stu[7];
		//0여학생 1남학생
		for(int i=0; i<N; i++) {
			int s=sc.nextInt();
			int grade=sc.nextInt();
			if(st[grade]==null) {
				st[grade]=new stu(s);
			}
			else st[grade].count(s);
		}

		//Arrays.sort(st);
//		for(int i=1; i<=6; i++) {
//			if(st[i]!=null)System.out.println(i+"학년:"+st[i].toString());
//		}
		for (int i = 1; i <= 6; i++) {
			if(st[i]==null)continue;
			if(st[i].man!=0) {
				ans+=Math.ceil(1.0*st[i].man/K);
			}
			
			if(st[i].woman!=0) {
				ans+=Math.ceil(1.0*st[i].woman/K);
			}
		}
		System.out.println(ans);
		
	}

}
class stu{
	int man;
	int woman;
	//int grade;
	stu(int s){
		if(s==1)man++;
		else woman++;
	}
	public void count(int s) {
		if(s==1)man++;
		else woman++;
	}
	
	@Override
	public String toString() {
		return "stu [man=" + man + ", woman=" + woman +  "]";
	}
	
	
	
}