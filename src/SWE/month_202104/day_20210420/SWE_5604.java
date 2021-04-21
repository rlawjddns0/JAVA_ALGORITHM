//package SWE.month_202104.day_20210420;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class SWE_5604 {
//	static String A, B;
//	public static void changeA() {
//		while (true) {
//			if (A.charAt(A.length() - 1) == '9') {
//				for (int i = 0; i < A.length(); i++) {
//					sum += A.charAt(i) - '0';
//				}
//				long tmp = Long.parseLong(A);
//				tmp++;
//				A = Long.toString(tmp);
//				break;
//			}
//			for (int i = 0; i < A.length(); i++) {
//				sum += A.charAt(i) - '0';
//			}
//			long tmp = Long.parseLong(A);
//			tmp++;
//			A = Long.toString(tmp);
//		}
//	}
//	public static void changeB() {
//		while (true) {
//			if (B.charAt(B.length() - 1) == '0') {
//				for (int i = 0; i < B.length(); i++) {
//					sum += B.charAt(i) - '0';
//				}
//				long tmp = Long.parseLong(B);
//				tmp--;
//				B = Long.toString(tmp);
//				break;
//			}
//
//			for (int i = 0; i < B.length(); i++) {
//				sum += B.charAt(i) - '0';
//			}
//			long tmp = Long.parseLong(B);
//			tmp--;
//			B = Long.toString(tmp);
//
//		}
//	}
//	static int sum=0;
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		int TC = sc.nextInt();
//
//		for (int t = 1; t <= TC; t++) {
//			A = sc.next();
//			B = sc.next();
//			sum = 0;
//			
//			
//			changeA();
//			changeB();
//			long a = Long.parseLong(A);
//			long b = Long.parseLong(B);
//			sum += ((b - a + 1) / 10) * 45;
////			// for(int i=0; )
////			if (A.length() > 1 && B.length() > 1) {
////				for (long i = Long.parseLong(A.substring(0, A.length()-1)); i <= Long.parseLong(B.substring(0, B.length()-1)); i++) {
////					for(int j=0; j<Long.toString(i).length(); j++) {
////						sum+=(Long.toString(i).charAt(j)-'0')*10;
////					}
////				}
////			}
//			long mul=1;
//			long[] number=new long[10];
//			b/=10;
//			a/=10;
//			while(a<=b) {
//				long diff=(b/10-a/10)+1;
//				System.out.println(diff);
//				if(a>b)break;
//				for(int i=0; i<10; i++) {
//					number[i]+=diff*mul;
//				}
//				mul*=10;
//				a/=10;
//				b/=10;
//				
//			}
//			System.out.println(Arrays.toString(number));
//			for (int i = 1; i < 10; i++)
//				sum += (i * number[i]);
//			System.out.println("#" + t + " " + sum);
//
//		}
//
//	}
//
//}
