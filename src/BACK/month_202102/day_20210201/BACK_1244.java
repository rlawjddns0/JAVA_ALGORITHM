package BACK.month_202102.day_20210201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BACK_1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int numOfSwitch=Integer.parseInt(br.readLine());//스위치 개수 받기
		int[] arr=new int[numOfSwitch];
		
		st=new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<numOfSwitch; i++)
			arr[i]=Integer.parseInt(st.nextToken());//스위치 초기 상태 입력 받기
		
		int studentOfNum=Integer.parseInt(br.readLine());
		int[][] students=new int [studentOfNum][2];//1.성별 2.스위치 번호
		
		
		for(int i=0; i<studentOfNum; i++) {
			st=new StringTokenizer(br.readLine()," ");
			students[i][0]=Integer.parseInt(st.nextToken());
			students[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<studentOfNum; i++) {
			if(students[i][0]==1) {//남학생
				int tp=students[i][1];
				int a=students[i][1];
				while((a-1)<numOfSwitch)
				{
					
					if(arr[a-1]==1) {
						arr[a-1]=0;
					}
					else
					{
						arr[a-1]=1;
					}
					a+=tp;
					
				}
			}
			else {//여학생
				int a=students[i][1];
				int front=(a+1);
				int rear=(a-1);
				boolean flag=false;
				while((front-1)<numOfSwitch && (rear-1)>=0) {
					if(arr[front-1]==arr[rear-1]) {
						if(arr[front-1]==0) {
							arr[front-1]=1;
							arr[rear-1]=1;
						}
						else
						{
							arr[front-1]=0;
							arr[rear-1]=0;
						}
						flag=true;
					}
					else {
						break;
					}
					
				
					++front;
					--rear;
				}
				if(arr[a-1]==0) {
					arr[a-1]=1;
				}
				else {
					arr[a-1]=0;
				}
				
			}
				
		}
		
		
		for(int i=0; i<arr.length; i++) {
			if((i)%20==0 &&i!=0) {
				System.out.println();
			}
			System.out.print(arr[i]+" ");
		}
	
	}

}
