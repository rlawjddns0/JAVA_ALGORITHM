package BAEK.month_202101.day_20210126;

import java.util.Scanner;

/** 
 * 
 * 입력
첫째 줄에 블록의 가로의 길이와 세로의 길이가 차례로 주어진다.
 둘째 줄에 상점의 개수가 주어진다. 
 블록의 가로의 길이와 세로의 길이, 상점의 개수는 모두 100이하의 자연수이다. 
 이어 한 줄에 하나씩 상점의 위치가 주어진다. 
 상점의 위치는 두 개의 자연수로 표시된다. 
 첫째 수는 상점이 위치한 방향을 나타내는데, 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽에 상점이 있음을 의미한다. 
 둘째 수는 상점이 블록의 북쪽 또는 남쪽에 위치한 경우 블록의 왼쪽 경계로부터의 거리를 나타내고, 상점이 블록의 동쪽 또는 서쪽에 위치한 경우 블록의 위쪽 경계로부터의 거리를 나타낸다. 
 마지막 줄에는 동근이의 위치가 상점의 위치와 같은 방식으로 주어진다. 
 상점의 위치나 동근이의 위치는 블록의 꼭짓점이 될 수 없다.
 * 
 * 
 * 출력
	첫째 줄에 동근이의 위치와 각 상점 사이의 최단 거리의 합을 출력한다.
 * */

public class BACK_2564 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int num=sc.nextInt();//상점 갯수
		int[][] arr=new int[num][2];
		for(int i=0; i<num; i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		
		int[] dongGun =new int[2];
		dongGun[0]=sc.nextInt();
		dongGun[1]=sc.nextInt();
		
		
//		for(int i=0; i<num; i++) {
//			for(int j=0; j<2; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println(dongGun[0]);
//		System.out.println(dongGun[1]);
//		
		int result=0;
		if(dongGun[0]==1) {//북
			for(int i=0; i<num; i++) {
				if(arr[i][0]==1) {
					result+=Math.abs(arr[i][1]-dongGun[1]);
				}
				else if(arr[i][0]==2){
					int a=M+arr[i][1]+dongGun[1];//왼쪽 기준
					int b=M+(N-arr[i][1])+(N-dongGun[1]);//오른쪽 기준
					result+=Math.min(a, b);
				}
				else if(arr[i][0]==3) {
					result+=dongGun[1]+arr[i][1];
				}
				else {
					result+=(N-dongGun[1]+arr[i][1]);
				}
			}
		}
		else if(dongGun[0]==2) {//남
			for(int i=0; i<num; i++) {
				if(arr[i][0]==1) {
					int a=M+arr[i][1]+dongGun[1];//왼쪽 기준
					int b=M+(N-arr[i][1])+(N-dongGun[1]);//오른쪽 기준
					result+=Math.min(a, b);
				}
				else if(arr[i][0]==2){//남
					result+=Math.abs(arr[i][1]-dongGun[1]);
				}
				else if(arr[i][0]==3) {//서
					result+=dongGun[1]+(M-arr[i][1]);					
				}
				else {
					result+=N-dongGun[1]+ M-arr[i][1];
				}
			}
			
		}
		else if(dongGun[0]==3) {//서
			for(int i=0; i<num; i++) {
				if(arr[i][0]==1) {
					result+=dongGun[1]+arr[i][1];
				}
				else if(arr[i][0]==2){
					result+=M-dongGun[1]+arr[i][1];
				}
				else if(arr[i][0]==3) {
					result+=Math.abs(dongGun[1]-arr[i][1]);
				}
				else {
					int a=N+arr[i][1]+dongGun[1];//위쫃
					int b=N+(M-arr[i][1])+(M-dongGun[1]);//아래쪽 기준
					result+=Math.min(a, b);
				}
			}
		}
		else {//동
			for(int i=0; i<num; i++) {
				if(arr[i][0]==1) {
					result+=dongGun[1]+N-arr[i][1];
				}
				else if(arr[i][0]==2){
					result+=M-dongGun[1]+N-arr[i][1];
				}
				else if(arr[i][0]==3) {
					int a=N+arr[i][1]+dongGun[1];//위쫃 기준
					int b=N+(M-arr[i][1])+(M-dongGun[1]);//아래쪽 기준
					result+=Math.min(a, b);
				}
				else {
					result+=Math.abs(dongGun[1]-arr[i][1]);
				}
			}
		}

		
		
		
		
		
		
		System.out.println(result);
		
		
		
		
		
	}

}
